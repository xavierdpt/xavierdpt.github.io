package net.xdexamples.jse.index.java.util.concurrent;

import net.xdexamples.ExampleIndex;
import net.xdexamples.jse.examples.java.util.concurrent.AbstractExecutorServiceExample;
import net.xdexamples.jse.examples.java.util.concurrent.ArrayBlockingQueueExample;
import net.xdexamples.jse.examples.java.util.concurrent.BlockingDequeExample;
import net.xdexamples.jse.examples.java.util.concurrent.BlockingQueueExample;
import net.xdexamples.jse.examples.java.util.concurrent.CallableExample;
import net.xdexamples.jse.examples.java.util.concurrent.CompletableFutureExample;
import net.xdexamples.jse.examples.java.util.concurrent.CompletionServiceExample;
import net.xdexamples.jse.examples.java.util.concurrent.CompletionStageExample;
import net.xdexamples.jse.examples.java.util.concurrent.ConcurrentHashMapExample;
import net.xdexamples.jse.examples.java.util.concurrent.ConcurrentLinkedDequeExample;
import net.xdexamples.jse.examples.java.util.concurrent.ConcurrentLinkedQueueExample;
import net.xdexamples.jse.examples.java.util.concurrent.ConcurrentMapExample;
import net.xdexamples.jse.examples.java.util.concurrent.ConcurrentNavigableMapExample;
import net.xdexamples.jse.examples.java.util.concurrent.ConcurrentSkipListMapExample;
import net.xdexamples.jse.examples.java.util.concurrent.ConcurrentSkipListSetExample;
import net.xdexamples.jse.examples.java.util.concurrent.CopyOnWriteArrayListExample;
import net.xdexamples.jse.examples.java.util.concurrent.CopyOnWriteArraySetExample;
import net.xdexamples.jse.examples.java.util.concurrent.CountDownLatchExample;
import net.xdexamples.jse.examples.java.util.concurrent.CountedCompleterExample;
import net.xdexamples.jse.examples.java.util.concurrent.CyclicBarrierExample;
import net.xdexamples.jse.examples.java.util.concurrent.DelayQueueExample;
import net.xdexamples.jse.examples.java.util.concurrent.DelayedExample;
import net.xdexamples.jse.examples.java.util.concurrent.ExchangerExample;
import net.xdexamples.jse.examples.java.util.concurrent.ExecutorCompletionServiceExample;
import net.xdexamples.jse.examples.java.util.concurrent.ExecutorExample;
import net.xdexamples.jse.examples.java.util.concurrent.ExecutorServiceExample;
import net.xdexamples.jse.examples.java.util.concurrent.ExecutorsExample;
import net.xdexamples.jse.examples.java.util.concurrent.FlowExample;
import net.xdexamples.jse.examples.java.util.concurrent.ForkJoinPoolExample;
import net.xdexamples.jse.examples.java.util.concurrent.ForkJoinTaskExample;
import net.xdexamples.jse.examples.java.util.concurrent.ForkJoinWorkerThreadExample;
import net.xdexamples.jse.examples.java.util.concurrent.FutureExample;
import net.xdexamples.jse.examples.java.util.concurrent.FutureTaskExample;
import net.xdexamples.jse.examples.java.util.concurrent.LinkedBlockingDequeExample;
import net.xdexamples.jse.examples.java.util.concurrent.LinkedBlockingQueueExample;
import net.xdexamples.jse.examples.java.util.concurrent.LinkedTransferQueueExample;
import net.xdexamples.jse.examples.java.util.concurrent.PhaserExample;
import net.xdexamples.jse.examples.java.util.concurrent.PriorityBlockingQueueExample;
import net.xdexamples.jse.examples.java.util.concurrent.RecursiveActionExample;
import net.xdexamples.jse.examples.java.util.concurrent.RecursiveTaskExample;
import net.xdexamples.jse.examples.java.util.concurrent.RejectedExecutionHandlerExample;
import net.xdexamples.jse.examples.java.util.concurrent.RunnableFutureExample;
import net.xdexamples.jse.examples.java.util.concurrent.RunnableScheduledFutureExample;
import net.xdexamples.jse.examples.java.util.concurrent.ScheduledExecutorServiceExample;
import net.xdexamples.jse.examples.java.util.concurrent.ScheduledFutureExample;
import net.xdexamples.jse.examples.java.util.concurrent.ScheduledThreadPoolExecutorExample;
import net.xdexamples.jse.examples.java.util.concurrent.SemaphoreExample;
import net.xdexamples.jse.examples.java.util.concurrent.SubmissionPublisherExample;
import net.xdexamples.jse.examples.java.util.concurrent.SynchronousQueueExample;
import net.xdexamples.jse.examples.java.util.concurrent.ThreadFactoryExample;
import net.xdexamples.jse.examples.java.util.concurrent.ThreadLocalRandomExample;
import net.xdexamples.jse.examples.java.util.concurrent.ThreadPoolExecutorExample;
import net.xdexamples.jse.examples.java.util.concurrent.TimeUnitExample;
import net.xdexamples.jse.examples.java.util.concurrent.TransferQueueExample;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.Phaser;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TransferQueue;

