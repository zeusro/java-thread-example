package org.zeusro;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Executor service example
 * <p/>
 * Created in 2019.05.08
 * <p/>
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class ExecutorServiceExample {

    static void run() {
        //guava
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("ExecutorServiceExample-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(1,
                200,
                0L,
                TimeUnit.DAYS,
                new LinkedBlockingDeque<Runnable>(1024), factory, new ExampleRejectedExecutionHandler());
//        ExecutorService executor = Executors.newCachedThreadPool();
        CallableExample task = new CallableExample();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("主线程在执行任务");
        try {
            System.out.println("task运行结果: " + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }

}
