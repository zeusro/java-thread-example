package org.zeusro;

import java.util.concurrent.RecursiveTask;

/**
 * Recursive task example
 * <p/>
 * Created in 2019.06.06
 * <p/>
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class RecursiveTaskExample extends RecursiveTask<Integer> {
    final int n;

    RecursiveTaskExample(int n) {
        this.n = n;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        RecursiveTaskExample f1 = new RecursiveTaskExample(n - 1);
        f1.fork();
        RecursiveTaskExample f2 = new RecursiveTaskExample(n - 2);
        return f2.compute() + f1.join();
    }
}
