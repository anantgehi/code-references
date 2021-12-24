Refer to Thread state transitions figure

A -- transition from rdy to run -----> Running
Triggered by --- in time slice based scheduling --- time slot of earlier thrd over OR in pre-emptive multitasking -- higher prio thrd pre-empts lower prio thrd.
B --- transition from running ---> ready to run 
Reverse of earlier transition OR 
public static void yield()----
 Requests underlying scheduler to swap out current thrd SO THAT some other lower prio thrd MAY get a chance to run. (to avoid thrd starvation -- i.e co-operative multi-tasking.)

C --running state --- Only in this state --- run() method gets executed.
running --->dead --- Triggers -- run() method returns in healthy manner . OR run() aborts due to un-handled , un-checked excs.

D -- blocked ---> rdy to run --- when any of blocking condition is removed --- blocked thrd enters rdy pool & resumes competition among other thrds.


API Involved 
1. Thread class constructor to be used in extends Thread scenario
1.1 Thread() --- A new thrd is created BUT with JVM supplied name.
1.2 Thread(String nm) -- creates named thread.

2.  Thread class constructor to be used in implments scenario
2.1 Thread (Runnable target/inst) --- Creates a new thrd --- by passing instance of the class which implements Runnable i/f.
Run time significance -- Whenever this thrd gets a chance to run --- underlying task scheduler -- will invoke(via JVM) this class's run() method. 
2.2 Thread (Runnable inst,String name)

public class Myclass extends Thread --- start()

Vs

public class Myclass implements Runnable --- This class simply represents a runnable task. Prog MUST create a thrd class inst BY attaching Runnable task to it.


Thread class API
1.public String getName()
2. public void setName(String nm)
3. public static Thread currentThread() -- rets ref of the invoker thrd.
4. public int getPriority() -- rets current prio.
Prio scale -- 1---10(MIN_PRIORITY,MAX_PRIORITY)
NORM_PRIORITY ---- 5
4.5 public void setPriority(int prio) --- must be invoked before start()

DO NOT rely on priority factor -- since it is ultimately specific to underlying OS prio range.-- may cause loss of portability.
t1 --- max-prio ---run() --- begin up-counter -- obs val after 10 secs
t1 --- min-prio ---run() --- begin up-counter -- obs val after 10 secs
t1 --- max-prio & t2 -- min prio 
5. public String toString() --- to ret -- name,prio & thrd grp name
6. public static void sleep(long ms) throws InterruptedException


Objective -1. to test concurrency of thrd : in extends thrd scenario.
Create a Thrd class, add simple loop with dly in run method to display the exec. sequence.
Write main method : which will instantiate thrds(multi-thrded system) & test the concurrent exec. of main thrd along with other thrds.




To ensure that main thrd terminates last : no orphan thrds in the system.


Thread class Method : 
1. public void join() throws InterruptedExc.
The invoker thrd gets blocked until the specified thrd joins it(i.e specified thrd becomes dead)
eg : 2 thrds t1 & t2 are running concurrently.
If u invoke : in run() method of t1 :
t2.join() ----> t1 gets blocked until t2 is over.
t3 -- t1.interrupt()
t1 : Blocked on join
Unblcking triggers -- t2 over,getting interrupt signal.


2. public void join(long ms) throws InterruptedExc
waits  max for specified tmout .
Unblocking triggers -- t2 over,getting interrupt signal, tmout exceeded.

Objective -- Ensure no orphans , w/o touching child thread class.

