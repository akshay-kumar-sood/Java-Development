// DEADLOCK : thwo threads wait for each other to release resouse so other use that. 
// A has pen wait for paper from B . B has paper waits for pen from A.
// Creating a deadlock.

class Pen{
    public synchronized void usePen(Paper paper){
        System.out.println(Thread.currentThread().getName()+" using pen ");
        try{Thread.sleep(3000);}catch(Exception e){}
        System.out.println(Thread.currentThread().getName() +" waiting for paper");
        paper.finishwrite();
    }
    public synchronized void finishwrite(){
        System.out.println(Thread.currentThread().getName()+" finished with pen ");
    }
}

class Paper{
    public synchronized void usePaper(Pen pen){
        System.out.println(Thread.currentThread().getName() +" using paper ");
        try{Thread.sleep(3000);}catch(Exception e){}
        System.out.println(Thread.currentThread().getName() +" waiting for pen");
        pen.finishwrite();
    }
    public synchronized void finishwrite(){
        System.out.println(Thread.currentThread().getName()+" finished with pen ");
    }
}
public class java10 {
    public static void main(String[] args){
        Pen pen=new Pen();
        Paper paper=new Paper();
          Runnable task = () -> {
            synchronized(pen) {
                System.out.println(Thread.currentThread().getName()+" locked Pen");

                synchronized(paper) {
                    System.out.println(Thread.currentThread().getName()+" locked Paper");
                }
            }
        };
    //    Thread t1= new Thread(() -> pen.usePen(paper),"Thread 1");
    //     Thread t2=new Thread(() -> paper.usePaper(pen),"Thread 2");
       Thread t1= new Thread(task,"Thread 1");
        Thread t2=new Thread(task,"Thread 2");
        t1.start();
        t2.start();
    } 
}
