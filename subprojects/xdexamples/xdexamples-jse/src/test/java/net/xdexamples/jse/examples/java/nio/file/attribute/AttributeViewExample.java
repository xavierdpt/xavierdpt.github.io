package net.xdexamples.jse.examples.java.nio.file.attribute;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.nio.file.attribute.AttributeView;

@Scaffolded
public class AttributeViewExample extends BaseExample<AttributeView> {
    @Override
    public void scaffold(AttributeView instance) throws Throwable {
        String name = instance.name();
    }
}
