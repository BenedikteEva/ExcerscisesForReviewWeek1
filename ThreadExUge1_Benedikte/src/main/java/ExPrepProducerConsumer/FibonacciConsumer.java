/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExPrepProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ejer
 */
public class FibonacciConsumer implements Runnable {

    private ArrayBlockingQueue<Long> S1;
  
    BlockingQueue <Long>S2;
    long sumTotal = 0;
    long fibboTemp;

    List<Long> fibonacciEnd = new ArrayList<>();

    public FibonacciConsumer(BlockingQueue<Long> S2) {
        this.S2 = S2;
    }

    FibonacciConsumer(ArrayBlockingQueue<Long> S1, ArrayBlockingQueue<Long> S2) {
         this.S1 = S1;
      this.S2 = S2;
    }

  

    @Override
    public void run() {
        boolean moreFibonaccisToConsume = true;

        while (moreFibonaccisToConsume) {
            long fibOne = S2.peek();
            if (fibOne == 0) {
                moreFibonaccisToConsume = false;
                System.out.println("end");
            } else {
                
                fibonacciEnd.add( fibOne);
//                System.out.println("børge:  " + fibonacciEnd);
                fibboTemp=S2.poll();
            }

        }
    }

    public long getSumTotal() {

        for (int i = 0; i < fibonacciEnd.size(); i++) {

            sumTotal += fibonacciEnd.get(i);
        }

        return sumTotal;
    }

}
