package com.github.xavierdpt.xddbg.utils;

public class XDDBGException extends Exception {
    public XDDBGException(String message) {
        super(message);
    }

    public XDDBGException(Exception cause) {
        super(cause);
    }
}
