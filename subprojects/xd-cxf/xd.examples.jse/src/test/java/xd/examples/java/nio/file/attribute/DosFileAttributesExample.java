package xd.examples.java.nio.file.attribute;

import org.apache.cxf.annotations.SchemaValidation;
import xd.BaseExample;
import xdtest.Interface;

import java.nio.file.attribute.DosFileAttributes;

@SchemaValidation
@Interface
public class DosFileAttributesExample extends BaseExample<DosFileAttributes> {
    @Override
    public void scaffold(DosFileAttributes instance) throws Throwable {
        boolean readOnly = instance.isReadOnly();
        boolean hidden = instance.isHidden();
        boolean archive = instance.isArchive();
        boolean system = instance.isSystem();
    }
}
