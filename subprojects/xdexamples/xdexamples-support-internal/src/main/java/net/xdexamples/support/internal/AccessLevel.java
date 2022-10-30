package net.xdexamples.support.internal;

public @interface AccessLevel {
    EAccessLevel value() default EAccessLevel.PROTECTED;
}
