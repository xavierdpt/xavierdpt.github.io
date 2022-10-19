package xd.examples.java.util;

import org.junit.Assert;
import org.junit.Test;
import xd.BaseExample;
import xd.helpers.dummies.Dummy;
import xdtest.Done;
import xdtest.SeeAlso;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

@Done
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
