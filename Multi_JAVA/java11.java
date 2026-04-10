// i would learn thread communication. Using Producer Consumer problem. 
// producer check is there no production so it produce . If there is production already so it wauts.
// consumer checks if there is no data to consume it waits. if there is data then it consume it.


class Shared{
    private int val=0;
    boolean flag=false;
    public synchronized void producer(int value){
        while(flag){
            try{
                System.out.println("Producer is waiting");
            wait(3000);
            }catch(Exception e){
        
            }
        }
            val=value;
            flag=true;
            System.out.println("Producing data "+ val);
            notify();
        
    }

    public synchronized void consumer(){
        while(!flag){
            System.out.println("consumer is waiting");
            try{
                wait(3000);
            }catch(Exception e){}
        }
        System.out.println("Consuming data"+ val);
        flag=false;
        notify();
    }
}
public class java11{
    public static void main(String[] args){
        Shared s=new Shared();
        Thread t1=new Thread(()->{
            for(int i=0;i<10;i++){
                s.producer(i);
            }
        });
        Thread t2=new Thread(()->{
            for(int i=0;i<10;i++){
                s.consumer();
            }
        });

        t1.start();
        t2.start();
    }
}