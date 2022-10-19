package xd.examples.java.lang;

import org.junit.Test;
import xd.ExampleUtils;
import xdtest.Done;

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
