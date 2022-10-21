package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;

import java.util.Stack;

public class StackExample extends BaseExample<Stack<Dummy>> {

    @Override
    public void scaffold(Stack<Dummy> instance) throws Throwable {
        ignore(
                new Stack<Dummy>()
        );

        Dummy value = null;

        boolean empty = instance.empty();
        Dummy peek = instance.peek();
        Dummy pop = instance.pop();
        instance.push(value);
        int search = instance.search(value);
    }

}
