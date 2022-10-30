package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.Scaffolded;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Supplier;

@Scaffolded
public class ObjectsExample extends BaseExample<Objects> {

    @Override
    public void scaffold(Objects instance) {
        int iFrom = 0;
        int iSize = 0;
        int iLength = 0;
        int i = Objects.checkFromIndexSize(iFrom, iSize, iLength);

        long lFrom = 0;
        long lSize = 0;
        long lLength = 0;
        long l = Objects.checkFromIndexSize(lFrom, lSize, lLength);

        int iIndex = 0;
        int i1 = Objects.checkIndex(iIndex, iLength);

        long lIndex = 0;
        long l1 = Objects.checkIndex(lIndex, lLength);

        Dummy dummy = null;
        Comparator<Dummy> comparator = null;
        int compare = Objects.compare(dummy, dummy, comparator);

        boolean b = Objects.deepEquals(dummy, dummy);

        boolean equals = Objects.equals(dummy, dummy);

        Objects.hash(dummy, dummy, dummy);
        // ...

        int i2 = Objects.hashCode(dummy);

        boolean aNull = Objects.isNull(dummy);

        boolean b1 = Objects.nonNull(dummy);

        Dummy dummy1 = Objects.requireNonNull(dummy);

        String message = null;
        Objects.requireNonNull(dummy, message);

        Supplier<String> messageSupplier = null;
        Dummy dummy2 = Objects.requireNonNull(dummy, messageSupplier);

        Dummy dummy3 = Objects.requireNonNullElse(dummy, dummy2);

        Supplier<Dummy> supplier = null;
        Dummy dummy4 = Objects.requireNonNullElseGet(dummy, supplier);

        String def = null;
        String s = Objects.toString(dummy);
        String s1 = Objects.toString(dummy, def);
    }
}
