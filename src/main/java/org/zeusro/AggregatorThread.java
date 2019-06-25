package org.zeusro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * Aggregator thread
 * <p/>
 * Created in 2019.06.25
 * <p/>
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class AggregatorThread implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private List<List<Integer>> partialResults
            = Collections.synchronizedList(new ArrayList<>());
    private Random random = new Random();
    private int NUM_PARTIAL_RESULTS;
    private int NUM_WORKERS;

    @Override
    public void run() {

        String thisThreadName = Thread.currentThread().getName();

        System.out.println(
                thisThreadName + ": Computing sum of " + NUM_WORKERS
                        + " workers, having " + NUM_PARTIAL_RESULTS + " results each.");
        int sum = 0;

        for (List<Integer> threadResult : partialResults) {
            System.out.print("Adding ");
            for (Integer partialResult : threadResult) {
                System.out.print(partialResult + " ");
                sum += partialResult;
            }
            System.out.println();
        }
        System.out.println(thisThreadName + ": Final result = " + sum);
    }
}
