package day1Ex7bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankAppExecutor
{
  private static int NUMBER_OF_THREADS = 3;
  
  private static void executeTransactions()
  {
    BankAccountUnsynchronized acc = new BankAccountUnsynchronized();
    ExecutorService executor = Executors.newCachedThreadPool();
    for (int i=0; i<NUMBER_OF_THREADS;i++ ) 
    {
      executor.execute(new DepositTask(acc));
      executor.execute(new WithdrawTask(acc));
    }
    executor.shutdown();
    try {
      executor.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException ex) {
      Logger.getLogger(BankAppExecutor.class.getName()).log(Level.SEVERE, null, ex);
    } 
    String result = acc.getBalance() == 0 ? "OK, " : "FAILED, ";
    System.out.print(result);
    System.out.println("Account value after all transactions: "+acc.getBalance());   
  }
  
  public static void main(String[] args)
  {
    for(int i = 0; i < 10; i++){
      executeTransactions();
    }
  }
  
}
/*
Exercise 7 (race condition) 
Execute the main code in either  day1.bank.BankApp.java or day1.bank.BankAppExecutor.java

The program includes a method executeTransactions () which executes a series of transactions on a shared account object and prints true / false depending on the expected outcome.

Identify places in the code where it "goes wrong".

What should the closing balance be?

Experiment: Increase the number of calls of executeTransactions () or the number of threads
and observe the effect.

Observe that there are two versions of the main() method, one that creates threads in a traditional way, and one using an ExecutorService (the recommended way).

Solve the problem in the Bank program:
Using the traditional synchronization
Using a java.util.concurrent.locks.ReentrantLock

Test

*/
