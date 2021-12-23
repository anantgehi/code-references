package strings;

public class Test6 {

	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder("hello");
		System.out.println("contents "+sb+" len "+sb.length()+" capa "+sb.capacity());//hello , 5 21
		sb.append(true);
		sb.append(123.456);
		sb.append(56789);
		System.out.println(sb);//hellotrue123.45656789
		sb.append(34).append(false).append(new char[] {'a','v','n'});
		System.out.println("contents "+sb+" len "+sb.length()+" capa "+sb.capacity());//appended contents
		StringBuilder sb2=sb.insert(0, 'z');
		System.out.println(sb);//z......
		System.out.println(sb2);//z......
		System.out.println(sb==sb2);//true
		System.out.println(sb.equals(sb2));//true : ref eq.
		StringBuilder sb3=new StringBuilder("123456");
		StringBuilder sb4=new StringBuilder("123456");
		System.out.println(sb3==sb4);//f : different addr
		System.out.println(sb3.equals(sb4));//f : resolves it by ref eq
		
		

	}

}
