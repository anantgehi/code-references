package strings;

public class Test5 {

	public static void main(String[] args) {
		//Testing String class API 
		String s="1234 strings hello , testing strings here....";
		System.out.println(s.charAt(0)+" "+s.charAt(s.length()-1));
		System.out.println("Asish".compareTo("Ashish"));// < 0 
		System.out.println(s.contains("strings"));//t
		System.out.println(s.indexOf("strings"));//0
		System.out.println(s.indexOf("strings",1));//24
		System.out.println(s.lastIndexOf("strings"));//24
		System.out.println(s.matches("[0-9]+.*[tri]*[her]*"));
		
	}

}
