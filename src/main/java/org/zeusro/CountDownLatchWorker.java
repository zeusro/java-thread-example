package org.zeusro;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static java.lang.System.out;

/**
 * Count down latch worker
 * <p/>
 * Created in 2019.06.25
 * <p/>
 * https://www.baeldung.com/java-countdown-latch
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class CountDownLatchWorker implements Runnable {

    private List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public CountDownLatchWorker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            doSomeWork();
        } catch (InterruptedException e) {
        }
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }

    public void doSomeWork() throws InterruptedException {
        Random random = new Random();
        int i = random.nextInt(2000);
        i += 1000;
        Thread.sleep(i);
        out.println(Thread.currentThread().getId());
    }
}
