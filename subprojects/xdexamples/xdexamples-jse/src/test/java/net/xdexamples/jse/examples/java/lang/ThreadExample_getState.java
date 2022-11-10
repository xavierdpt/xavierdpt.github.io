package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;

public class ThreadExample_getState {

    @Test
    public void example() throws InterruptedException {

        {
            Thread thread = new Thread(() -> {
            });
            Thread.State state = thread.getState();
            assertEquals(Thread.State.NEW, state);
        }

        {
            Thread thread = new Thread(() -> {
            });
            thread.start();
            Thread.State state = thread.getState();
            assertEquals(Thread.State.RUNNABLE, state);
        }

        {
            Thread thread = new Thread(() -> {
            });
            thread.start();
            thread.join();

            Thread.State state = thread.getState();
            assertEquals(Thread.State.TERMINATED, state);
        }

        {
            CountDownLatch cdl = new CountDownLatch(1);
            Thread thread = new Thread(() -> {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
            Thread.sleep(100L);
            Thread.State state = thread.getState();
            assertEquals(Thread.State.WAITING, state);
            cdl.countDown();
            thread.join();
        }

        {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
            Thread.sleep(100L);
            Thread.State state = thread.getState();
            assertEquals(Thread.State.TIMED_WAITING, state);
            thread.join();
        }

        {
            Object monitor = new Object();
            Thread thread = new Thread(() -> {
                synchronized (monitor) {
                    Thread.yield();
                }
            });

            Thread holder = new Thread(() -> {
                try {
                    synchronized (monitor) {
                        Thread.sleep(5000L);

                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            holder.start();
            Thread.sleep(100L);

            thread.start();
            Thread.sleep(100L);

            Thread.State state = thread.getState();
            assertEquals(Thread.State.BLOCKED, state);

            holder.join();
            thread.join();
        }


    }

}
