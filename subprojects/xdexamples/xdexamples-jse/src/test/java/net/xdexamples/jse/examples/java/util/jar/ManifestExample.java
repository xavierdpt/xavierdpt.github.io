package net.xdexamples.jse.examples.java.util.jar;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

@Scaffolded
public class ManifestExample extends BaseExample<Manifest> {
    @Override
    public void scaffold(Manifest instance) throws IOException {
        InputStream inputStream = null;
        Manifest manifest = null;
        ignore(
                new Manifest(),
                new Manifest(inputStream),
                new Manifest(manifest)
        );
        Attributes mainAttributes = instance.getMainAttributes();
        Map<String, Attributes> entries = instance.getEntries();
        String name = null;
        Attributes attributes = instance.getAttributes(name);
        instance.clear();
        OutputStream outputStream = null;
        instance.write(outputStream);
        instance.read(inputStream);
        Manifest other = null;
        boolean equals = instance.equals(other);
        int i = instance.hashCode();
        Object clone = instance.clone();
    }
}
