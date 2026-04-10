// this file tells that if we can 2 threads and increase th same resource here counter . so the answer is unpredictable and it some steps they both increment  the same value.
// if thread 1 has to run 1000 steps and thread 2 also runs 1000 steps it is not guranteed that final result is 20000.
// to fix this we use synchrozed keyword.

class Counter{
    public int cnt=0;
    public  synchronized void inc(){
        cnt++;
    }
    public void getcnt(){
        System.out.println(cnt);
    }
}

class Mythread extends Thread{
    Counter counter=new Counter();
    Mythread(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run(){
        for(int i=0;i<10000;i++){
            counter.inc();
        }
    }
}
public class java5 {
    public static void main(String[] args){
        Counter c=new Counter();
        Mythread t1=new Mythread(c);
        Mythread t2=new Mythread(c);
        t1.start();
        t2.start();
        try{
        t1.join();
        t2.join();}
        catch(Exception e){

        }
        c.getcnt();
    }
}
