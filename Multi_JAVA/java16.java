// COMPLETEABLEFUTURE Java 8.
// 2 methods :
// 1 . supplyAsync()  : when task return something
// 2.  runAsync()     : when task does not return.
// feautures:
// it is a daemon threa. if main finsih first then the compleablefuture thread terminates.
// it is asynchronyn . means non blocking.means main thread may works and compleablefuture donot block. To block use future.get().
// f.join()  f.get() f.alloff() 
// .thenApply()   .ortimeout() .expectionally() these are java 8 feautures.



import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class java16 {
    public static void main(String[] args){
        CompletableFuture<String> completablefuture=CompletableFuture.supplyAsync(()->{
            try{
            Thread.sleep(3000);}catch(Exception e){}
            System.out.println("Worker");
            return "ok";
        });
        //try{
        //Thread.sleep(4000);}catch(Exception e){}

        // future.get() to behave as synchoronous.
        //try{
        //completablefuture.get();}catch(Exception e){}

        // future.getnow()   return result if ready else what you assign.
        // String res=completablefuture.getNow("nooo");
        // System.out.println(res);
        // System.out.println("main thread");


        CompletableFuture<String> future2=CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(2000);
                System.out.println("Inside completable future 2");
            }catch(Exception e){}
            return "ok";
        }).orTimeout(1, TimeUnit.SECONDS).exceptionally(s->
            "Timeout occured"
        );

        System.out.println(future2.join());

        // .thenApply()
        // we can use after completablefuture so tune the return.


        // It waits until all future are finished. it donot return future's result. also order is not guranteed.
        CompletableFuture<Void> f=CompletableFuture.allOf(completablefuture,future2);
        
        // give result after complete , synchronous. no need of exception handling.
        //f.join();
        
        // give result after complete. synchronous. need of try catch
        // try{
        //     //future2.get();
        // }catch(Exception e){

        // }

        CompletableFuture<Void> future3=CompletableFuture.runAsync(()->{
            System.out.println(" thhis is non returnable");
        });
        future3.join();
    }
}
