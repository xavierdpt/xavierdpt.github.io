package xd.jvmspect.steps;

import org.basex.BaseXServer;
import xd.jvmspect.basex.BaseXHelper;
import xd.jvmspect.basex.BaseXSession;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import static xd.jvmspect.steps.Step3InitBaseX.doInBaseXSession;

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
