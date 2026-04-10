import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantExp{
    private final ReentrantLock lock=new ReentrantLock();
    public void outerMethod(){
        lock.lock();
        try{
            System.out.println(" Outher Method ");
            innerMethod();
        }
        finally{
            lock.unlock();
        }
    }

    public void innerMethod(){
         lock.lock();
        try{
            System.out.println(" Inner Method ");
            outerMethod();
        }
        finally{
            lock.unlock();
        }
    }
}

public class java7{
    public static void main(String[] args){
        ReentrantExp l1=new ReentrantExp();
        Runnable task =new Runnable() {
            @Override
            public void run(){
                l1.outerMethod();
            }
        };
        Thread t1=new Thread(task);
        t1.start();
    }
}