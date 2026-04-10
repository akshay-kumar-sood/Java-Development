// Setting priority to thread . 3 priority min, max , norm . But still final decision in on jvm . Cannot guranted that macx priority runs first. Also learned how to set name.
// Daemon Thread 

class CThread extends Thread{
    public CThread(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Name : "+ Thread.currentThread().getName() +" Priority : " + Thread.currentThread().getPriority());
        }
    }
}

class Daemon extends Thread{
    public void run(){
        while(true){
            System.out.println("continue ...");
        }
    }
}

class Yeild extends Thread{
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println("Only i run");
            Thread.yield();
        }
    }
}
public class java4{
    public static void main(String[] args){
        CThread l=new CThread("Low");
        l.setPriority(Thread.MIN_PRIORITY);
        CThread m=new CThread("Medium");
         l.setPriority(Thread.NORM_PRIORITY);
        CThread h=new CThread("High");
         l.setPriority(Thread.MAX_PRIORITY);

        // l.start();
        // m.start();
        // h.start();


        // Daemon d=new Daemon();
        // d.setDaemon(true);
        // d.start();
        // System.out.println("Program Ends");

        Yeild y=new Yeild();
        y.start();
        l.start();
    }
}