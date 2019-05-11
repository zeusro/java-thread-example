package org.zeusro;

import java.util.Date;

import static java.lang.System.out;

/**
 * Main
 * <p/>
 * Created in 2019.05.08
 * <p/>
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class Main {

    public static void main(String[] args) {
        try {
//            CallableExample example = new CallableExample();
//            example.call();
//            CompletionServiceExample example=new CompletionServiceExample();
//            example.run();

             out.println(new Date());
            ScheduledExecutorServiceExample scheduledExecutorServiceExample = new ScheduledExecutorServiceExample();
            scheduledExecutorServiceExample.beepForAWhile();
        } catch (Exception e) {
            out.println(e);
        }

        out.println("666");
    }


}
