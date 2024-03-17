package com.github.xavierdpt.xddbg.utils;

public class ExceptionHelper {
    public static String toMultilineString(Exception ex) {
        StringBuilder sb = new StringBuilder();
        Throwable th = ex;
        do {
            String thMessage = th.getMessage();
            if (thMessage == null) {
                sb.append(th.getClass().getName());
            } else {
                sb.append(th.getClass().getName()).append(": ").append(thMessage);
            }
            sb.append("\n");
            th = th.getCause();
        } while (th != null && th.getCause() != th);
        return sb.toString();
    }
}
