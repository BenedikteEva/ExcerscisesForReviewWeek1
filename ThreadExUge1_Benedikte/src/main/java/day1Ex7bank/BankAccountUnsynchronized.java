package day1Ex7bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// NOT THREADSAFE
public class BankAccountUnsynchronized {

  private double balance;
  private final Lock lock = new ReentrantLock();
  //the lock is not used

  public BankAccountUnsynchronized() {
    balance = 0;
  }

  public void deposit(double amount) {
      lock.lock();
//    double newBalance = balance + amount;
//    balance = newBalance;  
    balance += amount;
    lock.unlock();
   }

  public void withdraw(double amount) {
       lock.lock();
//    double newBalance = balance - amount;
//    balance = newBalance;
     balance -= amount;
      lock.unlock();
   }

  public double getBalance() {
    return balance;
  }
}