@ExampleIndex({

        AbstractExecutorService.class,
        AbstractExecutorServiceExample.class,

        ArrayBlockingQueue.class,
        ArrayBlockingQueueExample.class,

        BlockingDeque.class,
        BlockingDequeExample.class,

        BlockingQueue.class,
        BlockingQueueExample.class,

        BrokenBarrierException.class,

        Callable.class,
        CallableExample.class,

        CancellationException.class,

        CompletableFuture.class,
        CompletableFutureExample.class,

        CompletionException.class,

        CompletionService.class,
        CompletionServiceExample.class,

        CompletionStage.class,
        CompletionStageExample.class,

        ConcurrentHashMap.class,
        ConcurrentHashMapExample.class,

        ConcurrentLinkedDeque.class,
        ConcurrentLinkedDequeExample.class,

        ConcurrentLinkedQueue.class,
        ConcurrentLinkedQueueExample.class,

        ConcurrentMap.class,
        ConcurrentMapExample.class,

        ConcurrentNavigableMap.class,
        ConcurrentNavigableMapExample.class,

        ConcurrentSkipListMap.class,
        ConcurrentSkipListMapExample.class,

        ConcurrentSkipListSet.class,
        ConcurrentSkipListSetExample.class,

        CopyOnWriteArrayList.class,
        CopyOnWriteArrayListExample.class,

        CopyOnWriteArraySet.class,
        CopyOnWriteArraySetExample.class,

        CountDownLatch.class,
        CountDownLatchExample.class,

        CountedCompleter.class,
        CountedCompleterExample.class,

        CyclicBarrier.class,
        CyclicBarrierExample.class,

        Delayed.class,
        DelayedExample.class,

        DelayQueue.class,
        DelayQueueExample.class,

        Exchanger.class,
        ExchangerExample.class,

        ExecutionException.class,

        Executor.class,
        ExecutorExample.class,

        ExecutorCompletionService.class,
        ExecutorCompletionServiceExample.class,

        Executors.class,
        ExecutorsExample.class,

        ExecutorService.class,
        ExecutorServiceExample.class,

        Flow.class,
        FlowExample.class,

        ForkJoinPool.class,
        ForkJoinPoolExample.class,

        ForkJoinTask.class,
        ForkJoinTaskExample.class,

        ForkJoinWorkerThread.class,
        ForkJoinWorkerThreadExample.class,

        Future.class,
        FutureExample.class,

        FutureTask.class,
        FutureTaskExample.class,

        LinkedBlockingDeque.class,
        LinkedBlockingDequeExample.class,

        LinkedBlockingQueue.class,
        LinkedBlockingQueueExample.class,

        LinkedTransferQueue.class,
        LinkedTransferQueueExample.class,

        Phaser.class,
        PhaserExample.class,

        PriorityBlockingQueue.class,
        PriorityBlockingQueueExample.class,

        RecursiveAction.class,
        RecursiveActionExample.class,

        RecursiveTask.class,
        RecursiveTaskExample.class,

        RejectedExecutionException.class,

        RejectedExecutionHandler.class,
        RejectedExecutionHandlerExample.class,

        RunnableFuture.class,
        RunnableFutureExample.class,

        RunnableScheduledFuture.class,
        RunnableScheduledFutureExample.class,

        ScheduledExecutorService.class,
        ScheduledExecutorServiceExample.class,

        ScheduledFuture.class,
        ScheduledFutureExample.class,

        ScheduledThreadPoolExecutor.class,
        ScheduledThreadPoolExecutorExample.class,

        Semaphore.class,
        SemaphoreExample.class,

        SubmissionPublisher.class,
        SubmissionPublisherExample.class,

        SynchronousQueue.class,
        SynchronousQueueExample.class,

        ThreadFactory.class,
        ThreadFactoryExample.class,

        ThreadLocalRandom.class,
        ThreadLocalRandomExample.class,

        ThreadPoolExecutor.class,
        ThreadPoolExecutorExample.class,

        TimeoutException.class,

        TimeUnit.class,
        TimeUnitExample.class,

        TransferQueue.class,
        TransferQueueExample.class

})
public class Index {


}
