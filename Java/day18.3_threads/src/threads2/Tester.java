package threads2;
import static java.lang.Thread.currentThread;

public class Tester {

	public static void main(String[] args) throws InterruptedException{
		System.out.println(currentThread());// Thread [main,5,main]
		// create child thrds
		ChildThread t1 = new ChildThread("one");
		ChildThread t2 = new ChildThread("two");
		ChildThread t3 = new ChildThread("three");
		ChildThread t4 = new ChildThread("four");// How many RUNNABLE thrds ? 1 . state child thrds : new
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();// How many RUNNABLE thrds ? 5 (main + 4 child thrds)
		// B.L : for loop
		for (int i = 0; i < 10; i++) {
			System.out.println(currentThread().getName() + " counter # " + i);
			Thread.sleep(200);// msec
		}
		System.out.println("main waiting for child thrds to complete exec....");
		System.out.println(t1.isAlive()+" "+t4.isAlive());//t t
		t1.join();//main : blocked on join : waiting for t1 's completion
		t2.join();
		t3.join();
		t4.join();//how many thrds are runnable : 1 : parent : no orphan !
		System.out.println(t1.isAlive()+" "+t4.isAlive());//f f
		System.out.println("main over....");
	}

}
