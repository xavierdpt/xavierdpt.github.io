package xd.examples.java.nio.file.attribute;

import xd.BaseExample;

import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class PosixFileAttributeViewExample extends BaseExample<PosixFileAttributeView> {
    @Override
    public void scaffold(PosixFileAttributeView instance) throws Throwable {
        String name = instance.name();
        PosixFileAttributes posixFileAttributes = instance.readAttributes();
        Set<PosixFilePermission> permissions = null;
        instance.setPermissions(permissions);
        GroupPrincipal group = null;
        instance.setGroup(group);
    }
}
