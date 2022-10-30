package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.support.internal.BaseExample;

import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.UserPrincipal;
import java.util.Set;

public class AclEntryExample extends BaseExample<AclEntry> {

    @Override
    public void scaffold(AclEntry instance) {

        AclEntry entry = null;
        ignore(
                AclEntry.newBuilder(),
                AclEntry.newBuilder(entry)
        );

        AclEntryType type = instance.type();

        UserPrincipal principal = instance.principal();

        Set<AclEntryPermission> permissions = instance.permissions();

        Set<AclEntryFlag> flags = instance.flags();

        AclEntry other = null;
        boolean equals = instance.equals(other);

        int i = instance.hashCode();

        String s = instance.toString();
    }
}