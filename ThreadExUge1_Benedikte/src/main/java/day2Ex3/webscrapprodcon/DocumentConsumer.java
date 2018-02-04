package day2Ex3.webscrapprodcon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.jsoup.nodes.Document;

public class DocumentConsumer implements Runnable {

    BlockingQueue<Document> producedDocuments;
    Document doc;

    public DocumentConsumer(BlockingQueue producedDocuments) {
        this.producedDocuments = producedDocuments;
    }

    @Override
    public void run() {
        boolean moreDocumentsToConsume = true;
        int totalDivs = 0;
        while (moreDocumentsToConsume) {
            doc = producedDocuments.peek();
            //TODO: Change this to fetch a new document from the producedDocuments queue or wait if no one is ready
//Hint: So far you have no way of knowing when all producers are done. For this part you can use a method that
//WAIT, but only for max 10 seconds and if it times out take that as that all Producers are done
            if (doc != null) {

      
                
                System.out.println("Title: " + doc.title());
                System.out.println("Number of divs:  " + doc.select("div").size());
                totalDivs += doc.select("div").size();
                producedDocuments.poll();
                
//
//TODO Update the totalDivs variable and print title and sum for this document

            } else {

                moreDocumentsToConsume = false;
                System.out.println("Sum of all Divs:  " + totalDivs);
            }

        }

    }

}
