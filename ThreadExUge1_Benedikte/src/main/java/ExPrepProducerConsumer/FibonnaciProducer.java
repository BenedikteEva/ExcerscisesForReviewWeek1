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
    BlockingQueue<Long> Fibbos;

    public FibonnaciProducer(ArrayBlockingQueue<Long> S1, ArrayBlockingQueue<Long> Fibbos) {
        this.S1 = S1;
        this.Fibbos = Fibbos;
    }

    FibonnaciProducer(ArrayBlockingQueue<Long> S1) {
     
    }

//  public FibonnaciProducer(ArrayBlockingQueue<Long> S1) {
//        this.S1 = S1;
//
//    }
    public synchronized long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    @Override
    public void run() {

        boolean moreUrlsToFecth = true;
        while (moreUrlsToFecth) {
            long fibbo = S1.peek();
//TODO: Use the right method on urlsToUse to set this value to either a string (with a url) or null
            if (fibbo == 0) {
                moreUrlsToFecth = false;
            } else {

                Fibbos.offer(fibbo);
                S1.poll();
                //TODO Use the right method on producedDocuments to add this doc to the queue

            }

        }

    }
}
