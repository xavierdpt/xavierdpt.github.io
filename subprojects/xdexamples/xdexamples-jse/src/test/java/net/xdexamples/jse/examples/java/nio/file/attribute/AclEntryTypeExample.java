package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.nio.file.attribute.AclEntryType;

@Scaffolded
public class AclEntryTypeExample extends BaseExample<AclEntryType> {

    @Override
    public void scaffold(AclEntryType instance) {
        ignore(
                AclEntryType.ALLOW,
                AclEntryType.DENY,
                AclEntryType.AUDIT,
                AclEntryType.ALARM
        );
    }
}
