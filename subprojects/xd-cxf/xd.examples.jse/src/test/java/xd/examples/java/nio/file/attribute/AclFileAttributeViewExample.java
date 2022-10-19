package xd.examples.java.nio.file.attribute;

import xd.BaseExample;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.io.IOException;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.util.List;

@Scaffolded
@Interface
public class AclFileAttributeViewExample extends BaseExample<AclFileAttributeView> {
    @Override
    public void scaffold(AclFileAttributeView instance) throws IOException {
        String name = instance.name();
        List<AclEntry> acl = instance.getAcl();
        instance.setAcl(acl);
    }
}
