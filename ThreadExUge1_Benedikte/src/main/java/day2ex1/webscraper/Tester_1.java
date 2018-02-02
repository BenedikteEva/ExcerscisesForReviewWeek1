package day2ex1.webscraper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;

public class Tester_1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());

    TagCounter tc1 = new TagCounter("http://www.fck.dk");
 
    TagCounter tc2= new TagCounter("http://www.google.com");

    TagCounter tc3= new TagCounter("http://politiken.dk/");
    long start = System.nanoTime();
        tc1.run();
        tc2.run();
        tc3.run();
        long end = System.nanoTime();
        System.out.println("Time Sequential: " + (end - start));

    System.out.println("Title: "+tc1.getTitle());
    System.out.println("Div's: "+tc1.getDivCount());
    System.out.println("Body's: "+tc1.getBodyCount());         
    
    
    System.out.println("Title: "+tc2.getTitle());
    System.out.println("Div's: "+tc2.getDivCount());
    System.out.println("Body's: "+tc2.getBodyCount());   
    
    System.out.println("Title: "+tc3.getTitle());
    System.out.println("Div's: "+tc3.getDivCount());
System.out.println("Body's: "+tc3.getBodyCount()); 
 
//        Thread t1 = new Thread(() -> {
//            try {
//                TagCounter tc1 = new TagCounter("http://www.fck.dk");
//
//                System.out.println("Title: " + Jsoup.connect("http://www.fck.dk").get().title());
//                System.out.println("Div's: " + Jsoup.connect("http://www.fck.dk").get().select("div").size());
//                System.out.println("Body's: " + Jsoup.connect("http://www.fck.dk").get().select("body").size());
//            } catch (IOException ex) {
//                Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            try {
//                TagCounter tc2 = new TagCounter("http://www.google.com");
//
//                System.out.println("Title: " + Jsoup.connect("http://www.google.com").get().title());
//                System.out.println("Div's: " + Jsoup.connect("http://www.google.com").get().select("div").size());
//                System.out.println("Body's: " + Jsoup.connect("http://www.google.com").get().select("body").size());
//            } catch (IOException ex) {
//                Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//
//        Thread t3 = new Thread(() -> {
//
//            try {
//                TagCounter tc3 = new TagCounter("http://politiken.dk/");
//                System.out.println("Title: " + Jsoup.connect("http://politiken.dk").get().title());
//                System.out.println("Div's: " + Jsoup.connect("http://politiken.dk").get().select("div").size());
//                System.out.println("Body's: " + Jsoup.connect("http://politiken.dk").get().select("body").size());
//            } catch (IOException ex) {
//                Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        });
//        long start = System.nanoTime();
//        t1.start();
//
//        t2.start();
//
//        t3.start();
//
//        long end = System.nanoTime();
//        System.out.println("Time Sequential: " + (end - start));
      


    }

}
/*
  Exercise1 (Basic Threads, and measuring performance) 
Why is this exercise green? It’s green because it assumes you did the basic thread 
exercises from day-1. If, then there is really nothing new in this exercise, except 
that the problem is a “bit more realistic”.

Use the start code in day2.webscraper for this exercise. The example uses a library
jsoup (see the pom-file) to web-scrape information from 3 different web-pages.
This library abstracts away most of the details with performing a programmatically 
request up against a web site and parse the received HTML.
Since accessing a remote URL involves a lot of blocking (we will talk more about this next week),
the main purpose with this exercise is to see whether there is any (performance) 
benefit in performing the three request via three separate threads.

a)
Run the main method in the Tester class, and make sure you understand conceptually 
what happens. Especially you should note that these lines : tcX.run() probably takes
a noticeable amount of time (why?)

b)
Refactor the TagCounter class to extend the Thread class. This should be very simple (why ?)
Because it already have a run method so we just need to say TagCounter extends Thread
and add an override annotation to the run method

c)
Change the Tester class to not call run(), but start the three threads (what's the BIG difference?)
it is significantlly faster but...
This will most likely mean that all your system.out’s will be empty or null (why?)
Because it doesnt make a connection with jsoup
Fix the problem above

d)
Let's see whether we gained anything by executing the three calculations in parallel,
or if we could have achieved the same result via sequential execution.

First lets see how many Kernels your system offers. Add this line to the beginning of your main():
System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());

Use the following skeleton to measure execution time for sequential execution 
(observe that we are calling the run() method, not start() to get sequential execution 
(one more time, make sure you understand the BIG difference).:

long start = System.nanoTime();
t1.run();
t2.run();
t3.run(); 
…
long end = System.nanoTime();
System.out.println("Time Sequential: "+(end-start));

Now use the same principle to measure execution time for parallel execution (don't get the end time before all threads has stopped)

Explain the results
  Connect to the URL and count the number of h1, h2, div and body Tags
 */
