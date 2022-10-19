package xd.examples.java.nio.file.spi;

import java.nio.file.spi.FileSystemProvider;
import java.nio.file.spi.FileTypeDetector;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    FileSystemProvider.class,
                    FileTypeDetector.class
            ));
        }
    }

}
