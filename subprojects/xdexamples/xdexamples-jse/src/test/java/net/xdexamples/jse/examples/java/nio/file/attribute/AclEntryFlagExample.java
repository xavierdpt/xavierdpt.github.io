package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.nio.file.attribute.AclEntryFlag;

@Scaffolded
public class AclEntryFlagExample extends BaseExample<AclEntryFlag> {

    @Override
    public void scaffold(AclEntryFlag instance) {
        ignore(
                AclEntryFlag.FILE_INHERIT,
                AclEntryFlag.DIRECTORY_INHERIT,
                AclEntryFlag.NO_PROPAGATE_INHERIT,
                AclEntryFlag.INHERIT_ONLY
        );
    }
}
