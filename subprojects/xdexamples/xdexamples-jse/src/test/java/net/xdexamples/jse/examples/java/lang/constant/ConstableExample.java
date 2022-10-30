package net.xdexamples.jse.examples.java.lang.constant;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.constant.Constable;
import java.lang.constant.ConstantDesc;
import java.util.Optional;

@Scaffolded
public class ConstableExample extends BaseExample<Constable> {
    @Override
    public void scaffold(Constable instance) {
        Optional<? extends ConstantDesc> constantDesc = instance.describeConstable();
    }
}
