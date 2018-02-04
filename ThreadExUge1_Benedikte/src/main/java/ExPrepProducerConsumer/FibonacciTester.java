/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExPrepProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ejer
 */
public class FibonacciTester {

 
    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Long> S1 = new ArrayBlockingQueue(20);
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

        ExecutorService es = Executors.newCachedThreadPool();
      
        es.execute(new FibonnaciProducer(S1));
      
        es.execute(new FibonnaciProducer(S1));
       
        es.execute(new FibonnaciProducer(S1));
      
        es.execute(new FibonnaciProducer(S1));
      
        FibonacciConsumer consumer = new FibonacciConsumer(S1);
        es.execute(consumer);

        es.shutdown();
        es.awaitTermination(5, TimeUnit.SECONDS);

   
        System.out.println("Fibonaccinumbers sum: " + consumer.getSumTotal());
    }


    public static synchronized long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}