package inheritance;

public class Person {
	private String firstName, lastName;

	public Person(String firstName, String lastName) {
		// super();
		System.out.println("1");
		this.firstName = firstName;
		this.lastName = lastName;
	}


	// simply override (modify) , existing inherited func : to replace adr ret
	// version by actual state details of the Person
	public String toString() {
		return firstName + " " + lastName;
	}
	//add a getter : to get last name of a person
	public String getLastName()
	{
		return lastName;
	}
	//add a getter : to get first name of a person
	public String getFirstName()
	{
		return firstName;
	}
	

}
