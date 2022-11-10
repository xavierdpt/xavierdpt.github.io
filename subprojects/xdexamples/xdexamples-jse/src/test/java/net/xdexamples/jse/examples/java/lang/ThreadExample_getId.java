package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class ThreadExample_getId {

    @Test
    @SuppressWarnings("InstantiatingAThreadWithDefaultRunMethod")
    public void example() {

        // Each thread has a unique id that is genreated by the Thread's constructor

        Thread thread1 = new Thread();
        Thread thread2 = new Thread();

        long id1 = thread1.getId();
        long id2 = thread2.getId();

        assertNotEquals(id1, id2);

    }

}
