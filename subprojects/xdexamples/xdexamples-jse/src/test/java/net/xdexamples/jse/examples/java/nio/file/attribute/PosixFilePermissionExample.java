package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.support.internal.BaseExample;

import java.nio.file.attribute.PosixFilePermission;

public class PosixFilePermissionExample extends BaseExample<PosixFilePermission> {
    @Override
    public void scaffold(PosixFilePermission instance) {
        ignore(
                PosixFilePermission.OWNER_READ,
                PosixFilePermission.OWNER_WRITE,
                PosixFilePermission.OWNER_EXECUTE,
                PosixFilePermission.GROUP_READ,
                PosixFilePermission.GROUP_WRITE,
                PosixFilePermission.GROUP_EXECUTE,
                PosixFilePermission.OTHERS_READ,
                PosixFilePermission.OTHERS_WRITE,
                PosixFilePermission.OTHERS_EXECUTE
        );
    }
}
