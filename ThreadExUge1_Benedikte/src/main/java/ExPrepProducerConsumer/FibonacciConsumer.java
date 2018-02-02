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

    private ArrayBlockingQueue<Long> S2;
    volatile long sumTotal = 0;

    List<Long> fibonacciEnd = new ArrayList<>(11);

    public FibonacciConsumer(ArrayBlockingQueue<Long> S2) {
        this.S2 = S2;
    }

    FibonacciConsumer() {
       
    }

    

    @Override
    public void run() {

        for (int i = 0; i < S2.size(); i++) {

          


               try { 
                
                
                fibonacciEnd.add(S2.take());
                
                
                } catch (InterruptedException ex) {
                    Logger.getLogger(FibonacciConsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
      
                
           
        }
    }

    public long getSumTotal() {
        
      
        for (int i = 0; i < fibonacciEnd.size(); i++) {

            sumTotal+= fibonacciEnd.get(i);
        }

        return sumTotal;
    }

}
