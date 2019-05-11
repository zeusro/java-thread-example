package org.zeusro;

import java.util.concurrent.*;

/**
 * Scheduled thread pool executor example
 * <p/>
 * Created in 2019.05.09
 * <p/>
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class ScheduledThreadPoolExecutorExample {

    public static void run() throws InterruptedException, ExecutionException {
        Runnable runnabledelayedTask = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is Running Delayed Task");
            }
        };


        Callable callabledelayedTask = new Callable() {

            @Override
            public String call() throws Exception {
                return "GoodBye! See you at another invocation...";
            }
        };
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(4);
        scheduledPool.scheduleWithFixedDelay(runnabledelayedTask, 1, 1, TimeUnit.SECONDS);
        ScheduledFuture sf = scheduledPool.schedule(callabledelayedTask, 4, TimeUnit.SECONDS);
        String value = (String) sf.get();
        System.out.println("Callable returned" + value);
        scheduledPool.shutdown();
        System.out.println("Is ScheduledThreadPool shutting down? " + scheduledPool.isShutdown());

    }
}
