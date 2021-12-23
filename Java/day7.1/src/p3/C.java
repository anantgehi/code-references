package p3;

//Will you face ambiguity issue with extact duplicate behaviour ? :  NO
public class C implements A, B {

	@Override
	public double add(double d1, double d2) {
	//	System.out.println(DATA);
		System.out.println(A.DATA+"  "+B.DATA);
		return d1 + d2;
	}

}
