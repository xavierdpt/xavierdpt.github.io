package com.github.xavierdpt.jvmspect.workflow;

import com.github.xavierdpt.jvmspect.JVMSpectConstants;
import com.github.xavierdpt.jvmspect.utils.FileHelper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ModulesExtractor {

    public static void extractModules(boolean force) throws InterruptedException, IOException {
        String javaHome = System.getProperty("java.home");
        File extractDir = new File(JVMSpectConstants.LOCAL_DIR, JVMSpectConstants.MODULES_EXTRACTED);
        FileHelper.ensureDir(extractDir);
        if (force) {
            FileHelper.cleanDir(extractDir);
        }
        if (FileHelper.isEmpty(extractDir)) {
            ProcessBuilder pb = new ProcessBuilder(Arrays.asList(
                    new File(javaHome, "bin/jimage.exe").getAbsolutePath(),
                    "extract",
                    "--dir=" + extractDir.getAbsolutePath(),
                    new File(javaHome, "lib/modules").getAbsolutePath()
            ));
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
        }
    }
}