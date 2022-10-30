package net.xdexamples.jse.examples.java.util;

import org.junit.Test;
import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.AllMethodsCovered;
import xdtest.SeeAlso;

import java.util.AbstractQueue;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

@AllMethodsCovered
@SeeAlso({
        CollectionExample.class,
        QueueExample.class,
})
public class AbstractQueueExample extends BaseExample<AbstractQueue<Dummy>> {

    @Override
    @SuppressWarnings("unused")
    public void scaffold(AbstractQueue<Dummy> instance) {
        {
            Dummy remove = instance.remove();
            seeExamples(
                    this::example,
                    this::exampleEmpty
            );
        }
    }

    @Test
    public void example() {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("hello");
        queue.add("world");
        assertEquals("hello", queue.remove());
        assertEquals("world", queue.remove());
    }

    @Test(expected = NoSuchElementException.class)
    public void exampleEmpty() {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.remove();
    }

}
