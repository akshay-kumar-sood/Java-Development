// Create thread using extend thread class.


class CustomThread  extends Thread{
@Override
public void run(){
    System.out.println("hello world");
}
}

public class java1 {
    public static void main(String[] args){
        CustomThread t1=new CustomThread();
        t1.start();
    }
}
