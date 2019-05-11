package org.zeusro;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

import static java.lang.System.out;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Scheduled executor service example
 * <p/>
 * Created in 2019.05.08
 * <p/>
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class ScheduledExecutorServiceExample {

    //     Executors.newScheduledThreadPool(1);
    ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("ScheduledExecutorServiceExample-%d").build();
    private final ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1, factory);


    public void beepForAWhile()throws InterruptedException {
        final Runnable beeper = new Runnable() {
            @Override
            public void run() {
                out.println(new Date() + " : beep");
            }
        };
        //延迟1秒后,每隔1秒执行一次beeper,
        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 1, 1, SECONDS);
        //5秒后延迟退出
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                beeperHandle.cancel(true);
                scheduler.shutdownNow();
            }
        }, 5, SECONDS);
//        scheduler.notifyAll();
    }

}
