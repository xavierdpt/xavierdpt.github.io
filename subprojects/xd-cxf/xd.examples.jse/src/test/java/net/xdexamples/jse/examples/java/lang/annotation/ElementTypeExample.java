package net.xdexamples.jse.examples.java.lang.annotation;

import net.xdexamples.Scaffolded;
import net.xdexamples.BaseExample;
import xdtest.Enum;

import java.lang.annotation.ElementType;

@Scaffolded
@Enum
public class ElementTypeExample extends BaseExample<ElementType> {
    @Override
    public void scaffold(ElementType instance) {
        ignore(
                ElementType.TYPE,
                ElementType.FIELD,
                ElementType.METHOD,
                ElementType.PARAMETER,
                ElementType.CONSTRUCTOR,
                ElementType.LOCAL_VARIABLE,
                ElementType.ANNOTATION_TYPE,
                ElementType.PACKAGE,
                ElementType.TYPE_PARAMETER,
                ElementType.TYPE_USE,
                ElementType.MODULE,
                ElementType.RECORD_COMPONENT
        );
    }
}
