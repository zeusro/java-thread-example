package org.zeusro;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Example rejected execution handler
 * <p/>
 * Created in 2019.05.08
 * <p/>
 *
 * @author <a href="https://zeusro.github.io/" style="background: #55a7e3;">Zeusro</a>
 */
public class ExampleRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable worker, ThreadPoolExecutor executor) {
        System.out.println(worker.toString() + " is Rejected");

        System.out.println("Retrying to Execute");
        try {
            //Re-executing with alternateExecutor
//            RejectedExecutionHandlerExample.alternateExecutor.execute(worker);
            System.out.println(worker.toString() + " Execution Started");
        } catch (Exception e) {
            System.out.println("Failure to Re-exicute " + e.getMessage());
        }
    }
}
