package org.zeusro;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicReference;

public class CountedCompleterExampleTest {

    @Test
    public void TestCountedCompleterExample() {
        List<BigInteger> list = new ArrayList<>();
        for (int i = 3; i < 20; i++) {
            list.add(new BigInteger(Integer.toString(i)));
        }

        BigInteger sum = ForkJoinPool.commonPool().
                invoke(new CountedCompleterExample(null, new AtomicReference<>(new BigInteger("0")), list));
        System.out.println("Sum of the factorials = " + sum);
    }
}
