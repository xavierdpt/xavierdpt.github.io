package xd.examples.java.lang.constant;

import xd.BaseExample;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.lang.constant.Constable;
import java.lang.constant.ConstantDesc;
import java.util.Optional;

@Scaffolded
@Interface
public class ConstableExample extends BaseExample<Constable> {
    @Override
    public void scaffold(Constable instance) {
        Optional<? extends ConstantDesc> constantDesc = instance.describeConstable();
    }
}
