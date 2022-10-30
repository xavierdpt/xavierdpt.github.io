package net.xdexamples.support.internal;

public @interface Example {
    Class<?> value();

    String[] illustrated() default {};

    EBundle bundle() default EBundle.INHERIT;

    EAccessLevel access() default EAccessLevel.INHERIT;

}
