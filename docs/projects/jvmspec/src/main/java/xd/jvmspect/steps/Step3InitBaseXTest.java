package xd.jvmspect.steps;

import org.basex.BaseXServer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.basex.BaseXHelper;
import xd.jvmspect.basex.BaseXSession;
import xd.jvmspect.xml.XML;

import javax.xml.transform.TransformerException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Step3InitBaseXTest {

    public static void main(String[] args) throws IOException, InterruptedException, TransformerException {
        try (BaseXSession baseXSession = BaseXHelper.startServer()) {
            BaseXServer server = baseXSession.server();
            String port = baseXSession.port();
            File tmpDir = baseXSession.tmpDir();
            String databaseName = "test";
            if (!BaseXHelper.databaseExists(server, databaseName)) {
                System.out.println("Initializing database");
                File testFile = createTestFile(tmpDir);
                BaseXHelper.runCommand(port, tmpDir, testFile, pw -> pw.println("CREATE DB " + databaseName + " " +
                        testFile.getAbsolutePath()));
            }
            BaseXHelper.runQuery(port, tmpDir, databaseName, pw -> pw.println("//animal"), fileReader -> {
                new BufferedReader(fileReader).lines().forEach(System.out::println);
            });
        }
    }


    private static File createTestFile(File tmpDir) throws FileNotFoundException, TransformerException {
        Document document = XML.createDocument();
        Element root = XML.createRootElement(document, "root");
        XML.createChild(document, root, "animal", "elephant");
        XML.createChild(document, root, "animal", "giraffe");
        File file = new File(tmpDir, "test.xml");
        XML.writeDocument(document, new FileOutputStream(file));
        return file;
    }


}
