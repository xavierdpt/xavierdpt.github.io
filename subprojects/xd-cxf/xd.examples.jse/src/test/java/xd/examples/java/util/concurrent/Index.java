package xd.examples.java.util.concurrent;

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

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    AbstractExecutorService.class,
                    ArrayBlockingQueue.class,
                    BlockingDeque.class,
                    BlockingQueue.class,
                    BrokenBarrierException.class,
                    Callable.class,
                    CancellationException.class,
                    CompletableFuture.class,
                    CompletionException.class,
                    CompletionService.class,
                    CompletionStage.class,
                    ConcurrentHashMap.class,
                    ConcurrentLinkedDeque.class,
                    ConcurrentLinkedQueue.class,
                    ConcurrentMap.class,
                    ConcurrentNavigableMap.class,
                    ConcurrentSkipListMap.class,
                    ConcurrentSkipListSet.class,
                    CopyOnWriteArrayList.class,
                    CopyOnWriteArraySet.class,
                    CountDownLatch.class,
                    CountedCompleter.class,
                    CyclicBarrier.class,
                    Delayed.class,
                    DelayQueue.class,
                    Exchanger.class,
                    ExecutionException.class,
                    Executor.class,
                    ExecutorCompletionService.class,
                    Executors.class,
                    ExecutorService.class,
                    Flow.class,
                    ForkJoinPool.class,
                    ForkJoinTask.class,
                    ForkJoinWorkerThread.class,
                    Future.class,
                    FutureTask.class,
                    LinkedBlockingDeque.class,
                    LinkedBlockingQueue.class,
                    LinkedTransferQueue.class,
                    Phaser.class,
                    PriorityBlockingQueue.class,
                    RecursiveAction.class,
                    RecursiveTask.class,
                    RejectedExecutionException.class,
                    RejectedExecutionHandler.class,
                    RunnableFuture.class,
                    RunnableScheduledFuture.class,
                    ScheduledExecutorService.class,
                    ScheduledFuture.class,
                    ScheduledThreadPoolExecutor.class,
                    Semaphore.class,
                    SubmissionPublisher.class,
                    SynchronousQueue.class,
                    ThreadFactory.class,
                    ThreadLocalRandom.class,
                    ThreadPoolExecutor.class,
                    TimeoutException.class,
                    TimeUnit.class,
                    TransferQueue.class
            ));
        }
    }

}
