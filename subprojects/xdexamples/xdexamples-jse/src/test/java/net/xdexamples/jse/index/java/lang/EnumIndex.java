package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.EnumExample_compareTo;
import net.xdexamples.jse.examples.java.lang.EnumExample_describeConstable;
import net.xdexamples.jse.examples.java.lang.EnumExample_equals;
import net.xdexamples.jse.examples.java.lang.EnumExample_getDeclaringClass;
import net.xdexamples.jse.examples.java.lang.EnumExample_hashCode;
import net.xdexamples.jse.examples.java.lang.EnumExample_name;
import net.xdexamples.jse.examples.java.lang.EnumExample_ordinal;
import net.xdexamples.jse.examples.java.lang.EnumExample_toString;
import net.xdexamples.jse.examples.java.lang.EnumExample_valueOf;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EAccessLevel;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;
import xd.helpers.dummies.DummyEnum;

@Bundle(EBundle.CORE)
@Examples({
        @Example(value = EnumExample_ordinal.class, illustrated = "ordinal"),
        @Example(value = EnumExample_name.class, illustrated = "name"),
        @Example(value = EnumExample_compareTo.class, illustrated = "compareTo"),
        @Example(value = EnumExample_valueOf.class, illustrated = "valueOf"),
        @Example(value = EnumExample_toString.class, illustrated = "toString"),
        @Example(value = EnumExample_hashCode.class, illustrated = "hashCode"),
        @Example(value = EnumExample_getDeclaringClass.class, illustrated = "getDeclaringClass"),
        @Example(value = EnumExample_describeConstable.class, illustrated = "describeConstable",
                bundle = EBundle.CONSTABLE, access = EAccessLevel.PROTECTED),
        @Example(value = EnumExample_equals.class, illustrated = "equals"),
})
public class EnumIndex extends ExampleComplete<Enum<DummyEnum>> {
}
