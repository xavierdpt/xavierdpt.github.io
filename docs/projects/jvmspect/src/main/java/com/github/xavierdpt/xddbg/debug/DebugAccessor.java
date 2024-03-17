package com.github.xavierdpt.xddbg.debug;

import com.github.xavierdpt.xddbg.utils.XDDBGException;
import com.sun.jdi.Bootstrap;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.VirtualMachineManager;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventSet;

import java.io.IOException;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class DebugAccessor {
    private VirtualMachine virtualMachine;

    private final Object monitor = new Object();

    public DebugAccessor() {

    }

    public synchronized boolean isAttached() {
        synchronized (monitor) {
            return virtualMachine != null;
        }
    }


    public synchronized void attach(String port, Consumer<VirtualMachine> init, BiConsumer<Event, VirtualMachine> eventConsumer) throws XDDBGException {
        if (isAttached()) {
            throw new XDDBGException("Already attached!");
        }
        Objects.requireNonNull(eventConsumer, "Null event consumer");
        var virtualMachineManager = Bootstrap.virtualMachineManager();
        var connector = findConnector(virtualMachineManager);
        if (connector == null) {
            throw new XDDBGException("Couldn't find any suitable connector");
        }
        var arguments = connector.defaultArguments();
        arguments.get("hostname").setValue("localhost");
        arguments.get("port").setValue(port);
        try {
            synchronized (monitor) {
                if (virtualMachine != null) {
                    throw new IllegalStateException();
                }
                virtualMachine = connector.attach(arguments);
            }
            new Thread(() -> {
                synchronized (monitor) {
                    init.accept(virtualMachine);
                }
                while (true) {
                    VirtualMachine theVm;
                    synchronized (monitor) {
                        theVm = virtualMachine;
                    }
                    if (theVm != null) {
                        try {
                            EventSet eventSet = theVm.eventQueue().remove();
                            if (eventSet == null) {
                                break;
                            }
                            for (var event : eventSet) {
                                eventConsumer.accept(event, theVm);
                            }
                            eventSet.resume();
                        } catch (InterruptedException e) {
                            // Not sure what to do with that interruption...
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        break;
                    }
                }
            }).start();
        } catch (IOException | IllegalConnectorArgumentsException e) {
            throw new XDDBGException(e);
        }
    }

    private AttachingConnector findConnector(VirtualMachineManager virtualMachineManager) {
        for (var connector : virtualMachineManager.attachingConnectors()) {
            var arguments = connector.defaultArguments();
            if (arguments.containsKey("hostname") && arguments.containsKey("port")) {
                return connector;
            }
        }
        return null;
    }

    public synchronized void detach() {
        synchronized (monitor) {
            virtualMachine.dispose();
            virtualMachine = null;
        }
    }

    public <T> T accessVm(Function<VirtualMachine, T> access) {
        synchronized (monitor) {
            return access.apply(virtualMachine);
        }
    }
}
