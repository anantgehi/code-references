package p2;
//Same Method names  with different signature 
public class C implements A,B{

	@Override
	public double add(double d1, double d2) {
		// TODO Auto-generated method stub
		return d1+d2;
	}

	@Override
	public double add(int d1, int d2) {
		// TODO Auto-generated method stub
		return d1*2+d2*2;
	}
	
	

}
