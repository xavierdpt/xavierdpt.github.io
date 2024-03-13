package xd.jvmspect.steps;

import org.basex.BaseXServer;
import xd.jvmspect.XConstants;
import xd.jvmspect.basex.BaseXHelper;
import xd.jvmspect.basex.BaseXSession;

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
        if (force || !BaseXHelper.databaseExists(server, XConstants.JAVAXML)) {
            File inputDir = new File(XConstants.JAVAXML); // TODO: move to local
            BaseXHelper.runCommand(port, tmpDir, inputDir, pw -> pw.println("CREATE DB " + XConstants.JAVAXML + " " +
                    inputDir.getAbsolutePath()));
        }
    }

}
