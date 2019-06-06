package org.zeusro;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Callable example
 * <p/>
 * Created in 2019.05.08
 * <p/>
 * 参考 https://examples.javacodegeeks.com/core-java/util/concurrent/completionservice/java-completionservice-example/
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class CallableExample implements Callable {

    @Override
    public Integer call() throws Exception {
        // Create random number generator
        Random generator = new Random();
        Integer min = 1;
        Integer randomNumber = generator.nextInt(5 - min) + min + 1;
        Thread.sleep(3000);
        // To simulate a heavy computation,
        // we delay the thread for some random time
//        Thread.sleep(randomNumber * 1000);

        return randomNumber;
    }
}
