// Drawback of Volatile. It cannot solve problem of of shared variable. Like two thread incremnet values of counter.
// But the result is unpridictable.
// Solution we use Synchronization keyword, locks.
// Best is make that variable atomicInteger 
// it has methods like incrementAndGet() , .get()

import java.util.concurrent.atomic.AtomicInteger;

class VolatileCounter{

    private AtomicInteger  counter=new AtomicInteger(0);

    public void increment(){
        counter.incrementAndGet();
    }
    public int getcounter(){
        return counter.get();
    }
}
public class java18 {
    public static void main(String[] args){
        VolatileCounter vc=new VolatileCounter();
        Thread t1=new Thread(()->{
            for(int i=0;i<1000;i++){
                vc.increment();
            }
        });

        Thread t2=new Thread(()->{
            for(int i=0;i<1000;i++){
                vc.increment();
            }
        });

        t1.start();
        t2.start();
        try{
        t1.join();
        t2.join();}catch(Exception e){}

        System.out.println(vc.getcounter());

    }
}
