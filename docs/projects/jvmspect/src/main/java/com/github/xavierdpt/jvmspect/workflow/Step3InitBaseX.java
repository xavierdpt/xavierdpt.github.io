package com.github.xavierdpt.jvmspect.workflow;

import com.github.xavierdpt.jvmspect.JVMSpectConstants;
import com.github.xavierdpt.jvmspect.basex.BaseXHelper;
import com.github.xavierdpt.jvmspect.basex.BaseXSession;
import org.basex.BaseXServer;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class Step3InitBaseX {

    public static void main(String[] args) throws IOException, InterruptedException, TransformerException {
        try (BaseXSession baseXSession = BaseXHelper.startServer()) {
            BaseXServer server = baseXSession.server();
            String port = baseXSession.port();
            File tmpDir = baseXSession.tmpDir();
            doInBaseXSession(server, port, tmpDir, false);

        }
    }

    public static void doInBaseXSession(BaseXServer server, String port, File tmpDir, boolean force) throws IOException {
        if (force || !BaseXHelper.databaseExists(server, JVMSpectConstants.JAVAXML)) {
            File inputDir = new File(JVMSpectConstants.LOCAL_DIR, JVMSpectConstants.JAVAXML); // TODO: move to local
            BaseXHelper.runCommand(port, tmpDir, inputDir, pw -> pw.println("CREATE DB " + JVMSpectConstants.JAVAXML + " " +
                                                                            inputDir.getAbsolutePath()));
        }
    }

    public static void importIntoDB() {

    }
}
