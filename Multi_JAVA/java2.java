// Create thread using the runnable implementation.

class  CustomThread implements Runnable{
    public void run(){
        System.out.println("Thread is rnning");
    }
}
public class java2 {
    public static void main(String[] args){
        CustomThread thread=new CustomThread();
        Thread t=new Thread(thread);
        t.start();
    }
}
