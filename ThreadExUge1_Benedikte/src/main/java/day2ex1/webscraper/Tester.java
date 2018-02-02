package day2ex1.webscraper;

import java.io.IOException;

public class Tester {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
// long start = System.nanoTime();
//    TagCounter tc1 = new TagCounter("http://www.fck.dk");
//    tc1.run();
//    TagCounter tc2= new TagCounter("http://www.google.com");
//    tc2.run();
//    TagCounter tc3= new TagCounter("http://politiken.dk/");
//    tc3.run();
//    long end = System.nanoTime();
//System.out.println("Time Sequential: "+(end-start));
//    System.out.println("Title: "+tc1.getTitle());
//    System.out.println("Div's: "+tc1.getDivCount());
//    System.out.println("Body's: "+tc1.getBodyCount());         
//    
//    
//    System.out.println("Title: "+tc2.getTitle());
//    System.out.println("Div's: "+tc2.getDivCount());
//    System.out.println("Body's: "+tc2.getBodyCount());   
//    
//    System.out.println("Title: "+tc3.getTitle());
//    System.out.println("Div's: "+tc3.getDivCount());
//System.out.println("Body's: "+tc3.getBodyCount()); 

  
//// } 

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                TagCounter tc1 = new TagCounter("http://www.fck.dk");
                tc1.run();
                System.out.println("Title: " + tc1.getTitle());
                System.out.println("Div's: " + tc1.getDivCount());
                System.out.println("Body's: " + tc1.getBodyCount());
            }
        });

        Thread t2 = new Thread(() -> {
            TagCounter tc2 = new TagCounter("http://www.google.com");
            tc2.run();
            System.out.println("Title: " + tc2.getTitle());
            System.out.println("Div's: " + tc2.getDivCount());
            System.out.println("Body's: " + tc2.getBodyCount());
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                TagCounter tc3 = new TagCounter("http://politiken.dk/");
                tc3.run();
                System.out.println("Title: " + tc3.getTitle());
                System.out.println("Div's: " + tc3.getDivCount());
                System.out.println("Body's: " + tc3.getBodyCount());
            }
        });
 long start = System.nanoTime();
        t1.start();

        t2.start();
        t3.start();
long end = System.nanoTime();
    

      
//t1.run();
//t2.run();
//t3.run(); 



System.out.println("Time : "+(end-start));


    }

}
/*
 
 */
