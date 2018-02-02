/*

 */
package Day1Ex1_2_4;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ejer
 */
public class ThreadsEx2 {

    public static void createnThreads(int n) throws InterruptedException {

        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            final int j = i;
            threads[j] = new Thread(() -> {
                for (int g = 0; g < n * 100; g++) {
                    try {
                        Thread.sleep(100);
                        System.out.println(threads[j].getName() + ".   " + g);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ThreadsEx2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            threads[i].start();

        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadsEx2.createnThreads(3);

    }
}
