//  Synchronized has a problem within it. It executed one thread thread at a time. So sometime one thread make waits for so long , this make another thread to wait undefinite sometime.
// used locks. lock.
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount{
    private int balance=100;
    public synchronized void withdraw(int amt){
        System.out.println(Thread.currentThread().getName() +" attemptning to withdraw "+ amt);
        if(amt<=balance){
            System.out.println(Thread.currentThread().getName() + " procedding to withdraw ");
            try{
                Thread.sleep(6000);
            }catch(Exception e){

            }
            balance-=amt;
            System.out.println(Thread.currentThread().getName() +" remaining balance "+ balance);
        }
        else{
            System.out.println(Thread.currentThread().getName() +" insufficient balance ");

        }
    }
}

class Transaction{
    private int balance=100;
    private final Lock lock=new ReentrantLock();
    public void withdraw(int amt){
        System.out.println(Thread.currentThread().getName() +" attemptning to withdraw "+ amt);
        try{
            if(lock.tryLock(3000, TimeUnit.MILLISECONDS)){
                 if(amt<=balance){
            System.out.println(Thread.currentThread().getName() + " procedding to withdraw ");
           
            balance-=amt;
            System.out.println(Thread.currentThread().getName() +" remaining balance "+ balance);
        }
        else{
            System.out.println(Thread.currentThread().getName() +" insufficient balance ");

        }
            }
            else{
                System.out.println(Thread.currentThread().getName() +" could not accuire the lock. ");
            }
        }
        catch(Exception e){

        }
        finally{
            //lock.unlock();
        }
    }
}

public class java6 {
    public static void main(String[] args){
        BankAccount sbi=new BankAccount();
        Transaction pnb=new Transaction();
        Runnable task=new Runnable(){
            @Override
            public void run(){
                pnb.withdraw(50);
            }
        };
        Thread t1=new Thread(task,"Thread 1");
        Thread t2=new Thread(task,"Thread 2");
       // t1.start();
       // t2.start();

        Thread t3=new Thread(task,"Thread 3");
        Thread t4=new Thread(task,"Thread 4");
        t3.start();
        t4.start();


    }
}
