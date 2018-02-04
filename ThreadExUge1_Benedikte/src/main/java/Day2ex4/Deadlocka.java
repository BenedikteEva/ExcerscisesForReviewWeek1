/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2ex4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/**
 *
 * @author Ejer
 */
public class Deadlocka {

    int[] b = {1, 5};
    int[] c = {2, 3};

    Thread t1;

    Thread t2 = new Thread() {
        public void run() {
            while (true) {
                synchronized (c) {
                    synchronized (b) {
                        System.out.println(Arrays.toString(b) + "" + "" + Arrays.toString(c));
                    }
                }
            }
        }
    };

  

    public Deadlocka() {
        this.t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (b) {
                        synchronized (c) {
                            System.out.println(Arrays.toString(b) + "" + "" + Arrays.toString(c));
                        }
                    }
                }
            }
        };

    }

    public static class DeadLockDetector extends Thread {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        @Override
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

  public static void main(String a[]) {
        Deadlocka mdl = new Deadlocka();
         Deadlocka.DeadLockDetector dld = new Deadlocka.DeadLockDetector();
            dld.start();
        mdl.t1.start();
        mdl.t2.start();
    }}