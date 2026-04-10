JAVA MULTITHREADING



\--------------------4:43 PM 4/2/2026---------------------------

* **Program vs Process**

Program is a passive entity. Code or instructions.

Process is a active entity. Program in current execution is called process.



* **Multithreading**

It is the ability to execute multiple threads within a single process concurrently. Done by java.lang.package in java.



Thread vs Process

|Thread|Process|
|-|-|
|lightweight sub-process and the smallest unit of execution within a program that runs independently but shares the same memory space as the process.|Process is a active entity. Program in current execution is called process.|
|light weight , fast|Heavy weight , slow execution|
|shared memory|no shared memory|
|context switching is slow.|context switching is fast.|



* **Thread Creation - LECTURE 2**

&#x20;Two ways :

1. Extend the Thread class
2. Implement runnable interface



using first . make class extends Threads and override run method. In main class create object of that class and make **start** function not run .



using second . make class implements runnable class. create object of it. make object of thread class and pass object and run start method. If a class already extends (inherits) some class so we cannot inherit another class so we use implements method.



* Java Thread Life Cycle



New Runnable Running Blocked/Waiting Terminated



New : when we make object.

Runnable : when start method called.
Running : nothing like that because java confuses between running and ready to run.

Blocked/Waiting : when run method finished.



|WAIT|SLEEP|
|-|-|
|Release lock . T1 comes and stops but it opens the lock so next time Thread t2 go smoothly.|No lock release. Every thread has to wait.|



* **join ()     Syntax   t1.join()**



makes current thread (MAIN) to wait until the target thread done execution.



* **Thread Methods**
1. **Daemon Thread       \[ java 4 ]**

&#x20;  It means it is not important. Means if main thread stops, no matter daemon thread has to do some work. Stop the process.



Syntax : t1.setDaemon(true);



2\.  yield - give change to other thread to run..



**3. synchronized keyword  \[java 5]**
to keep check only one thread execute this at a time.



* **JAVA LOCKS**
* **Intrinsic -** they are build in locks in every object in java. you don't see but they are there. Used in synchronized keyword also.
* **Explicit -** advanced lock we have control to lock and unlock. Available in java.util.*concurrent*.lock.



* **JAVA LOCKS**

&#x20;  Using synchronization keyword it makes only one thread to execute at a time. It may cause long waiting time for another thread. So delay overall process.

Solution is Locks:

Lock lock =new ReentrantLock();

1. tryLock

&#x09;If lock lock, lock it . else it is not free. go away. Immediately TRUE or FALSE.

2\. **lock.lock (3000)**
lock achieved then true except false.



3. **lock.tryLock(3000,TimeUnit.MILLISECONDS)**
check 3 sec if lock is achievable then good else go away.

4\. lock.lockInterruptibly()
to interrupt the lock if it do not work.



* Lock Fairness

who ask locks first gets lock first. It do not depend on declaration of thread start. It solves starvation. Starvation means a thread keeps waiting for a resource (like a lock) and never gets a chance to execute, even though the program is running.
SYNTAX : ReentrantLock lock =new RentrantLock(true);



* READ WRITE LOCK

Means aloow multiple thread to read unless any thread is writing. Read simultaneously and write exclusively.



1. ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
2. lock.readLock().lock()
3. lock.readLock().lock()
4. read.writeLock().lock()
5. read.writeLock().unlock()
* DEADLOCK

2 thread . one has pen demads paper . second has paper demads pen. Deadlock occur.
use synchronization . if you have paper then only demad for pen.
synchronization is used during implementing runnable. Inside run method functionality.
Deadlock can be prevented by using synchronization and ensuring all threads acquire resources in a fixed and consistent order.
pen -> paper.



* Thread Communication
1. notify()
2. notifyAll()
3. wait()



Example producer consumer problem. If there is nothing to consume what will consumer consume. So consumer checks it data is available it consumes, notify consumer also to produce more data and if not available it waits.

as it is synchronized method , only single thread go inside. So both thread communicated with each other. to avoid race condition.
**NotifyAll()** is preferred when we do not know which thread to wake . As we cannot set this thread to wake. so in safe hand we wake all thread.



* Lambda Expression

only for those interface which has only one abstract method.

