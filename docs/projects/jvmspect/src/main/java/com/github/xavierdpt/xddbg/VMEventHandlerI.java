package com.github.xavierdpt.xddbg;

import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.Event;

public interface VMEventHandlerI {
    void handleEvent(Event event, VirtualMachine virtualMachine);

    void reportException(Exception e);
}
