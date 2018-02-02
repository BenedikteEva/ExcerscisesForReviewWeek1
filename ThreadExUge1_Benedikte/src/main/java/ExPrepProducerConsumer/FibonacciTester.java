/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExPrepProducerConsumer;

import java.util.ArrayList;
import java.util.List;
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

        ArrayBlockingQueue<Long> S1 = new ArrayBlockingQueue(5);
      

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
}