Rules : ()-> {}   (a,b)->{return a+b;}    Runable runable=()-> 	{sout("hello"}   (parameters)-> {body}



* Thread Pool

Collection of pre initialized thread to perform task.

Creating and deletion task is complex or time taking. So recourse save.

Fast response time we donot have to create thread from starch.

Control over thread count. Set max limit.



* Executor Framework Java 8

means to easy the development of concurrent applications by abstracting away many of the complexity involved in creating and managing thread. Mtlb kuch complex task ko abstract kar lenge instead of doing from scratch.

1. Executor

it is a simple interface . it ask for command and say i will run. But no thread management and no control. It has a runnable inside it.
Syntax Executor execute=Executor.newSingleThreadExecutor()

executor.execute(()->{sout("hello")})



2\. Executor Service

It implements the executor and add on more methods.

Advanced version of Executor. Provide control , management, thread pool , shutdown, return value feature.

&#x20;

ExecutorService executor=Executors.newFixedThreadPool(2)
make 2 thread and they are used again and again.

executor.submit(()->{sout ("task running")})



* ExecutorService executorService=Executors.newSingleThreadExecutors();

Future<?> future=executorservice.submit(()->sout("hello"));



|Callable|Runnable|
|-|-|
|Return value|no return|
|Used with executorService|Used with thread and executor|
|Throw exception,|no exception throw|





* RUNNABLE | CALLABLE | RUNNABLE WITH RETURN



ExecutorService executor=Exectors.newFixedThreadPool(1);

1. RUNNABLE

Runnable task=()->{

sout();

}



Future<?> f=executor.submit(task);

2\. CALLABLE

Callback task=()->{

return "hello";

}



Future<?> f=executor.submit(task);



3\. RUNNABLE WITH RETURN

Runnable task=()->{

sout("elllo");

}



Future<?> f=executor.submit(task,40);



* Executor service submit

it has 3 types

1. Callable
2. runnable
3. runnable + return



* InvokeALL()

it accept list of callback task and execute then order do not matter . But result is in order.

* invokeAll()
inkoveAll(list,2,TimeUnit.MILISECONDS) means task that run under 3 millisecond run other donot run.



* Future

used to get the value returned by a task (Callable) after it finishes.

Make thread usin executorservice and submit using future.

f.get()

f.isDone()

f.isCancelled()

f.time()

f.cancel()

f.cancel(true)  means if it is running interrupt it.
f.cancel(false) if running do nothing. if stop then interrupt it.



* ScheduleExecutorService

3 function

1. scheduler.schedule(task,time,timeunit.seconds) means after that time do the task.
2. scheduler.scheduleAtFixedRate(task,initial\_time,period,timeunit.Seconds)
3. scheduler.scheduleWithFixedDelay()



extends the schedulerservice

1. scheduler.scheduleAtFixedRate(task,initial\_delay,period,timeunit.seconds);

means it doesnot care if task takes more than period time. It start new process. ex : if period is 5 . so if any task take more than 5 seconds to execute it doesnot care it runs a new task.
s

scheduler.scheduleWithFixedDelay() : it waits  for the task completion and then wait for period and then run new task.





means it do task after 5 second delay. to stop it we have to make a scheduler to shutdown.



* ExectorService executor=Exector.newCachedThreadPool();

it reuses existing free thread. if not present so it creates a new thread. No limit. But if a thread is inactive for 60 second it terminates that thread.



* **CountDownLatch**

when we want that main thread waits and first custom thread finish.

1. WAY 1 : Future.get()  : it waits and get result

2\. Way 2: CountDownLatch(number)
it stores number like 3 . so it has 3 countdown means 3 tasks.
Syntax:



CountDownLatch latch=new COuntDownLatch(3);

callable task (inside task use latch.countdown());

make threads using executorservice

executorservice.sumit()

executorservice.submit();

executorservice.submit();

try{latch.await();}

1. latch.countdown() : decrease countdown as task done  2. latch.await() : finish all task. 3. latch.await(3000,TimeUnit.MILISECONDS) : it is used to hold the main thread for 3 seconds. Although all tasks run if they are taking more than 3 sec. This time is for main thread. Means we can stop main thread for 3 second.



If we want to give custom thread 3 seconds. means i hold main thread for 3 seconds and then no pending task run.
for first 3 secom -> custom thread run.
after 3 seconds : main thread

then no custom thread pending work. SO **we use shutdownNow().**



* **CyclicBarrier**
1. reuseable
2. reset at failed thread
3. barrir.reset()

4\. barrier.await()

CountdownLatch has drawback it cannot be reused. So Cyclicbarrier come.
Syntax : CyclicBarrir barrir=new CyclicBarrir(number:3);

means if three thread call so barrier goes from 0 -> 1 -> 2-> 3 and again rest to 0 . for reusability.

barrier.reset() it is used to help the failed thread. If anythread fails so it makes infinite waiting because cyclicbarrir waits for thread to complete at a point. SO it ise used to reset barrir to zero and but it does not make previous waiting thread to work.



* CompletableFuture
1. daemon thread
2. asynchronous
3. Used to run task in background as it is non blocking code.



Syntax : CompletableFuture<String> future=CompleteablFuture.supplyASync(()->{

sout(""worker thread");

}



1 .supplyASYNC()  : when return something

2\. runAsync() : when do not return 



Methods :

f.get()   : wait for task completion . Use try catch 

f.join()  : wait for ctask completion. no need of try catch

f.getNow("Nothing") : if res ready then return else what u assign that will come for ex "Nothing".

f.allOf()  : waits for all task completion 



.orTimeout(1,timeunit.seconds) : it is used to give time to task it it work on 1 sec good 



.ortimeout(1.timeunit.seconds).exceptionally()  : f under the time period then good else show the exceptional message.



.thenApply() - use to tune the result. if method is return ok . we do .theApply((e)->{return e+e})





|Join|Get|
|-|-|
|wait for thread to complete|wait for Thread to complete|
|try catch not needed.|try catch is must.|





* **Volatile Keyword ( shared variable state problem) (FLAGS)**



Suppose we have 2 thread. Initially flag is false. Thread 1 sleep for 1 sec and then turn the flag to true.

Thread 2 run but the flag is still false even if thread one set the flag true.
This is because Thread stores the variable is cache . To make copy.

Solution use volatile keyword.



* **Atomic keyword**

it is used to solve the problem of Two thread incrementing the shared variable.

Can we solved using synchronized keyword and locks. 

But another way is make variable atomic.



AtomicInteger counter=New AtomicInteger(0);



Methods are:

counter.incrementAndGet()

counter.get()



