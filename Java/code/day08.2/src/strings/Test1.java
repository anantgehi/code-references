package strings;

public class Test1 {

	public static void main(String[] args) {
		//immutability of strings
		String s1=new String("hello");
		s1.concat("hi");
		System.out.println(s1);//hello
		s1 += "12345";//s1=s1.concat("12345");
		System.out.println(s1);//hello12345
		System.out.println(s1.length());
		s1.toUpperCase();
		System.out.println(s1);//hello12345
		System.out.println(s1.replace('l', 'p'));//heppo12345
	}

}
