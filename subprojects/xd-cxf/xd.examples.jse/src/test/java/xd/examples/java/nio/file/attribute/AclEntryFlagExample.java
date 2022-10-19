package xd.examples.java.nio.file.attribute;

import xd.BaseExample;
import xdtest.Enum;
import xdtest.Scaffolded;

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
