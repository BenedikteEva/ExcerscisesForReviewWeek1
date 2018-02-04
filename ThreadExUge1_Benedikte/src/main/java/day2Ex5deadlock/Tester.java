package day2Ex5deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tester {

    public static void main(String[] args) {

        try {
            ResourceContainer resources = new ResourceContainer();
            ResourceUser1 t1 = new ResourceUser1(resources);
            ResourceUser2 t2 = new ResourceUser2(resources);
            DeadLockDetector dld = new DeadLockDetector();
            dld.start();
            t1.start();
            t1.join(); // to break the deadlock i used join immidiately after t1 was started så t2 kan overtage resources
            t2.start();
            t2.join();// if this join is gone only 300 words are written 

            System.out.println("Done");
            System.out.println("Words produced: " + resources.getResourceWords().size());
            System.out.println("Numbers produced: " + resources.getResourceNumbers().size());
            System.exit(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        };
    }

    public static class DeadLockDetector extends Thread {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        public void run() {
            while (true) {
                long[] threadIds = bean.findDeadlockedThreads();
                if (threadIds != null) {
                    System.out.println("We got ourselves a deadlock");
                    System.exit(0);
                } else {

                }
            }
        }

    }
}