Objective 
Replace for loop from thrds,  by indefinite loop (while true) & still ensure -- no orphans.
Start --- main + 3 child thrds. --- main(parent thrd waits patiently for 5 secs. & then somehow forces termination of child thrds & then terminates last.

API ---
public void interrupt()  -- sends interrupt signal to the specified thread. If specified thrd has invoked any method (sleep,join,wait)-- having throws clause of InterruptedExc --- then only thrd gets UNBLOCKED due to InterruptedExc.

NOTE -- Thread which is blocked on I/O -- CANT be un-blocked by interrupt signal.

Threads blocked by invoking any method -- having InterruptedException   (sleep,join,wait)   can be unblocked by interrupt signal.


2. Objective - to test concurrency of thrds : in implements Runnable scenario.

2.5 implements scenarion 

3. 


Objective : create 3 thrds with 3 random sleep durations(range is 500ms-5sec)
& start them conc. & ensure that main terminates last.
For random nos--- java.util.Random() , nextInt,nextInt(int upperLim)



Objective : create 3 thrds & start them conc. & ensure that main terminates last.
2nd thrd should accept data from console, dont supply data & observe .
How to unblock a thread , which is blocked on I/O?

Objective : Apply multi threading to Swing application.
Create Swing application -- with start & stop buttons, in south region.
Create JPanel in center region , with some default color.
When start button is clicked, center panel should start changing color(random color)  periodically.
When stop button is clicked, stop changing color.

----------------------------------------

Objective -- To store emp details , dept wise in SAME data file.(text buffered manner--- PrintWriter )



Design :
0. Emp class --- id,deptid,name,sal

1. Write Utils class 
d.m --- pw
constr --pw inst ---
 void writeData(Emp e) {...}

void cleanUp() {...}

constr ---create PW inst --
PW pw=new PW(new FW("emps.data"),true);
---add writeData(....)  : instance method to write Emp dtls (first name, last name ,deptId of the emp)
to the file with small dly in between.(why dly ? ---  for simulating practical scenario & also to add randomness to  code)
 do u need clean up method- -- yes -- close pw.


2. Write Dept Handler runnable task  class --- implements 
Override run() method which will invoke writeData method till 'exit' condition is encountered.
Add stop/exit method to enable 'exit' flag.
....
{
Emp e;
Utils u;
constr(u,e)
{this.e=e;
//u=new Utils();   ------ 

public void run()
{
    while(!exit)
       u.writeData(e);
}
3. Write Tester class : accept some  emp dtls . Create depthandler task  per dept ,attach thrds & start them.
Wait for key stroke ---
System.in.read();
stop all child thrds
ensure no orphans
clean up -- pw

Wait for the key stroke : upon key stroke --- stop all child thrds & then finally terminate main.


Observed o/p ------garbled display or garbled data written in file.

Reason : multiple thrds trying to access the shared resource concurrently.
eg of shared resource : Console or file device,socket,DB table


Solution : Any time when asynch thrds need to access the SHARED resource : LOCK the shared resource --- so that after locking -- only single thread will be able to access the resource concurrently

When is synchronization(=applying thread safety=locking shared resource) required?
In multi-threaded java applns -- iff multiple thrds trying to access SAME copy of the shared resource(eg -- reservation tkt,db table,file or socket or any shared device) & some of the threads are reading n others updating the resource


How to lock the resource?
Using synchronized methods or synchronized blocks.
In either approach : the java code is executed from within the monitor & thus protects the concurrent access.








Note : sleeping thrd sleeps inside the monitor(i.e Thread invoking sleep(...) , DOESn't release the ownership of the monitor)

eg classes :
StringBuilder : thrd-unsafe.--- unsynchronized --- if multiple thrds try to access the same copy of the SB, SB may fail(wrong data)
StringBuffer --- thrd -safe ----synchronized internally---  if multiple thrds try to access the same copy of the SB, only 1 thrd can access the SB at any parti. instance.

which is reco class in single threaded appln? --- StringBuilder
multiple thrds -- having  individual copies -- StingBuilder
multiple thrds -- sharing same copy --   StringBuilder --
identify code to be guarded -- sb 's api -- invoke thrd unsafe API -- from inside synched block.

ArrayList(inherently thrd un-safe) Vs Vector(inherently thrd safe)

HashMap(un-safe) Vs Hashtable(thrd safe)


synchronized block syntax --- to apply synchro. externally.
synchronized (Object to be locked--- shared resource)
{
//code to be synchronized --methods of shared res. -- thrd safe manner(from within monitor)

}

1. If any thrd is accessing any synched method of 1 obj, then same thrd or any other thrd CANT concurrently access same method  of the same obj.(Tester1.java)

2. If any thrd is accessing any synched method of 1 obj, then same thrd or any other thrd CANT concurrently access same method  or any other synchronized method of the same obj.(Tester2.java)



2. If thrds have their own independent copies of resources, synch IS NOT required.(Tester2.java)
3.If u are using any thrd un-safe code(ie. ready code without source) --& want to apply thrd safety externally --- then just wrap the code within synched block to use locking.(Tester3.java)




Objective : Create Producer & Consumer thrds .
Producer produces data samples & consumer reads the same.
For simplicity : let the data be represented by : single Emp record
Producer produces emp rec  sequentially & consumer reads the same.

Rules : 1 when producer is producing data , consumer thrd concurrently should not be allowed to read data & vice versa.




Any more rules?????????????
Yes --- correct sequencing is also necessary in such cases.
Rule 2 : Producer must 1st produce data sample ---consumer reads data sample & then producer can produce next data sample. Similarly consumer should not be able to read stale(same) data samples .


ITC --- API level
Object class API
1. public void wait() throws IE ---thrd MUST be owner of the monitor(i.e invoke wait/notify/notifyAll from within synched block or method) --- othewise MAY get IllegalMontitorStateExc

---causes blocking of the thrd outside montitor.

UnBlocking triggers  --- interrupt(not reco --- since it may cause death of thrd) , notify/notifyAll --- reco.

2. 1. public void wait(long ms) throws IE
UnBlocking triggers  --- interrupt(not reco --- since it may cause death of thrd) , notify/notifyAll --- reco.,tmout exceeded

2.2 public void notify() -- MUST be invoked from within monitor , ow may get IllegalMonitorStateExc

Un-blocks ANY waiting thread , blocked on SAME MONITOR

2.3 public void notifyAll() -- Un-blocks ALL waiting threads , blocked on SAME MONITOR

notify/notifyAll--- DOESN't  BLOCK the thread & Doesn't release lock on monitor. --- send wake up signal -- to thrd/s waiting on same  monitor.
wait --- Blocks the thread --- Releases lock on the monitor.


volatile --- java keyword, applicable at data member.
typically used in multi-threaded scenario only when multiple thrds are accessing the same data member.
Use --- to specify-- that data var. is being used by multiple thrds concurrently -- so dont apply any optimizations(OR the value of the variable can get modified outside the current thrd) . With volatile keyword -- its guaranteed to give most recent value. 
The volatile modifier tells the JVM that a thread accessing the variable must always get its own private copy of the variable with the main copy in memory


















	
























































































