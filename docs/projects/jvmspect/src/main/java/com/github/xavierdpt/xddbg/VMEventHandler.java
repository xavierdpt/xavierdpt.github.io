package com.github.xavierdpt.xddbg;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;
import com.sun.jdi.Method;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.Event;

import java.util.Collections;

public class VMEventHandler implements VMEventHandlerI {

    private final XDDBG xddbg;

    public VMEventHandler(XDDBG xddbg) {
        this.xddbg = xddbg;
    }

    public void handleEvent(Event evt, VirtualMachine virtualMachine) {
        if (evt instanceof BreakpointEvent event) {
            xddbg.logLine("Breakpoint Hit! " + event.location());
            try {
                ThreadReference thread = event.thread();
                var currentFrame = thread.frame(0);
/*
                List<StackFrame> frames = thread.frames();
                for (StackFrame frame : frames) {
                    logLine(frame.location().toString());
                }

*/
                var argumentValues = currentFrame.getArgumentValues();
                for (int i = 0; i < argumentValues.size(); i++) {
                    Value value = argumentValues.get(i);
                    if (value instanceof ObjectReference objectReference) {
                        Method toString = null;
                        for (Method method : objectReference.referenceType().methodsByName("toString")) {
                            if (method.argumentTypeNames().size() == 0) {
                                toString = method;
                            }
                        }
                        boolean failed = true;
                        if (toString != null) {
                            try {
                                Value str = objectReference.invokeMethod(thread, toString, Collections.emptyList(), 0);
                                xddbg.logLine(" - #" + i + " " + str);
                                failed = false;
                            } catch (InvalidTypeException | ClassNotLoadedException |
                                     InvocationException ex) {
                                xddbg.logException(ex);
                            }
                        }
                        if (failed) {
                            xddbg.logLine(" - #" + i + " " + value);
                        }
                    } else {
                        xddbg.logLine(" - #" + i + " " + value);
                    }

                }
            } catch (IncompatibleThreadStateException ex) {
                xddbg.logException(ex);
            }
        } else {
            xddbg.logLine(evt.getClass().getSimpleName());
        }
    }

    @Override
    public void reportException(Exception exception) {
        xddbg.logException(exception);
    }
}
