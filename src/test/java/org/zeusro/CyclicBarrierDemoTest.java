package org.zeusro;

import org.junit.Test;

public class CyclicBarrierDemoTest {

    @Test
    public void runSimulationTest() {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        demo.runSimulation(5, 3);
    }
}
