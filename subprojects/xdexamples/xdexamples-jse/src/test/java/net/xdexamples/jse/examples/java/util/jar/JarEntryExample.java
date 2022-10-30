package net.xdexamples.jse.examples.java.util.jar;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.security.CodeSigner;
import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;

@Scaffolded
public class JarEntryExample extends BaseExample<JarEntry> {
    @Override
    public void scaffold(JarEntry instance) throws Throwable {
        JarEntry name = null;
        JarEntry zipEntry = null;
        JarEntry jarEntry = null;
        ignore(
                new JarEntry(name),
                new JarEntry(zipEntry),
                new JarEntry(jarEntry)
        );
        Attributes attributes = instance.getAttributes();
        Certificate[] certificates = instance.getCertificates();
        CodeSigner[] codeSigners = instance.getCodeSigners();
        String realName = instance.getRealName();
    }
}
