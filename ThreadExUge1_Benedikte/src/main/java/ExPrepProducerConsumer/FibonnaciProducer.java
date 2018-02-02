/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExPrepProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ejer
 */
public class FibonnaciProducer implements Runnable {

    private final ArrayBlockingQueue<Long> S1;

    public FibonnaciProducer(ArrayBlockingQueue<Long> S1) {
        this.S1 = S1;

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
        
        S1.offer((fib(4)));
        S1.offer((fib(5)));
        S1.offer((fib(8)));
        S1.offer((fib(12)));
        S1.offer((fib(21)));
        S1.offer((fib(22)));
        S1.offer((fib(34)));
        S1.offer((fib(35)));
        S1.offer((fib(36)));
        S1.offer((fib(37)));
        S1.offer((fib(42)));
      
          
        }
    }


