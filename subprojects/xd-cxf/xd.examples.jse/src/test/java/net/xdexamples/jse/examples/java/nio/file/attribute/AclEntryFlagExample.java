package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.BaseExample;
import xdtest.Enum;
import net.xdexamples.Scaffolded;

import java.nio.file.attribute.AclEntryFlag;

@Scaffolded
@Enum
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
