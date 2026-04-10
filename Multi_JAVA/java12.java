// LAMBDA FUNCTION.
// these are two ways to implement runnable . T1 is lambda functiona nd t2 uses anonymous function.
public class java12 {
    public static void main(String[] args){
        Thread t1=new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });

        Runnable runnable=()->{
            System.out.println("hiii");
        };
        
        Runnable t2=new Runnable() {
            @Override
            public void run(){
                System.out.println("hello world");
            }
        };
        t1.start();
        Thread t2thread=new Thread(t2);
        t2thread.start();

        Thread t = new Thread(runnable);
        t.start();
       
    }
}
