import java.util.concurrent.locks.ReentrantLock;

class FairLock{
    private final ReentrantLock lock=new ReentrantLock();
    public void access(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() +" aquired lock ");
            Thread.sleep(3000);

        }catch(Exception e){

        }finally{
            System.out.println(Thread.currentThread().getName() +" is unlocked . ");
            lock.unlock();
        }
    }
}

public class java8 {
    public static void main(String[] args){
        FairLock lock=new FairLock();
        Runnable step=new Runnable() {
            @Override
            public void run(){
                lock.access();
            }
        };
        Thread t1=new Thread(step,"Thread 1");
        Thread t2=new Thread(step,"Thread 2");
        Thread t3=new Thread(step,"Thread 3");
        Thread t4=new Thread(step,"Thread 4");
        Thread t5=new Thread(step,"Thread 5");
        Thread t6=new Thread(step,"Thread 6");
        Thread t7=new Thread(step,"Thread 7");
        Thread t8=new Thread(step,"Thread 8");
        Thread t9=new Thread(step,"Thread 9");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
    }
}
