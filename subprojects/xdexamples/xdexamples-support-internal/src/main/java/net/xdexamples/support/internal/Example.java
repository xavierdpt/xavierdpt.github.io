package net.xdexamples.support.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Example {
    Class<?> value();

    String code() default "";

    String[] illustrated() default {};

    boolean illutratesConstructor() default false;

    EBundle bundle() default EBundle.INHERIT;

    EAccessLevel access() default EAccessLevel.INHERIT;

    boolean improvable() default false;
}
