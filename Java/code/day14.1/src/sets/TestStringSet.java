package sets;

import java.util.HashSet;

public class TestStringSet {

	public static void main(String[] args) {
		
		//outside literal string pool 5 objects are created
		String s1=new String("Anish");//literal string in pool & its reference in heap - 2 objects are created
		String s2=new String("Rutuj");
		String s3=new String("Mrunal");
		String s4=new String("Anish");//reference in heap is created as literal string already present in heap - 1 object is created
		String s5=new String ("Riya");
		
		HashSet<String> hs=new HashSet<>();
		System.out.println("Added "+hs.add(s1));//t
		System.out.println("Added "+hs.add(s2));//t
		System.out.println("Added "+hs.add(s3));//t
		System.out.println("Added "+hs.add(s4));//f - same content
		System.out.println("Added "+hs.add(s5));//t
		System.out.println(hs);//[.....] unordered, unsorted
		System.out.println("size of HashSet "+hs.size());//4
	}

}
