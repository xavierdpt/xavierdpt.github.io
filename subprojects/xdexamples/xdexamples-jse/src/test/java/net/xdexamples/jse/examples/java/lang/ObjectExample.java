package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.BaseExample;
import net.xdexamples.AllMethodsCovered;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@AllMethodsCovered
public class ObjectExample extends BaseExample<Object> {

    @Override
    public void scaffold(Object instance) throws InterruptedException {
        {
            Class<?> clazz = instance.getClass();
            seeExamples(this::example);
            ignore(clazz);
        }
        {
            int hashCode = instance.hashCode();
            seeExamples(this::example);
            ignore(hashCode);
        }
        {
            boolean isEqual = instance.equals(new Object());
            seeExamples(this::example);
            ignore(isEqual);
        }
        {
            String str = instance.toString();
            seeExamples(this::example);
            ignore(str);
        }
        {
            instance.notify();
            seeExamples(this::waitAndNotifyExample);
        }
        {
            instance.notifyAll();
            seeExamples(this::waitAndNotifyAllExample);
        }
        {
            instance.wait();
            seeExamples(
                    this::waitAndNotifyAllExample,
                    this::waitAndNotifyExample
            );
        }
        {
            instance.wait(1000);
            instance.wait(1000, 10);
            seeExamples(this::waitAndNotifyImpatientExample);
        }
    }


    @Test
    public void example() {
        Object object1 = new Object();
        Object object2 = new Object();
        assertEquals(Object.class, object1.getClass());
        assertTrue(object1.equals(object1));
        assertFalse(object1.equals(object2));

        String str = object1.toString();
        System.out.println(str);
        assertTrue(str.startsWith("java.lang.Object@"));

        // statistically true
        assertNotEquals(object1.hashCode(), object2.hashCode());
    }

    @Test
    public void waitAndNotifyAllExample() throws InterruptedException {

        Object object = new Object();

        CountDownLatch cdl = new CountDownLatch(4);

        Runnable runnable = () -> {
            try {
                synchronized (object) {
                    object.wait();
                }
                System.out.println("I am " + Thread.currentThread().getName());
            } catch (InterruptedException exception1) {
                throw new RuntimeException(exception1);
            } finally {
                cdl.countDown();
            }
        };
        new Thread(runnable, "Thread 1").start();
        new Thread(runnable, "Thread 2").start();
        new Thread(runnable, "Thread 3").start();

        new Thread(() -> {
            System.out.println("I am " + Thread.currentThread().getName());
            System.out.println("You'll have to wait for me");
            try {
                Thread.sleep(5000);
                synchronized (object) {
                    System.out.println("Ok you can go");
                    object.notifyAll();
                }
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            } finally {
                cdl.countDown();
            }
        }, "Thread X").start();
        cdl.await();

    }

    @Test
    public void waitAndNotifyExample() throws InterruptedException {

        Object object = new Object();

        CountDownLatch cdl = new CountDownLatch(4);

        Runnable runnable = () -> {
            try {
                synchronized (object) {
                    object.wait();
                }
                System.out.println("I am " + Thread.currentThread().getName());
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            } finally {
                cdl.countDown();
            }
        };
        new Thread(runnable, "Thread 1").start();
        new Thread(runnable, "Thread 2").start();
        new Thread(runnable, "Thread 3").start();

        new Thread(() -> {
            System.out.println("I am " + Thread.currentThread().getName());
            for (int i = 0; i < 3; i++) {
                System.out.println("You'll have to wait for me");
                try {
                    Thread.sleep(5000);
                    synchronized (object) {
                        System.out.println("Ok you can go");
                        object.notify();
                    }
                } catch (InterruptedException exception) {
                    throw new RuntimeException(exception);
                } finally {
                    cdl.countDown();
                }
            }
        }, "Thread X").start();
        cdl.await();

    }

    @Test
    public void waitAndNotifyImpatientExample() throws InterruptedException {

        Object object = new Object();

        CountDownLatch cdl = new CountDownLatch(4);

        Runnable runnable = () -> {
            try {
                synchronized (object) {
                    object.wait(3000);
                }
                System.out.println("I am " + Thread.currentThread().getName());
            } catch (InterruptedException exception1) {
                throw new RuntimeException(exception1);
            } finally {
                cdl.countDown();
            }
        };
        new Thread(runnable, "Thread 1").start();
        new Thread(runnable, "Thread 2").start();
        new Thread(runnable, "Thread 3").start();

        new Thread(() -> {
            System.out.println("I am " + Thread.currentThread().getName());
            System.out.println("You'll have to wait for me");
            try {
                Thread.sleep(5000);
                synchronized (object) {
                    System.out.println("Ok you can go");
                    object.notifyAll();
                }
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            } finally {
                cdl.countDown();
            }
        }, "Thread X").start();
        cdl.await();

    }

}
