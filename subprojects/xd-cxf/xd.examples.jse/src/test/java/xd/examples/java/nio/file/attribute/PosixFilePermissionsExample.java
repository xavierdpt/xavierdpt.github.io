package xd.examples.java.nio.file.attribute;

import xd.BaseExample;

import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFilePermissionsExample extends BaseExample<PosixFilePermissions> {
    @Override
    public void scaffold(PosixFilePermissions instance) {
        String s = instance.toString();
        Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString(s);
        FileAttribute<Set<PosixFilePermission>> setFileAttribute = PosixFilePermissions.asFileAttribute(posixFilePermissions);
    }
}
