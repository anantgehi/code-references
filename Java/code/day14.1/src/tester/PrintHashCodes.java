package tester;

public class PrintHashCodes {

	public static void main(String[] args) {
		
		//All these strings will produce same hashcode hence we also use equals method with hashing
		
		//BBBB AaBB AaAa BBAa
		System.out.println("BBBB".hashCode());
		System.out.println("AaBB".hashCode());
		System.out.println("AaAa".hashCode());
		System.out.println("BBAa".hashCode());
		System.out.println("BBBB".equals("AaBB"));

	}

}
