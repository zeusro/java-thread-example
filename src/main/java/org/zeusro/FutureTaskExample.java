package org.zeusro;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * Future task example
 * <p/>
 * Created in 2019.06.05
 * <p/>
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class FutureTaskExample {

    public void run() throws InterruptedException, ExecutionException {
        FutureTask futureTask = new FutureTask(new CallableExample());
        futureTask.run();
        out.println((Integer) futureTask.get());
    }
}
