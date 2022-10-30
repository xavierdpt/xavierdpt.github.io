package net.xdexamples.jse.examples.java.lang;

import java.util.concurrent.CountDownLatch;

public class ObjectExample_waitAndNotifyImpatient {

    public void example() throws InterruptedException {

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
