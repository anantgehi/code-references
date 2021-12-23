package inheritance;

public class Faculty extends Person {
	private int expInYrs;
	private String sme;// subject matter expertise
	public Faculty(String firstName,String lastName,int expInYrs ,String sme) {
		super(firstName,lastName);
		System.out.println("3");
		this.expInYrs=expInYrs;
		this.sme=sme;
	}
	//override toString , inherited from Person class , to return COMPLETE state of the Faculty
	public String toString()
	{
		return "Faculty "+super.toString()+" training for "+expInYrs+" years n expert in "+sme;
	}
	//add new func : teach :display  firstName teaching courses under sme
	public void teach()
	{
		System.out.println(getFirstName()+" teaching courses under "+sme);
	}
	
	
	
}
