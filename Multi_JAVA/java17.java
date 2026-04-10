// we will learn volatile.
// SEE THE LATEST UPDATED STATE. NO CACHE OLD DATA.
// Shared variable in two thread problem.
// problem is we run one thread and set flag= false initially. Another thread make the flag true but the first thread still have flag = false.
// Because every thread save copy of variables in cache. 
// SOlution is we make that share variable do not share in cache store it in main memory.

class SharedObj{
    private volatile boolean flag=false;
    public void setflagtrue(){
        System.out.println("writer thread made the flag true");
        flag=true;
    }

    public void printflag(){
        while(!flag){
        }
        System.out.println("flag is true... ");
    }
}
public class java17 {
     public static void main(String[] args){
        SharedObj SharedObj=new SharedObj();
        Thread writerThread=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            SharedObj.setflagtrue();
        });

        Thread readerThread=new Thread(()->{
            SharedObj.printflag();
        });

        writerThread.start();
        readerThread.start();
     }
}
