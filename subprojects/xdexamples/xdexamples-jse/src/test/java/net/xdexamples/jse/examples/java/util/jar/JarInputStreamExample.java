package net.xdexamples.jse.examples.java.util.jar;

import net.xdexamples.Scaffolded;
import net.xdexamples.BaseExample;

import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

@Scaffolded
public class JarInputStreamExample extends BaseExample<JarInputStream> {
    @Override
    public void scaffold(JarInputStream instance) throws Throwable {
        InputStream inputStream = null;
        boolean verify = false;
        ignore(
                new JarInputStream(inputStream),
                new JarInputStream(inputStream, verify)
        );
        Manifest manifest = instance.getManifest();
        ZipEntry nextEntry = instance.getNextEntry();
        JarEntry nextJarEntry = instance.getNextJarEntry();

        byte[] bytes = new byte[0];
        int offset = 0;
        int length = 0;
        int read = instance.read(bytes, offset, length);
    }
}
