package net.xdexamples.jse.examples.java.util.jar;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;

@Scaffolded
public class JarFileExample extends BaseExample<JarFile> {
    @Override
    public void scaffold(JarFile instance) throws Throwable {
        String name = null;
        boolean verify = false;
        File file = null;
        int mode = 0;
        Runtime.Version version = null;
        ignore(
                new JarFile(name),
                new JarFile(name, verify),
                new JarFile(file),
                new JarFile(file, verify),
                new JarFile(file, verify, mode),
                new JarFile(file, verify, mode, version)
        );
        Runtime.Version version1 = JarFile.baseVersion();
        Runtime.Version version2 = JarFile.runtimeVersion();
        Runtime.Version version3 = instance.getVersion();
        boolean multiRelease = instance.isMultiRelease();
        Manifest manifest = instance.getManifest();
        JarEntry jarEntry = instance.getJarEntry(name);
        ZipEntry entry = instance.getEntry(name);
        Enumeration<JarEntry> entries = instance.entries();
        Stream<JarEntry> stream = instance.stream();
        Stream<JarEntry> jarEntryStream = instance.versionedStream();
        ZipEntry zipEntry = null;
        InputStream inputStream = instance.getInputStream(zipEntry);
        String manifestName = JarFile.MANIFEST_NAME;
    }
}
