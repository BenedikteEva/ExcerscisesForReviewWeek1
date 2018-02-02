/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExPrepProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ejer
 */
public class FibonacciConsumer implements Runnable {

    private ArrayBlockingQueue<Long> S1;
    private ArrayBlockingQueue<Long> S2;
    long sumTotal = 0;

    List<Long> fibonacciEnd = new ArrayList<>();

    public FibonacciConsumer(ArrayBlockingQueue<Long> S2) {
        this.S2 = S2;
    }

    FibonacciConsumer() {

    }

    @Override
    public void run() {

     

            try {

                  FibonnaciProducer fb = new FibonnaciProducer(S1);
            
                    S2.offer((S1.take()));
                    fibonacciEnd.add(S2.take());
                    System.out.println("børge"+fibonacciEnd);
         
            } catch (InterruptedException ex) {
                Logger.getLogger(FibonacciConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    }

    public long getSumTotal() {

        for (int i = 0; i < fibonacciEnd.size(); i++) {

            sumTotal += fibonacciEnd.get(i);
        }

        return sumTotal;
    }

}
