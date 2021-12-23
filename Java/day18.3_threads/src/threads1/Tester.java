package threads1;
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
			Thread.sleep(1000);// msec
		}
		System.out.println("main over....");
	}

}
