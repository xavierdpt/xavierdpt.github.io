package com.github.xavierdpt.xddbg.utils;

import com.sun.jdi.Location;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.request.BreakpointRequest;
import com.sun.jdi.request.EventRequestManager;

public class VMHelper {
    public static void createMethodEntryRequest(VirtualMachine virtualMachine) {
        var eventRequestManager = virtualMachine.eventRequestManager();
        boolean found = false;
        for (var request : eventRequestManager.methodEntryRequests()) {
            if (!request.isEnabled()) {
                request.enable();
                found = true;
                break;
            }
        }
        if (!found) {
            eventRequestManager.createMethodEntryRequest();
        }
    }

    public static void deleteMethodEntryRequest(VirtualMachine virtualMachine) {
        var eventRequestManager = virtualMachine.eventRequestManager();
        for (var request : eventRequestManager.methodEntryRequests()) {
            eventRequestManager.deleteEventRequest(request);
        }
    }

    public static void createBreakpoint(VirtualMachine virtualMachine, Location location) {
        EventRequestManager eventRequestManager = virtualMachine.eventRequestManager();
        for (BreakpointRequest request : eventRequestManager.breakpointRequests()) {
            if (request.location().equals(location)) {
                if (!request.isEnabled()) {
                    request.enable();
                    return;
                }
            }
        }
        eventRequestManager.createBreakpointRequest(location).enable();
    }
}
