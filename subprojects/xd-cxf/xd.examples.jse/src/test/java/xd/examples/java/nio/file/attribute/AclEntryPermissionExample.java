package xd.examples.java.nio.file.attribute;

import xd.BaseExample;
import xdtest.Enum;
import xdtest.Scaffolded;

import java.nio.file.attribute.AclEntryPermission;

@Scaffolded
@Enum
public class AclEntryPermissionExample extends BaseExample<AclEntryPermission> {

    @Override
    public void scaffold(AclEntryPermission instance) {
        ignore(
                AclEntryPermission.READ_DATA,
                AclEntryPermission.WRITE_DATA,
                AclEntryPermission.APPEND_DATA,
                AclEntryPermission.READ_NAMED_ATTRS,
                AclEntryPermission.WRITE_NAMED_ATTRS,
                AclEntryPermission.EXECUTE,
                AclEntryPermission.DELETE_CHILD,
                AclEntryPermission.READ_ATTRIBUTES,
                AclEntryPermission.WRITE_ATTRIBUTES,
                AclEntryPermission.DELETE,
                AclEntryPermission.READ_ACL,
                AclEntryPermission.WRITE_ACL,
                AclEntryPermission.WRITE_OWNER,
                AclEntryPermission.SYNCHRONIZE,
                AclEntryPermission.LIST_DIRECTORY,
                AclEntryPermission.ADD_FILE,
                AclEntryPermission.ADD_SUBDIRECTORY
        );
    }
}
