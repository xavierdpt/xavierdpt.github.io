package net.xdexamples.jse.examples.java.net;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@ToBeContinued
public class JarURLConnectionExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            JarURLConnection instance = ExampleUtils.makeInstance(JarURLConnection.class);
            String entryName = instance.getEntryName();
            JarFile jarFile = instance.getJarFile();
            Manifest manifest = instance.getManifest();
            JarEntry jarEntry = instance.getJarEntry();
            Attributes attributes = instance.getAttributes();
            Attributes mainAttributes = instance.getMainAttributes();
            Certificate[] certificates = instance.getCertificates();
        }
    }

    @Test
    public void example() throws IOException {
        // This loads all the jars in the class, open a jar connection, and count of many jars have manifests
        int count = 0;
        int withManifests = 0;
        for (String jarPath : System.getProperty("java.class.path").split(";", -1)) {
            File file = new File(jarPath);
            URI uri = file.toURI();
            URL url = uri.toURL();
            String externalForm = url.toExternalForm();
            if (externalForm.endsWith(".jar")) {
                URL jarUrl = new URL("jar:" + externalForm + "!/");
                URLConnection connection = jarUrl.openConnection();
                Assert.assertTrue(connection instanceof JarURLConnection);
                JarURLConnection example = (JarURLConnection) connection;
                assertNull(example.getEntryName());
                assertNull(example.getCertificates());
                ++count;
                if (example.getManifest() != null) {
                    ++withManifests;
                }
            }
        }
        assertEquals(22, count);
        assertEquals(20, withManifests);
    }

}
