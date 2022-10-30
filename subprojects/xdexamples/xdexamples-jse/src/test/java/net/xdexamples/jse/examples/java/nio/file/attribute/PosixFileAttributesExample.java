package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Set;

@Scaffolded
public class PosixFileAttributesExample extends BaseExample<PosixFileAttributes> {

    @Override
    public void scaffold(PosixFileAttributes instance) throws Throwable {
        UserPrincipal owner = instance.owner();
        GroupPrincipal group = instance.group();
        Set<PosixFilePermission> permissions = instance.permissions();
    }
}
