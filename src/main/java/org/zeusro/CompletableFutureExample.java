package org.zeusro;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * Completable future example
 * <p/>
 * Created in 2019.06.05
 * <p/>
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class CompletableFutureExample {

    int i = 1;

    public void run() throws InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            i = i << 1;
            return "end 1";
        });

        future.thenApply((s) -> {
            //把上个任务的结果传递到子任务中
            out.println(s);
            out.println("end 2");
            i = i << 1;
            return "hhh";
        });
        future.thenRun(() -> {
            try {
                Thread.sleep(1000);
                i = i << 1;
            } catch (InterruptedException e) {

            }
            out.println("CompletableFutureExample end");
        });
        //通过这个信号,持续等待子线程运行完毕
        while (i != 8) {
            Thread.sleep(500);
            out.println("继续等待");
        }
//        future.join();
//        CompletableFuture.allOf(future).join();
    }
}
