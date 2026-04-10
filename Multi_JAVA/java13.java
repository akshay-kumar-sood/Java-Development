// EXecutor Framework - Executor Executor Service , Schedule Executor Service
// Exector - interface
// executorservice - advanced interface extends executors

// Executor (interface)
//    ↑
// ExecutorService (interface)
//    ↑
// ScheduledExecutorService (interface)

// Executors (class) → creates implementations

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.*;

public class java13 {

    public static void main(String[] args){
        // long starttime=System.currentTimeMillis();
        // ExecutorService executor=Executors.newFixedThreadPool(10);
        //  for(int i=0;i<20;i++){
        //     int finalI=i;
        //     executor.submit(()->{
        //         long result=factorial(finalI);
        //         System.out.println(result);
        //     });
        //  }
        //  executor.shutdown();
        //  try{
        //  executor.awaitTermination(100, TimeUnit.SECONDS);}
        //  catch(Exception e){

        //  }
        //  System.out.println("Time : " + (System.currentTimeMillis() - starttime));

        //  ExecutorService execute = Executors.newSingleThreadExecutor();
        //  execute.shutdown();


    //     ExecutorService executorservice=Executors.newSingleThreadExecutor();
    //     Future<Integer> future=executorservice.submit(()->42);
    //     try{
    //         System.out.println(future.get());
    //     }catch(Exception e){}
    //     if(future.isDone()){
    //         System.out.println("i am done");
    //     }
    //     executorservice.shutdown();
         
    // }

    // private static long factorial(int n) {
    //      long res = 1;
    // for(int i = 1; i <= n; i++){
    //     res *= i;
    // }
    // return res;
    // }

    // this is example of submit with runnable 
    // ExecutorService executorservice=Executors.newSingleThreadExecutor();
    // Future <?> f1=executorservice.submit(()->{System.out.println("hello");});

    // // this is example of submit with callable
    // ExecutorService executorservice1=Executors.newSingleThreadExecutor();
    // Future <Integer> f2=executorservice1.submit(()->10);

    // // this is example of runnable + return 
    // ExecutorService executorservice3=Executors.newSingleThreadExecutor();
    // Future<?> f3=executorservice3.submit(()->{System.out.println("answer is");},30);

    // Now we will learn the inkoveAll

    // ExecutorService executorservice=Executors.newFixedThreadPool(2);

    // Callable<Integer> callable1=()->{
    //     System.out.println("Task 1");
    //     return 1;
    // };
    // Callable<Integer> callable2=()->{
    //     System.out.println("Task 2");
    //     return 2;
    // };
    // Callable<Integer> callable3=()->{
    //     System.out.println("Task 3");
    //     return 3;
    // };

    // List<Callable<Integer>> list=Arrays.asList(callable1,callable2,callable3);
    // try {
    //     List<Future<Integer>> feautures=executorservice.invokeAll(list,1,TimeUnit.MILLISECONDS);
    //     for(Future<Integer> f:feautures){
    //         System.out.println(f.get());
    //     }
    // } catch (Exception e) {
    // }
    
    
    // executorservice.shutdown();
    // System.out.println("hello world");


    // Now i will learn future methods. first make thread.
    // ExecutorService executorservice7=Executors.newFixedThreadPool(1);
    // Future<?> future=executorservice7.submit(()->{
    //     System.out.println("i am running ... ");
    // });
    // future.cancel(false);
    // System.out.println(future.isCancelled());
    // System.out.println(future.isDone());
    // executorservice7.shutdown();
    

    // Now i will learn ScheduleExecutorService.
     ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);
    // scheduler.scheduleAtFixedRate(()->{
    //     try{
    //         Thread.sleep(1000);
    //     }catch(Exception e){}
    //     System.out.println("task execute after every 5 sec delay");
        
    // },0,5,TimeUnit.SECONDS);

    // scheduler.schedule(()->{
    //     System.out.println("initializing shutdown");
    //     scheduler.shutdown();
    // },20,TimeUnit.SECONDS);

    // scheduler.scheduleWithFixedDelay(()->{
    //     System.out.println("task execution after 5 second");
    // },0,5,TimeUnit.SECONDS);

    // scheduler.schedule(()->{
    //         System.out.println("ending..");
    //         scheduler.shutdown();
    // },20,TimeUnit.SECONDS);


    // type of thread creation
    // reuse thread if exists if not then create a thread no limit. but if thread is inactive for 60 seconds it make it rest.
        //ExecutorService executors=Executors.newCachedThreadPool();




    }
}

