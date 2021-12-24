package strings;

public class Test3 {

	public static void main(String[] args) {
		// == vs equals
		Object s1 = new String("abcdefgh");//up casting
		Object s2 = new String("abcdefgh");
		System.out.println(s1 == s2);// f : reference equality
		System.out.println(s1.equals(s2));// Object class has overridden Object's equals method , to replace ref
											// equality by content equality : t
		String s3=((String)s2).toUpperCase();
		System.out.println(s2==s3);//f
		System.out.println(s2.equals(s3));//f
		System.out.println(((String)s2).equalsIgnoreCase(s3));//t
		

	}

}
