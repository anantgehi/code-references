package exc_handling;

public class TestCheckedException2 {

	public static void main(String[] args) throws InterruptedException{
		System.out.println("Before sleep");
		// Thread class : public static void sleep(long msec) throws
		// InterruptedException : chked exc
		// Javac forces handling of chked excs

		Thread.sleep(2000);
		System.out.println("end of try...");

		System.out.println("after sleep");

	}

}
