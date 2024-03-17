package com.github.xavierdpt.xddbg.discovery1;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.Bootstrap;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.Method;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.VMDisconnectedException;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.VirtualMachineManager;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import com.sun.jdi.connect.LaunchingConnector;
import com.sun.jdi.connect.VMStartException;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.event.LocatableEvent;
import com.sun.jdi.event.MethodEntryEvent;
import com.sun.jdi.event.MethodExitEvent;
import com.sun.jdi.event.StepEvent;
import com.sun.jdi.request.EventRequestManager;
import com.sun.jdi.request.MethodEntryRequest;
import com.sun.jdi.request.MethodExitRequest;
import com.sun.jdi.request.StepRequest;
import org.apache.commons.io.output.TeeOutputStream;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class XDMain {
    // Work in progress
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        TeeOutputStream outputStream = new TeeOutputStream(System.out, new FileOutputStream("debugout.xml"));
        PrintWriter pw = new PrintWriter(outputStream);
        try (StreamingXMLDebugWriter debugWriter = new StreamingXMLDebugWriter(outputStream)) {
            VirtualMachine virtualMachine;
            try {
                VirtualMachineManager virtualMachineManager = Bootstrap.virtualMachineManager();
                LaunchingConnector connector = virtualMachineManager.defaultConnector();
                var arguments = connector.defaultArguments();
                arguments.get("main").setValue(MyProgram.class.getName());
                virtualMachine = connector.launch(arguments);

                ProcessOutputPoller.poll(virtualMachine.process());
                getMethodEntryRequest(virtualMachine).enable();
                EventSet eventSet;
                while ((eventSet = virtualMachine.eventQueue().remove()) != null) {
                    for (Event e : eventSet) {
                        if (e instanceof MethodEntryEvent event) {
                            Method method = event.method();
                            if ("xd.MyProgram".equals(method.declaringType().name()) && "main".equals(method.name())) {
                                getMethodEntryRequest(virtualMachine).disable();
                                getMethodExitRequest(virtualMachine).enable();
                                getStepRequest(virtualMachine, event.thread()).enable();
                            }
                        }
                        if (e instanceof MethodExitEvent event) {
                            Method method = event.method();
                            if ("xd.MyProgram".equals(method.declaringType().name()) && "main".equals(method.name())) {
                                getStepRequest(virtualMachine, event.thread()).disable();
                            }
                        }
                        if (e instanceof StepEvent event) {
                            displayVariables(event, debugWriter, pw);
                        }
                    }
                    eventSet.resume();
                }
            } catch (VMDisconnectedException exception) {
                System.err.println("Virtual machine disconnected");
            } catch (IllegalConnectorArgumentsException | VMStartException | IOException | InterruptedException |
                     AbsentInformationException | IncompatibleThreadStateException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static MethodEntryRequest getMethodEntryRequest(VirtualMachine virtualMachine) {
        EventRequestManager eventRequestManager = virtualMachine.eventRequestManager();
        List<MethodEntryRequest> methodEntryRequests = eventRequestManager.methodEntryRequests();
        if (!methodEntryRequests.isEmpty()) {
            return methodEntryRequests.get(0);
        } else {
            return eventRequestManager.createMethodEntryRequest();
        }
    }

    private static MethodExitRequest getMethodExitRequest(VirtualMachine vm) {
        EventRequestManager eventRequestManager = vm.eventRequestManager();
        List<MethodExitRequest> methodExitRequests = eventRequestManager.methodExitRequests();
        if (!methodExitRequests.isEmpty()) {
            return methodExitRequests.get(0);
        }
        return eventRequestManager.createMethodExitRequest();
    }

    private static StepRequest getStepRequest(VirtualMachine vm, ThreadReference thread) {
        EventRequestManager eventRequestManager = vm.eventRequestManager();
        for (StepRequest stepRequest : eventRequestManager.stepRequests()) {
            if (stepRequest.thread().equals(thread)) {
                return stepRequest;
            }
        }
        return eventRequestManager.createStepRequest(thread, StepRequest.STEP_MIN, StepRequest.STEP_INTO);
    }

    public static void displayVariables(LocatableEvent event, StreamingXMLDebugWriter debugWriter, PrintWriter pw) throws IncompatibleThreadStateException, AbsentInformationException, XMLStreamException {
        debugWriter.writeEvent(event);
        pw.println();
    }

}
