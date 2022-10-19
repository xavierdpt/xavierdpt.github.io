package xd.examples.java.lang;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.io.File;
import java.io.IOException;

@Scaffolded
public class RuntimeExample {

    public void scaffold() throws ClassNotFoundException, IOException, InterruptedException {
        if (ExampleUtils.skip()) {
            Runtime instance = ExampleUtils.makeInstance(Runtime.class);
            Runtime runtime = Runtime.getRuntime();
            int status = 0;
            instance.exit(status);
            Thread hook = null;
            instance.addShutdownHook(hook);
            boolean b = instance.removeShutdownHook(hook);
            instance.halt(status);
            String[] cmdarray = new String[0];
            instance.exec(cmdarray);
            String[] envp = new String[0];
            instance.exec(cmdarray, envp);
            File dir = null;
            instance.exec(cmdarray, envp, dir);
            int i = instance.availableProcessors();
            long l = instance.freeMemory();
            long l1 = instance.totalMemory();
            long l2 = instance.maxMemory();
            instance.gc();
            String filename = null;
            instance.load(filename);
            String libname = null;
            instance.loadLibrary(libname);
            Runtime.Version version = instance.version();
        }
    }

}
