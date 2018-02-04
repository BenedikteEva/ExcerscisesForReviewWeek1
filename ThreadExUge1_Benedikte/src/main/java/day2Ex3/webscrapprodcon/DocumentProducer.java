package day2Ex3.webscrapprodcon;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//This is the class template for the four Producer Threads P1-P4 in the exercise figure
public class DocumentProducer implements Runnable {

    BlockingQueue<String> urlsToUse;
    BlockingQueue<Document> producedDocuments;
    Document doc;

    public DocumentProducer(BlockingQueue<String> urlsToUse, BlockingQueue <Document>producedDocuments) {
        this.urlsToUse = urlsToUse;
        this.producedDocuments = producedDocuments;
    }

    @Override
    public void run() {
        boolean moreUrlsToFecth = true;
        while (moreUrlsToFecth) {
            try {
                String url = urlsToUse.peek();
//TODO: Use the right method on urlsToUse to set this value to either a string (with a url) or null  

                if (url == null) {
                    moreUrlsToFecth = false;
                } else {

                    doc = Jsoup.connect(url).get();
                    producedDocuments.offer(doc);
                    urlsToUse.poll();
                    //TODO Use the right method on producedDocuments to add this doc to the queue

                }
            } catch (IOException ex) {
                Logger.getLogger(DocumentProducer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
