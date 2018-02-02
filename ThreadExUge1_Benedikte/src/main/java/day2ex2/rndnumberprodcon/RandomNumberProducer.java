package day2ex2.rndnumberprodcon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class RandomNumberProducer implements Runnable{

  public static final int MAX_NUMBERS_TO_PRODUCE = 100;
  public static final int MAX_RANDOM = 100;

  ArrayBlockingQueue<Integer> numbersProduced;

  public RandomNumberProducer(ArrayBlockingQueue<Integer> numbersProduced) {
    this.numbersProduced = numbersProduced;
  }
  
  @Override
  public void run() {
      
     
    for (int i = 0; i < MAX_NUMBERS_TO_PRODUCE; i++) {
     
        try {
            int rdm = (int) ((Math.random() * MAX_RANDOM+1));
            numbersProduced.offer(rdm, 10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            
            System.out.println(ex.getMessage());
        }
        } 
   
  }}
  
 
 

  

