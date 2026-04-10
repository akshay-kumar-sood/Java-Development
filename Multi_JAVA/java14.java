// when we want for ex 3 threads run first.Mean main thread wait and other custom thread work first. Then i have to do some task. I use future and f.get();
// mordern solution countdownlatch . latch.await() . latch.await(300,timeunit.second) , latch.countdown() , Thread.shutdownNow(). We learnt all these famous methods.


import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class java14{
    public static void main(String[] args){

        //1. To make main thread pause. And custom thread work first. We use Future and f.get() method. 
        // Callable<String> task=()->{
        //     System.out.println(Thread.currentThread().getName() +" service started ");
        //     Thread.sleep(2000);
        //     return "ok";
        // };
        // ExecutorService executer=Executors.newFixedThreadPool(3);
        // Future<String> future1=executer.submit(task);
        // Future<String> future2=executer.submit(task);
        // Future<String> future3=executer.submit(task);
        // try{
        // future1.get();
        // future2.get();
        // future3.get();}catch(Exception e){}
        // System.out.println("all previous task done ");
        // executer.shutdown();

        //2. WAY 2 : use countdownlatch
        // create countdown. latch.countdown(), latch.await() do task, latch.await(300.timeunit.sec)  means we can hold main thread for 3 second.  
        //If we want to give custom thread 3 seconds. means i hold main thread for 3 seconds and then no pending task run.for first 3 secom -> custom thread run.after 3 seconds : main thread. 


        CountDownLatch latch=new CountDownLatch(3);
        Callable<String> task=()->{
            System.out.println(Thread.currentThread().getName() +" service started ");
            Thread.sleep(2000);
            latch.countDown();
            return "ok";
        };
        ExecutorService executor=Executors.newFixedThreadPool(1);
         Future<String> future1=executor.submit(task);
        Future<String> future2=executor.submit(task);
        Future<String> future3=executor.submit(task);
        try{
        latch.await(3000,TimeUnit.MICROSECONDS);}catch(Exception e){}
        System.out.println("All prev tasks are done");
        executor.shutdownNow();

        
         

    }

    
}