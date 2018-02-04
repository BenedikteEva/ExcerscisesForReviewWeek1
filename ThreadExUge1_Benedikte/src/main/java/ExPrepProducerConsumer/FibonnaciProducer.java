/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExPrepProducerConsumer;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ejer
 */
public class FibonnaciProducer implements Runnable {

    BlockingQueue<Long> S1;
    BlockingQueue<Long> S2;

    public FibonnaciProducer(BlockingQueue<Long> S1,BlockingQueue<Long> S2) {
        this.S1 = S1;
        this.S2 = S2;
    }

    FibonnaciProducer(ArrayBlockingQueue<Long> S1) {

    }

    public synchronized long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    @Override
    public void run() {
 
        boolean moreFibsToFecth = true;
        while (moreFibsToFecth) {
           

            if (S1.isEmpty()) {
                moreFibsToFecth = false;
            } else {

                long fibbo = S1.peek();
             
                S2.offer(fibbo);
                S1.poll();
            

            }

        }

    }
}
