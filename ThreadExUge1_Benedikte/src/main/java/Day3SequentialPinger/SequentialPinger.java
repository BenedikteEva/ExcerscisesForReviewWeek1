package Day3SequentialPinger;


/*
 * Code taken from 
 * http://crunchify.com/how-to-get-ping-status-of-any-http-end-point-in-java/
 */
import static Day3SequentialPinger.SequentialPinger.getStatus;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SequentialPinger {

    public static String getStatus(String url) throws IOException {

        String result = "Error";
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200) {
                result = "Green";
            }
            if (code == 301) {
                result = "Redirect";
            }
        } catch (Exception e) {
            result = "->Red<-";
        }
        return result;
    }

    public static void main(String args[]) throws Exception {

        ExecutorService es = Executors.newFixedThreadPool(5);

        String[] hostList = {"http://crunchify.com", "http://yahoocom",
            "http://www.ebay.com", "http://google.com",
            "http://www.example.co", "https://paypal.com",
            "http://bing.com/", "http://techcrunch.com/",
            "http://mashable.com/", "http://thenextweb.com/",
            "http://wordpress.com/", "http://cphbusiness.dk/",
            "http://example.com/", "http://sjsu.edu/",
            "http://ebay.co.uk/", "http://google.co.uk/",
            "http://www.wikipedia.org/",
            "http://dr.dk", "http://pol.dk", "https://www.google.dk",
            "http://phoronix.com", "http://www.webupd8.org/",
            "https://studypoint-plaul.rhcloud.com/", "http://stackoverflow.com",
            "http://docs.oracle.com", "https://fronter.com",
            "http://imgur.com/", "http://www.imagemagick.org"
        };
long start = System.nanoTime();
//        for (int i = 0; i < hostList.length; i++) {
//
//            String url = hostList[i];
//            String status = getStatus(url);
//
//            System.out.println(url + "\t\tStatus:" + status);
//        }
//      

es.execute(new Runnable() {
            @Override
            public void run() {
             
                for (int i = 0; i < hostList.length; i++) {
                    try {
                        SequentialPinger.getStatus(hostList[i]);
                        String url = hostList[i];
                        String status = getStatus(url);
                        System.out.println(url + "\t\tStatus:" + status);
                    } catch (IOException ex) {
                        Logger.getLogger(SequentialPinger.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });        es.shutdown();
long end = System.nanoTime();System.out.println("Time Parallel: "+(end-start));

    }
}
