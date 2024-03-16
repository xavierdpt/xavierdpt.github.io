package com.github.xavierdpt.jvmspect.utils;

public class ResourceUtils {
    public static String resourcePath(String resourcePath) {
        // TODO: When packaged into a .jar, this will behaves differently
        return "src/main/resources/" + resourcePath;
    }
}
