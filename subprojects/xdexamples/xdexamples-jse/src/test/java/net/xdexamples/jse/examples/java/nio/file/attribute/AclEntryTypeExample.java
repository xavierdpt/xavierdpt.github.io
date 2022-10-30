package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

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
