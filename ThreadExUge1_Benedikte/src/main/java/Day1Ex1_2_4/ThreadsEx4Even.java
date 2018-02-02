/**
 *
 * */
package Day1Ex1_2_4;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ejer
 */
public class ThreadsEx4Even {

    private static int n;

    public synchronized int next() {

        n++;
        n++;
        return n;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadsEx4Even even = new ThreadsEx4Even();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public  void run() {
//                try {

                    while (n % 2 == 0) {
//                        Thread.sleep(10);
                        System.out.println(even.next());
                    }
                    System.exit(n);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Even.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public  void run() {

//                try {

                    while (n % 2 == 0) {
//                        Thread.sleep(20);
                        System.out.println(even.next());

                    }
                    System.exit(n);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Even.class.getName()).log(Level.SEVERE, null, ex);
//
//                }
            }
        });

        t1.start();
        t1.join(10000);
        sleep(10000);
        t2.start();

    }

}
