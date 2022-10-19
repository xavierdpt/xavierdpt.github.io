package xd.examples.java.nio.file.attribute;

import xd.BaseExample;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.nio.file.attribute.AttributeView;

@Scaffolded
@Interface
public class AttributeViewExample extends BaseExample<AttributeView> {
    @Override
    public void scaffold(AttributeView instance) throws Throwable {
        String name = instance.name();
    }
}
