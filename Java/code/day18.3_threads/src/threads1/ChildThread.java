package threads1;

public class ChildThread extends Thread {
	public ChildThread(String name) {
		// Thread(String name)
		super(name);// state : NEW
		start();// state : RUNNABLE
	}

	// override run() to replace blank imple. by actual exec logic
	@Override
	public void run() /* throws InterruptedException */ // overriding for of the method CAN'T throw NEW CHECKED Exc
	{
		System.out.println(getName() + " started");
		try {
			// B.L : for loop
			for (int i = 0; i < 10; i++) {
				System.out.println(getName() + " counter # " + i);
				Thread.sleep(500);// msec
			}
		} catch (Exception e) {
			System.out.println(getName() + " got exc " + e);
		}
		System.out.println(getName() + " over");
	}
}
