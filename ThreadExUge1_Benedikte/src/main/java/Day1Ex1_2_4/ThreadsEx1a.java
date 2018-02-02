/*


 */
package Day1Ex1_2_4;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BeneditkeEva
 */
public class ThreadsEx1a {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            long sum = 0;
            for (int i = 0; i <= 1e6; i++) {
                sum += i;
            }

            System.out.println(sum);
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(2000);
                    System.out.println("t2: " + i);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadsEx1a.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    for (int i = 10; i < 1e9; i++) {

                        Thread.sleep(3000);

                        System.out.println("t3: " + i);
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadsEx1a.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Here we got an interrupted exception for t3 if I use interrupt after 10 seconds");
                }
            }
        });

        t1.start();

        t2.start();

        t3.start();

        t3.join(10000);

        sleep(10000);

        System.exit(0);

    }
}
