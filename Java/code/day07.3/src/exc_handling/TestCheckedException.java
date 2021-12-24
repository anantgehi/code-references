package exc_handling;

public class TestCheckedException {

	public static void main(String[] args) {
		System.out.println("Before sleep");
		// Thread class : public static void sleep(long msec) throws
		// InterruptedException : chked exc
		// Javac forces handling of chked excs
		try {
			Thread.sleep(2000);
			System.out.println("end of try...");
		} catch (InterruptedException e) {
			System.out.println("exc occurred!!!!!!");
		}
		System.out.println("after sleep");

	}

}
