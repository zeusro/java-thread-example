package org.zeusro;

import java.util.concurrent.*;

/**
 * Completion service example
 * <p/>
 * Created in 2019.05.08
 * <p/>
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class CompletionServiceExample {

    int TOTAL_TASK = 2;

    public void run() throws InterruptedException, ExecutionException {
        // 创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(TOTAL_TASK);
        CompletionService<Integer> cService = new ExecutorCompletionService<>(pool);

        // 向里面扔任务
        for (int i = 0; i < TOTAL_TASK; i++) {
            cService.submit(new CallableExample());
            //重载的这个submit(Runnable task, V result)方法,是自行把结果传入
        }
        // 检查线程池任务执行结果
        for (int i = 0; i < TOTAL_TASK; i++) {
            Future<Integer> future = cService.take();
            System.out.println("method:" + future.get());
        }
        // 关闭线程池
        pool.shutdown();
    }
}
