package strings;

public class Test2 {

	public static void main(String[] args) {
		// == vs equals
		String s1 = new String("abcdefgh");
		String s2 = new String("abcdefgh");
		System.out.println(s1 == s2);// f : reference equality
		System.out.println(s1.equals(s2));// String class has overridden Object's equals method , to replace ref
											// equality by content equality : t
		String s3=s2.toUpperCase();
		System.out.println(s2==s3);//f
		System.out.println(s2.equals(s3));//f
		System.out.println(s2.equalsIgnoreCase(s3));//t
		

	}

}
