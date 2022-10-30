package net.xdexamples.site;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.StreamCopier;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.sftp.SFTPFileTransfer;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import net.schmizz.sshj.xfer.TransferListener;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleIndex;
import net.xdexamples.support.internal.Examples;
import net.xdexamples.support.internal.MasterIndex;
import net.xdexamples.jse.index.Index;
import org.codelibs.jhighlight.renderer.JavaXhtmlRenderer;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Site {

    @Test
    public void test() throws URISyntaxException, IOException, InterruptedException {
        /*
        apt-get install openssh-server mysql-server libapache2-mod-php
        Port forwarding: 80:80 22:22
         */
        Properties props = new Properties();
        doDirectory(props, new File("target/test-classes/site/deployments"));
        String id = props.getProperty("id");
        if (id == null || id.isBlank()) {
            throw new RuntimeException("No Environment ID");
        }
        System.out.println(id);
        //Desktop.getDesktop().browse(new URI(props.getProperty("hostname")));
        generateExamples();
        upload(props);
    }


    private boolean doFile(Properties props, File file) {
        String path = file.getAbsolutePath();
        if (path.endsWith(".properties")) {
            try {
                props.load(new FileInputStream(file));
                if (!"true".equals(props.getProperty("active"))) {
                    props.clear();
                } else {
                    return true;
                }
            } catch (IOException e) {
                System.out.println(e.getClass().getName() + ": " + e.getMessage());
            }
            System.out.println(path);
        }
        return false;
    }

    @SuppressWarnings("ConstantConditions")
    private boolean doDirectory(Properties props, File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                if (doDirectory(props, file)) {
                    return true;
                }
            } else {
                if (doFile(props, file)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void upload(Properties props) throws IOException {
        File website = new File("target/test-classes/site/website");
        System.out.println(website.getAbsolutePath());
        String sftp = props.getProperty("SFTP");
        if (sftp == null || sftp.isBlank()) {
            throw new RuntimeException("SFTP not defined");
        }
        String hostname = props.getProperty("hostname");
        validate(hostname, "hostname");
        String sftpUser = getNonBlankProperty(props, "SFTP.user");
        String sftpPassword = getNonBlankProperty(props, "SFTP.password");
        System.out.println(sftp);

        try (SSHClient sshClient = new SSHClient()) {
            sshClient.addHostKeyVerifier(new PromiscuousVerifier());
            sshClient.connect(hostname);
            sshClient.authPassword(sftpUser, sftpPassword);
            try (SFTPClient sftpClient = sshClient.newSFTPClient()) {
                SFTPFileTransfer fileTransfer = sftpClient.getFileTransfer();
                fileTransfer.setTransferListener(new SimpleTransferListener());
                // TODO: remove files not on server, handle config.php files
                fileTransfer.upload(website.getAbsolutePath() + "/", "/var/www/html/");
            }
        }
    }

    private String getNonBlankProperty(Properties props, String name) {
        String value = props.getProperty(name);
        validate(value, name);
        return value;
    }

    private void validate(String str, String what) {
        if (str == null || str.isBlank()) {
            throw new RuntimeException("Invalid " + what);
        }
    }

    private void generateExamples() throws IOException {
        String examplesSQLImport = "src/test/resources/site/website/data/examples.sql";
        File examplesSQLImportFile = new File(examplesSQLImport);
        createParentDir(examplesSQLImportFile);
        ExampleDBWriter exampleDBWriter;
        try (FileWriter fileWriter = new FileWriter(examplesSQLImportFile)) {
            exampleDBWriter = new ExampleDBWriter(fileWriter);

            if (Index.class.isAnnotationPresent(MasterIndex.class)) {
                MasterIndex masterIndex = Index.class.getAnnotation(MasterIndex.class);
                for (Class<?> index : masterIndex.value()) {
                    if (index.isAnnotationPresent(ExampleIndex.class)) {
                        ExampleIndex exampleIndex = index.getAnnotation(ExampleIndex.class);
                        for (Class<?> exampleClass : exampleIndex.value()) {
                            if (exampleClass.isAnnotationPresent(Examples.class)) {
                                Examples examples = exampleClass.getAnnotation(Examples.class);
                                for (Example example : examples.value()) {
                                    Class<?> clazz = example.value();
                                    File srcFile = new File(computeSrcFilePath(clazz));
                                    ExampleInfo exampleInfo = toInfo(clazz);
                                    exampleDBWriter.add(exampleInfo);
                                    File dstFile = new File(computeDstFilePath(exampleInfo));
                                    try {
                                        createParentDir(dstFile);
                                        JavaXhtmlRenderer javaXhtmlRenderer = new JavaXhtmlRenderer();
                                        javaXhtmlRenderer.highlight("",
                                                new FileInputStream(srcFile),
                                                new FileOutputStream(dstFile),
                                                StandardCharsets.UTF_8.name(),
                                                true
                                        );
                                    } catch (IOException e) {
                                        System.out.println(e.getClass().getName() + ": " + e.getMessage());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            exampleDBWriter.done();
        }
    }

    private void createParentDir(File file) throws IOException {
        File dir = file.getParentFile();
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new IOException("Could not create directory: " + dir.getAbsolutePath());
            }
        } else if (dir.isFile()) {
            throw new IOException("Directory is file: " + dir.getAbsolutePath());
        }
    }

    private String computeDstFilePath(ExampleInfo toInfo) {
        String project = toInfo.getProject();
        String packageName = toInfo.getPackageName();
        String className = toInfo.getClassName();
        String exampleId = toInfo.getExampleId();
        return "src/test/resources/site/website/java/examples/" + project + "/" + packageName + "/" + className + "/" + exampleId;
    }

    private String computeSrcFilePath(Class<?> clazz) {
        return "src/test/java/" + (clazz.getName().replaceAll("\\.", "/") + ".java");
    }

    private ExampleInfo toInfo(Class<?> clazz) {
        String suffix = clazz.getName().substring("net.xdexamples.jse.examples.".length());
        String packageName = suffix.substring(0, suffix.lastIndexOf('.'));
        String rest = suffix.substring(packageName.length() + 1);
        String simpleClassName = rest.substring(0, rest.indexOf("Example_"));
        String exampleId = rest.substring(rest.indexOf('_') + 1);
        return new ExampleInfo("jse", packageName, simpleClassName, exampleId);
    }

    public static class ExampleInfo {

        private String project;
        private final String packageName;
        private final String className;
        private final String exampleId;

        public ExampleInfo(String project, String packageName, String className, String exampleId) {
            this.project = project;
            this.packageName = packageName;
            this.className = className;
            this.exampleId = exampleId;
        }

        public String getProject() {
            return project;
        }

        public String getPackageName() {
            return packageName;
        }

        public String getClassName() {
            return className;
        }

        public String getExampleId() {
            return exampleId;
        }
    }

    public static class SimpleTransferListener implements TransferListener {
        private String base;

        public SimpleTransferListener() {
            this("");
        }

        public SimpleTransferListener(String base) {
            this.base = base;
        }

        @Override
        public TransferListener directory(String name) {
            String path = withBase(name);
            System.out.println(path);
            return new SimpleTransferListener(path);
        }

        @Override
        public StreamCopier.Listener file(String name, long size) {
            System.out.println(withBase(name));
            return progress -> {
            };
        }

        private String withBase(String name) {
            if (base.isBlank()) {
                return name;
            } else {
                return base + "/" + name;
            }
        }
    }

    public static class ExampleDBWriter {
        private final PrintWriter printWriter;
        private boolean sep = false;

        public ExampleDBWriter(Writer writer) {
            printWriter = new PrintWriter(writer);
            printWriter.println("insert ignore into examples (project,package,class,example) values ");
        }

        public void add(ExampleInfo exampleInfo) {
            if (sep) {
                printWriter.println(",");
            }
            String project = exampleInfo.getProject();
            String packageName = exampleInfo.getPackageName();
            String className = exampleInfo.getClassName();
            String exampleId = exampleInfo.getExampleId();
            // TODO: possibly escape for MySQL strings
            printWriter.print("(\"" + project + "\",\"" + packageName + "\",\"" + className + "\",\"" + exampleId + "\")");
            sep = true;
        }

        public void done() {
            printWriter.println();
            printWriter.close();
        }
    }
}
