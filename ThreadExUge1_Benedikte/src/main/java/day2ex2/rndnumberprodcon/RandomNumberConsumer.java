package day2ex2.rndnumberprodcon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomNumberConsumer implements Runnable {

    ArrayBlockingQueue<Integer> numbersProduced;

    public RandomNumberConsumer(ArrayBlockingQueue<Integer> numbersProduced) {
        this.numbersProduced = numbersProduced;
    }
    //Should eventually hold the sum of all random number consumed
    int sumTotal = 0;
    List<Integer> below50 = new ArrayList();
    List<Integer> aboveOr50 = new ArrayList();

    @Override
    public void run() {
        try {
            //In this exercise, we start four threads, each producing 100 numbers, so we know how much to consume

            for (int i = 0; i < 100; i++) {
                int removeFromQueue = numbersProduced.take();
                if (removeFromQueue < 50) {

               
                    below50.add(removeFromQueue);

                } else {



                    aboveOr50.add(removeFromQueue);


                }

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomNumberConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getSumTotal() {
        sumTotal = below50.size() + aboveOr50.size();
        return sumTotal;
    }

    public List<Integer> getBelow50() {
        return below50;
    }

    public List<Integer> getAboveOr50() {
        return aboveOr50;
    }

}
