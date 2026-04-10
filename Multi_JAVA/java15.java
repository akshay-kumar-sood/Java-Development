// in prevoius we studied countdownlatch. But it has drawback it cannot be reused.Now we study 
// cycclick barrir meets at thread at same point. all thread wait to meet at same thread.
// if we set cyclicbarrier to 3. and we make 3 thread and each thread calls await. so it goes from 0 -> 1 ->2 -> 3 then again reset to 0 . For next thread use.
// barrier.reset() is used to not to reset to ZERO. But to help if any thread fails or stuck. Suppos barrier 3 thread 3.
// Thread 1 -> done -> barrier.await() -> waitig 
// Thread 2 -> done -> barrier.await() -> waiting for other
// Thread 3 -> fails -> never calls barrier.await() -> so reset is used here to reset barrir and the previous thread do not run.


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.security.auth.callback.Callback;

public class java15 {
    public static void main(String[] args) throws InterruptedException,BrokenBarrierException{
        ExecutorService executer=Executors.newFixedThreadPool(3);
        CyclicBarrier barrier=new CyclicBarrier(4);
        Callable<String> task=()->{
            Thread.sleep(3);
            System.out.println(Thread.currentThread().getName()+" reached barrier ");
            barrier.await();
            return "ha";
        };
        executer.submit(task);
        executer.submit(task);
        executer.submit(task);
        barrier.await();
        System.out.println("Main thread is running");
        executer.shutdown();
    }
}
