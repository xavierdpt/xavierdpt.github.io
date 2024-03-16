package com.github.xavierdpt.jvmspect.utils;

import java.io.File;
import java.io.FileNotFoundException;

public class FileHelper {
    public static void ensureDir(File dir) {
        if (dir.exists()) {
            if (!dir.isDirectory()) {
                throw new RuntimeException("not a directory: " + dir);
            }
        } else {
            if (!dir.mkdirs()) {
                throw new RuntimeException("Could not create directories: " + dir.getAbsolutePath());
            }
        }
    }

    public static void cleanDir(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    cleanDir(file);
                }
                if (!file.delete()) {
                    throw new RuntimeException("Could not delete file " + file.getAbsolutePath());
                }
            }
        }
    }

    public static boolean isEmpty(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            throw new RuntimeException("Not a directory: " + dir.getAbsolutePath());
        }
        File[] fileList = dir.listFiles();
        return fileList == null || fileList.length == 0;
    }

    public static void checkFileExists(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IllegalStateException("Found directory instead of file: " + file.getAbsolutePath());
            }
        } else {
            throw new IllegalStateException("File not found: " + file.getAbsolutePath());
        }
    }
}
