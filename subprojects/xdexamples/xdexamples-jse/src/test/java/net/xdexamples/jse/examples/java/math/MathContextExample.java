package net.xdexamples.jse.examples.java.math;

import net.xdexamples.ExampleUtils;
import net.xdexamples.support.internal.Scaffolded;

import java.math.MathContext;
import java.math.RoundingMode;

@Scaffolded
public class MathContextExample {
    public void scaffold() {
        if (ExampleUtils.skip()) {
            MathContext instance = ExampleUtils.makeInstance(MathContext.class);
            int precision = 0;
            RoundingMode roundingMode = null;
            String value = null;
            ExampleUtils.ignore(
                    new MathContext(precision),
                    new MathContext(precision, roundingMode),
                    new MathContext(value)
            );
            int precision1 = instance.getPrecision();
            RoundingMode roundingMode1 = instance.getRoundingMode();
            MathContext other = null;
            boolean equals = instance.equals(other);
            int i = instance.hashCode();
            String s = instance.toString();
            MathContext unlimited = MathContext.UNLIMITED;
            MathContext decimal32 = MathContext.DECIMAL32;
            MathContext decimal64 = MathContext.DECIMAL64;
            MathContext decimal128 = MathContext.DECIMAL128;
        }
    }
}
