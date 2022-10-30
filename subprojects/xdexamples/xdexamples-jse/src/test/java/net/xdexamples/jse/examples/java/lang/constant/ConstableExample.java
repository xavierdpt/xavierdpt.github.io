package net.xdexamples.jse.examples.java.lang.constant;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

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
