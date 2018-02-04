package day2ex2.rndnumberprodcon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tester {

    public static void main(String[] args) throws InterruptedException {
        //This represent the Queue in the exercise-figure. Observe the size of the Queue
        ArrayBlockingQueue<Integer> numbers = new ArrayBlockingQueue(5);

        ExecutorService es = Executors.newCachedThreadPool();
        //Create and start four producers (P1-P4 in the exercise-figure)
         long start = System.nanoTime();
        es.execute(new RandomNumberProducer(numbers));
        es.execute(new RandomNumberProducer(numbers));
        es.execute(new RandomNumberProducer(numbers));
        es.execute(new RandomNumberProducer(numbers));

 long end = System.nanoTime();
        System.out.println("Nanotime"+(end - start));
        //Create and start single consumer (C1 in the exercise-figure)
        RandomNumberConsumer consumer = new RandomNumberConsumer(numbers);
        es.execute(consumer);

        es.shutdown();
        es.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Total of all random numbers: " + consumer.getSumTotal());
        System.out.println("Number of random numbers below 50: " + consumer.getBelow50().size());
        System.out.println("Number of random numbers >= 50: " + consumer.getAboveOr50().size());

    }
}
//Exercise 2 (Producer-Consumer)
//
//In this exercise you must create a simple Producer-Consumer design, with a number 
//of producers which create random numbers, which are consumed by a single consumer process.
//
//This figure illustrates what you have to implement.
//P1-P4 represents four Producer Threads, each producing a number of random numbers.
//Producers place all produced numbers in a shared data structure “Queue” (implemented 
//via a BlockingQueue implementation). A single Consumer Thread consumes all the produced Numbers.

//a) 
//Before you start you should understand the general idea, behind the exercise as described above
//by answering the following questions.
//If we need a “large” collection of random numbers, what is the advantage (if any) 
//of introducing threads to “produce” the numbers?
// --we can produce more at less time
//Why does the exercise suggest 4 producer threads, and is that always the right  number?
// --if I use the debugger it never gets to thread 3 or 4 in the thread pool. It depends on your computer
// number of processors and your processor speed. 
//Given that the Queue is a BlockingQueue implementation, how would you insert data 
//into the Queue (add(), offer(), put() ) if it’s limited in capacity, and items are 
//produced much faster than they are produced (Think: what happens when you insert into a full queue)?
//Given that the Queue is a BlockingQueue implementation, how would you fetch data from 
//the Queue (remove(), poll(), take() ) if Production is slow, compared to how we consume items
//
//b)  Use the code provided in day2.rndnumberprodcon as start code for this exercise.
//Compile and run the main method in Tester.
//
//c) Complete the run() method in the RandomNumberProducer class, by producing the 
//required number of random numbers and insert them into the numbersProduced Queue 
//(again, chose the right insert method).
//
//d) Complete the run() method in the RandomNumberConsumer class so that the sumTotal 
//variable is updated, and all consumed numbers are inserted into either the below50 or aboveOr50 Lists.
//
//f) Run and “verify” the behaviour of the completed program 
