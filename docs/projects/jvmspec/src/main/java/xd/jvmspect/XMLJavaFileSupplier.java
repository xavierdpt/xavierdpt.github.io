package xd.jvmspect;

import java.io.File;
import java.util.function.Supplier;

public class XMLJavaFileSupplier implements Supplier<File> {

    private int i = 0;
    private File root;

    public XMLJavaFileSupplier(File root) {
        this.root = root;
    }

    @Override
    public File get() {
        ++i;
        return new File(root, "classFile" + i + ".xml");
    }
}
