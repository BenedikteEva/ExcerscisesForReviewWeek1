package ExPrepConcurrentStack;

import day2Ex5deadlock.Tester;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import static javafx.scene.input.KeyCode.T;

public class ConcurrentStack<T> extends Thread {

   
    private final ArrayList<T> stack;
    private int size;

    public ConcurrentStack() {
        size = 0;
        stack = new ArrayList<T>(size);
    }

    public void add(T e) {
        synchronized (stack) {
            stack.add(e);
            size++;
        }
    }

    public T remove() {
        synchronized (stack.get(size - 1)) {
            if (size > 0) {
                return stack.remove(--size);
            } else {
                return null;
            }
        }
    }

    public T peek() {
        synchronized (this) {
            int lastIndex = size - 1;
            return stack.get(lastIndex);
        }
    }
 @Override
    public void run() {
          for (int i = 0; i < 10; i++) {
     stack.add((T) T );
        }

    }
    //Example usage of OneValueCache
    public static void main(String[] args) {
        ConcurrentStack<Integer> stack = new ConcurrentStack<>();
//         Tester.DeadLockDetector dld = new Tester.DeadLockDetector();
//            dld.start();
        for (int i = 0; i < 10; i++) {
            stack.add(i);
        }
        for (int i = 0; i < 10; i++) {
            if (stack.peek() != null) {
                System.out.println(stack.remove());
            }

        }
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
