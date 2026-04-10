// mulitple thread can read at same time. but cannot write at same time. 

import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedResource {
    private int data = 0;

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // Read method
    public void read() {
        lock.readLock().lock();   
        try {
            System.out.println(Thread.currentThread().getName() +
                    " reading data: " + data);
            Thread.sleep(2000);
        } catch (Exception e) {
        } finally {
            lock.readLock().unlock(); 
        }
    }

    // Write method
    public void write(int value) {
        lock.writeLock().lock();  
        try {
            System.out.println(Thread.currentThread().getName() +
                    " writing data: " + value);
            data = value;
            Thread.sleep(2000);
        } catch (Exception e) {
        } finally {
            lock.writeLock().unlock(); 
        }
    }
}

public class java9 {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        
        Runnable reader = () -> {
            resource.read();
        };

    
        Runnable writer = () -> {
            resource.write(10);
        };

        Thread r1 = new Thread(reader, "Reader 1");
        Thread r2 = new Thread(reader, "Reader 2");
        Thread r3 = new Thread(reader, "Reader 3");

        Thread w1 = new Thread(writer, "Writer 1");
        Thread w2 = new Thread(writer, "Writer 2");

        r1.start();
        r2.start();
        w1.start();
        r3.start();
        w2.start();
    }
}