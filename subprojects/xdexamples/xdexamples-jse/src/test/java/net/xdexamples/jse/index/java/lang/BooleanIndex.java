package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.BooleanExample_booleanValue;
import net.xdexamples.jse.examples.java.lang.BooleanExample_compare;
import net.xdexamples.jse.examples.java.lang.BooleanExample_compareTo;
import net.xdexamples.jse.examples.java.lang.BooleanExample_describeConstable;
import net.xdexamples.jse.examples.java.lang.BooleanExample_equals;
import net.xdexamples.jse.examples.java.lang.BooleanExample_getBoolean;
import net.xdexamples.jse.examples.java.lang.BooleanExample_hashCode;
import net.xdexamples.jse.examples.java.lang.BooleanExample_hashCodeStatic;
import net.xdexamples.jse.examples.java.lang.BooleanExample_logicalAnd;
import net.xdexamples.jse.examples.java.lang.BooleanExample_logicalOr;
import net.xdexamples.jse.examples.java.lang.BooleanExample_logicalXor;
import net.xdexamples.jse.examples.java.lang.BooleanExample_parseBoolean;
import net.xdexamples.jse.examples.java.lang.BooleanExample_toString;
import net.xdexamples.jse.examples.java.lang.BooleanExample_toStringStatic;
import net.xdexamples.jse.examples.java.lang.BooleanExample_type;
import net.xdexamples.jse.examples.java.lang.BooleanExample_valueOfBoolean;
import net.xdexamples.jse.examples.java.lang.BooleanExample_valueOfString;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EAccessLevel;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;


@Bundle(EBundle.CORE)
@Examples({
        @Example(value = BooleanExample_booleanValue.class, illustrated = "booleanValue"),
        @Example(value = BooleanExample_parseBoolean.class, illustrated = "parseBoolean"),
        @Example(value = BooleanExample_valueOfString.class, illustrated = "valueOf"),
        @Example(value = BooleanExample_valueOfBoolean.class, illustrated = "valueOf"),
        @Example(value = BooleanExample_toString.class, illustrated = "toString"),
        @Example(value = BooleanExample_toStringStatic.class, illustrated = "toString"),
        @Example(value = BooleanExample_hashCode.class, illustrated = "hashCode"),
        @Example(value = BooleanExample_hashCodeStatic.class, illustrated = "hashCode"),
        @Example(value = BooleanExample_equals.class, illustrated = "equals"),
        @Example(value = BooleanExample_getBoolean.class, illustrated = "getBoolean"),
        @Example(value = BooleanExample_compare.class, illustrated = "compare"),
        @Example(value = BooleanExample_compareTo.class, illustrated = "compareTo"),
        @Example(value = BooleanExample_logicalAnd.class, illustrated = "logicalAnd"),
        @Example(value = BooleanExample_logicalOr.class, illustrated = "logicalOr"),
        @Example(value = BooleanExample_logicalXor.class, illustrated = "logicalXor"),
        @Example(value = BooleanExample_type.class, illustrated = "TYPE"),
        @Example(value = BooleanExample_describeConstable.class, illustrated = "describeConstable",
                bundle = EBundle.CONSTABLE, access = EAccessLevel.PROTECTED),
})
public class BooleanIndex extends ExampleComplete<Boolean> {
}


