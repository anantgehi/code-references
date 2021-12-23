package threads3;
import static java.lang.Thread.currentThread;

public class MyRunnableTask implements Runnable {
	

	// implement run() to supply B.L
	@Override
	public void run() /* throws InterruptedException */ // overriding for of the method CAN'T throw NEW CHECKED Exc
	{
		System.out.println(currentThread().getName() + " started");
		try {
			// B.L : for loop
			for (int i = 0; i < 10; i++) {
				System.out.println(currentThread().getName() + " counter # " + i);
				Thread.sleep(500);// msec
			}
		} catch (Exception e) {
			System.out.println(currentThread().getName() + " got exc " + e);
		}
		System.out.println(currentThread().getName() + " over");
	}
}
