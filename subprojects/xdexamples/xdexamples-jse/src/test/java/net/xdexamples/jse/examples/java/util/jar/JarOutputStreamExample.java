package net.xdexamples.jse.examples.java.util.jar;

import net.xdexamples.support.internal.BaseExample;

import java.io.OutputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

public class JarOutputStreamExample extends BaseExample<JarOutputStream> {
    @Override
    public void scaffold(JarOutputStream instance) throws Throwable {
        OutputStream outputStream = null;
        Manifest manifest = null;
        ignore(
                new JarOutputStream(outputStream),
                new JarOutputStream(outputStream, manifest)
        );
        ZipEntry zipEntry = null;
        instance.putNextEntry(zipEntry);
    }
}
