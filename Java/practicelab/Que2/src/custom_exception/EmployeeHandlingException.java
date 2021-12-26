package custom_exception;

public class EmployeeHandlingException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmployeeHandlingException(String errMsg)
	{
		super(errMsg);
	}

}
