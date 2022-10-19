package xd.examples.java.util.concurrent.locks;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    AbstractOwnableSynchronizer.class,
                    AbstractQueuedLongSynchronizer.class,
                    AbstractQueuedSynchronizer.class,
                    Condition.class,
                    Lock.class,
                    LockSupport.class,
                    ReadWriteLock.class,
                    ReentrantLock.class,
                    ReentrantReadWriteLock.class,
                    StampedLock.class
            ));
        }
    }

}
