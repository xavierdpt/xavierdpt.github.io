package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;
import net.xdexamples.ExampleUtils;
import net.xdexamples.Done;

@Done
public class RunnableExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            Runnable instance = ExampleUtils.makeInstance(Runnable.class);
            instance.run();
        }
    }

    @Test
    public void example() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        };
        runnable.run();
    }

    @Test
    public void exampleLambda() {
        Runnable runnable = () -> System.out.println("Hello world");
        runnable.run();
    }

}
