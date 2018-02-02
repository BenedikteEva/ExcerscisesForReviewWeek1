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
public class FibonacciTester1 {
    
    static ArrayBlockingQueue<Long> S1 = new ArrayBlockingQueue(5);
  static FibonacciConsumer fc = new FibonacciConsumer();
   static FibonnaciProducer fb = new FibonnaciProducer(S1);
    public static void main(String[] args) throws InterruptedException {

       
      
        Thread P1 = new Thread(new Runnable() {
            @Override
            public void run() {
     
         
             fb.run();
        }});

        Thread P2 = new Thread(() -> {
        
         fb.run();
        });

        Thread P3 = new Thread(() -> {
          fb.run();
        });

        Thread P4 = new Thread(() -> {
        fb.run();
        });

        Thread C1 = new Thread(() -> {
          
            fc.run();
          
          
        });
        long start = System.nanoTime();
        P1.start();
        P2.start();
        P3.start();
        P4.start();
        C1.start();
        long end = System.nanoTime();
        System.out.println("Nanotime"+(end - start));
           System.out.println("FibonacciNumbers sum: " + fc.getSumTotal());
            
    }
}
