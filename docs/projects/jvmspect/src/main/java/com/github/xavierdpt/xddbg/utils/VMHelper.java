package com.github.xavierdpt.xddbg.utils;

import com.sun.jdi.VirtualMachine;

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
}
