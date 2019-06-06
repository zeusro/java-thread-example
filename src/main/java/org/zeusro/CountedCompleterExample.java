package org.zeusro;

import org.zeusro.util.CalcUtil;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

public class CountedCompleterExample extends CountedCompleter<BigInteger> {
    private static int SEQUENTIAL_THRESHOLD = 5;
    private List<BigInteger> integerList;
    private AtomicReference<BigInteger> result;

    public CountedCompleterExample(CountedCompleter<BigInteger> parent,
                         AtomicReference<BigInteger> result,
                         List<BigInteger> integerList) {
        super(parent);
        this.integerList = integerList;
        this.result = result;
    }

    @Override
    public BigInteger getRawResult() {
        return result.get();
    }

    @Override
    public void compute() {

        //this example creates all sub-tasks in this while loop
        while (integerList.size() > SEQUENTIAL_THRESHOLD) {

            //end of the list containing SEQUENTIAL_THRESHOLD items.
            List<BigInteger> newTaskList = integerList.subList(integerList.size() -
                    SEQUENTIAL_THRESHOLD, integerList.size());

            //remaining list
            integerList = integerList.subList(0, integerList.size() - SEQUENTIAL_THRESHOLD);

            addToPendingCount(1);
            CountedCompleterExample task = new CountedCompleterExample(this, result, newTaskList);
            task.fork();
        }
        //find sum of factorials of the remaining this.integerList
        sumFactorials();
        propagateCompletion();
    }


    private void addFactorialToResult(BigInteger factorial) {
        result.getAndAccumulate(factorial, (b1, b2) -> b1.add(b2));
    }

    private void sumFactorials() {

        for (BigInteger i : integerList) {
            addFactorialToResult(CalcUtil.calculateFactorial(i));
        }
    }
}

