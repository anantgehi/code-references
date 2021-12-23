package exc_handling;

public class TestUncheckedException {

	public static void main(String[] args) {
		String s = "12345";
		System.out.println("int value " + Integer.parseInt(s));// exc : NumberFormatExc : un-chked exc : since it
																// extends RuntTimeExc : javac DOES NOT force handling
																// of the un-chked excs
		System.out.println("main over...");

	}

}
