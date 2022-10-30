package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.DummyEnum;
import net.xdexamples.Scaffolded;

import java.util.EnumSet;

@Scaffolded
public class EnumSetExample extends BaseExample<EnumSet<DummyEnum>> {

    @Override
    public void scaffold(EnumSet<DummyEnum> instance) {

        Class<DummyEnum> type = null;
        EnumSet<DummyEnum> dummyEnums = EnumSet.noneOf(type);

        EnumSet<DummyEnum> dummyEnums1 = EnumSet.allOf(type);

        EnumSet<DummyEnum> other = null;
        EnumSet<DummyEnum> dummyEnums2 = EnumSet.copyOf(other);

        EnumSet<DummyEnum> collection = null;
        EnumSet<DummyEnum> dummyEnums3 = EnumSet.copyOf(collection);

        EnumSet<DummyEnum> dummyEnums4 = EnumSet.complementOf(other);

        DummyEnum value1 = null;
        DummyEnum value2 = null;
        DummyEnum value3 = null;
        EnumSet<DummyEnum> value11 = EnumSet.of(value1, value2, value3);
        // ...

        EnumSet<DummyEnum> range = EnumSet.range(value1, value2);

        EnumSet<DummyEnum> clone = instance.clone();
    }

}
