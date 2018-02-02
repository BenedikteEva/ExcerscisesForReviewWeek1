/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExPrepProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;


/**
 *
 * @author Ejer
 */
public class FibonnaciProducer implements Runnable {

   ArrayBlockingQueue<Long> S1;

  
     public static List fibonacciBase() {
        List  fb = new ArrayList<>();
        fb.add(4);
        fb.add(5);
        fb.add(8);
        fb.add(12);
        fb.add(21);
        fb.add(22);
        fb.add(34);
        fb.add(35);
        fb.add(36);
        fb.add(37);
        fb.add(42);

        return fb;
    }
    
  

    public FibonnaciProducer(ArrayBlockingQueue<Long> FibonacciProduced) {
        this.S1 = FibonacciProduced;
    }

    FibonnaciProducer() {
     
    }

    private synchronized long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i <fibonacciBase().size(); i++) {
          
         
              S1.offer(fib((int) fibonacciBase().get(i)));
        
                
         
         
          
    
        }
    }

}
