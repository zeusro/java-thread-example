package org.zeusro;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

/**
 * Count down latch worker test
 * <p/>
 * Created in 2019.06.25
 * <p/>
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class CountDownLatchWorkerTest {

    @Test
    public void whenParallelProcessing_thenMainThreadWillBlockUntilCompletion() throws InterruptedException {

        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(5);
        List<Thread> workers = Stream
                .generate(() -> new Thread(new CountDownLatchWorker(outputScraper, countDownLatch)))
                .limit(5)
                .collect(toList());

        workers.forEach(Thread::start);
        out.println("waitting");
        countDownLatch.await();
//        outputScraper.add("Latch released");
        out.println("done");

//        assertThat(outputScraper)
//                .containsExactly(
//                        "Counted down",
//                        "Counted down",
//                        "Counted down",
//                        "Counted down",
//                        "Counted down",
//                        "Latch released"
//                                );
    }

}
