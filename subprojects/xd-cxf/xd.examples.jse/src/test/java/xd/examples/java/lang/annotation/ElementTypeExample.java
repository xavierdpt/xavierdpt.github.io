package xd.examples.java.lang.annotation;

import xd.BaseExample;
import xdtest.Enum;
import xdtest.Scaffolded;

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
