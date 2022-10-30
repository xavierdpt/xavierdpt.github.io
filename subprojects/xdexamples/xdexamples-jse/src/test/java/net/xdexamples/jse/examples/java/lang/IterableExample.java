package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.ExampleUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IterableExample {

    public void scaffold() throws ClassNotFoundException, IOException, InterruptedException {
        if (ExampleUtils.skip()) {
            Iterable<Dummy> instance = ExampleUtils.makeInstance(Iterable.class);
            Iterator<Dummy> iterator = instance.iterator();
            Consumer<Dummy> consumer = null;
            instance.forEach(consumer);
            Spliterator<Dummy> spliterator = instance.spliterator();
        }
    }

    public static class Dummy {
    }

}
