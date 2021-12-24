package sets;

import java.util.HashSet;

public class TestEmpSet {

	public static void main(String[] args) {
		
		//create empty HS<Emp> 
		//PK : emp id
		HashSet<Emp> emps=new HashSet<>();
		
		Emp e1=new Emp("rnd-001", "abc", 10000);
		Emp e2=new Emp("rnd-002", "abc2", 20000);
		Emp e3=new Emp("rnd-001", "abc", 10000);//same as e1
		
		System.out.println("Added "+emps.add(e1));//t
		System.out.println("Added "+emps.add(e2));//t
		System.out.println("Added "+emps.add(e3));//should ret false as e1 is already present BUT rets true
		//incase of emp class hash set is not identifying duplicates
		//hash set is overriding object's equals method which follows reference equality hence it is failing here to identify duplicates
		//supply overridden equals method with emp id as pk
		//only equals method is not enough, we alos need to match hashcodes
		
		System.out.println(emps);//[...]
		System.out.println("size "+emps.size());//3 when eqquals and hashcode methods are not overridden
		//2 when equals and hashcode methods are overridden

//		System.out.println(e1.equals(e3));//t
//		System.out.println(e1.hashCode()+" "+e3.hashCode());//same values or different ?
//		
		//Contract : Mandatory : Equal objects MUST produce SAME hashcode
		

	}

}
