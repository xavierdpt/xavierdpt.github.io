package xd.jvmspect.steps;

import xd.jvmspect.FileHelper;
import xd.jvmspect.XConstants;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Step1ExtractModules {
    public static void main(String[] args) throws IOException, InterruptedException {
        String javaHome = System.getProperty("java.home");
        File extractDir = new File(XConstants.LOCAL_DIR, XConstants.MODULES_EXTRACTED);
        FileHelper.ensureDir(extractDir);
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
