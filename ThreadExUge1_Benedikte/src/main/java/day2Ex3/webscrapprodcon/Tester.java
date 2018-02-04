
package day2Ex3.webscrapprodcon;


import static java.lang.Thread.sleep;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.jsoup.nodes.Document;

public class Tester {
  
  public static void main(String[] args) throws InterruptedException {

    //The list of URL's that must be processed. This is Q1 in the exercise figure
    ArrayBlockingQueue<String> urls = new ArrayBlockingQueue(40);
    
     urls.add("http://www.fck.dk");
    urls.add("http://www.google.com");
    urls.add("http://politiken.dk");
    urls.add("https://cphbusiness.mrooms.net/");
    urls.add("https://www.reverbnation.com/control_room/artist/1083693/dashboard");
    urls.add("https://github.com/");
 
     urls.add("https://www.dr.dk/");
       urls.add("http://tv2.dk/");
        urls.add("https://www.rejseplanen.dk/webapp/index.html");
   
    //TODO: Add some more URL's of your own choice

    //Holds the Documents produced by the producers. This is Q2 in the exercise figure
    ArrayBlockingQueue<Document> producedDocuments = new ArrayBlockingQueue(10);
   
    ExecutorService es = Executors.newFixedThreadPool(4);
    //Create and start the four Producers (P1-P4)
    
//      Thread P1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                DocumentProducer d1 = new  DocumentProducer(urls, producedDocuments);
//               
//                System.out.println("Title: " + d1.doc.title());
//                System.out.println("Div's: " + d1.doc.select("div").size());
//                System.out.println("Body's: " + d1.doc.select("body").size());
//            }
//        }); 
//      P1.start();

    es.execute(new DocumentProducer(urls, producedDocuments)); 
    es.execute(new DocumentProducer(urls, producedDocuments)); 
    es.execute(new DocumentProducer(urls, producedDocuments)); 
    es.execute(new DocumentProducer(urls, producedDocuments)); 

    //Create and start the single Consumer Thead (P1)
  
    es.execute(new DocumentConsumer(producedDocuments)); 
    es.shutdown();
    es.awaitTermination(5,TimeUnit.SECONDS);
  
    System.out.println("Closing Down");
   
  }
}
