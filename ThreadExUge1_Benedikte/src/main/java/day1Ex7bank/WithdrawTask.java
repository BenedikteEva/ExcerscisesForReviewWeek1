package day1Ex7bank;

public class WithdrawTask implements Runnable
{
  BankAccountUnsynchronized acc;
  public WithdrawTask(BankAccountUnsynchronized a)
  {
    acc = a;
  }
  //added override annotation
  @Override
  public void run()
  {
    try
    {
      for (int i = 1 ;i< 10 ;i++ ) 
      {
        acc.withdraw(100);
        Thread.sleep(1);
      }
    }
   catch (InterruptedException e) {}
  }
}
