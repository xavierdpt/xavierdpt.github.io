package xd.jvmspect.basex;

import org.basex.BaseXClient;
import org.basex.BaseXServer;
import org.basex.core.Context;
import org.basex.core.users.Perm;
import org.basex.core.users.User;
import org.basex.core.users.Users;
import xd.jvmspect.FileHelper;
import xd.jvmspect.XConstants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Consumer;

public class BaseXHelper {
    public static BaseXSession startServer() throws IOException {
        FileHelper.ensureDir(XConstants.LOCAL_DIR);

        File tmpDir = new File(XConstants.LOCAL_DIR, "tmp");
        FileHelper.ensureDir(tmpDir);

        System.setProperty("org.basex.path", new File(XConstants.LOCAL_DIR, "basexhome").getAbsolutePath());

        String port = "10101";
        BaseXServer server = new BaseXServer("-p", port);
        BaseXHelper.createAdminUser(server);
        return new BaseXSession(server, port, tmpDir);
    }


    public static boolean databaseExists(BaseXServer server, String databaseName) {
        for (String name : server.context.databases.list().list) {
            if (databaseName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void createAdminUser(BaseXServer server) {
        Context serverContext = server.context;
        Users users = serverContext.users;
        User adminUser = users.get("admin");
        if (adminUser == null) {
            adminUser = new User("admin", "admin");
            users.add(adminUser);
        }
        adminUser.password("admin");
        adminUser.perm(Perm.CREATE);
        adminUser.perm(Perm.ADMIN);
        serverContext.users.write();
    }

    public static void runCommand(String port, File tmpDir, File inputFile, Consumer<PrintWriter> consumer) throws IOException {
        File commandFile = new File(tmpDir, "command.bxs");
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(commandFile))) {
            consumer.accept(pw);
        }
        new BaseXClient("-p" + port, "-Uadmin", "-Padmin", "-v", commandFile.getAbsolutePath());
    }

    public static void runQuery(String port, File tmpDir, String databaseName, Consumer<PrintWriter> writerConsumer, Consumer<FileReader> readerConsumer) throws IOException {
        File queryFile = new File(tmpDir, "query.xq");
        File outputFile = new File(tmpDir, "basex.out");
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(queryFile))) {
            writerConsumer.accept(pw);
        }
        new BaseXClient("-p" + port, "-Uadmin", "-Padmin",
                "-o" + outputFile.getAbsolutePath(),
                "-i" + databaseName,
                queryFile.getAbsolutePath()
        );
        try (FileReader reader = new FileReader(outputFile)) {
            readerConsumer.accept(reader);
        }
    }
}
