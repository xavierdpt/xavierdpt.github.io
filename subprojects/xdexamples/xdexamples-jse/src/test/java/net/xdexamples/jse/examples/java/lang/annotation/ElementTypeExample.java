package net.xdexamples.jse.examples.java.lang.annotation;

import net.xdexamples.support.internal.Scaffolded;
import net.xdexamples.support.internal.BaseExample;

import java.lang.annotation.ElementType;

@Scaffolded
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
