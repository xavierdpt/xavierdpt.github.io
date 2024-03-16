package com.github.xavierdpt.jvmspect.workflow;

import com.github.xavierdpt.jvmspect.basex.BaseXHelper;
import com.github.xavierdpt.jvmspect.basex.BaseXSession;
import org.basex.BaseXServer;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import static com.github.xavierdpt.jvmspect.workflow.Step3InitBaseX.doInBaseXSession;

public class Step3InitBaseXForce {

    public static void main(String[] args) throws IOException, InterruptedException, TransformerException {
        try (BaseXSession baseXSession = BaseXHelper.startServer()) {
            BaseXServer server = baseXSession.server();
            String port = baseXSession.port();
            File tmpDir = baseXSession.tmpDir();
            doInBaseXSession(server, port, tmpDir, true);

        }
    }


}
