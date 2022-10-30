package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.time.Instant;
import java.util.Date;

@Scaffolded
public class DateExample extends BaseExample<Date> {
    @Override
    public void scaffold(Date instance) {
        long millis = 0;
        ignore(
                new Date(),
                new Date(millis)
        );
        Date when = null;
        boolean after = instance.after(when);

        boolean before = instance.before(when);

        Object clone = instance.clone();

        Date other = null;
        int i = instance.compareTo(other);

        boolean equals = instance.equals(other);

        Instant instant = null;
        Date from = Date.from(instant);

        long time = instance.getTime();

        int i1 = instance.hashCode();

        instance.setTime(time);

        Instant instant1 = instance.toInstant();

        String s = instance.toString();
    }
}
