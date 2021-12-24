package custom_exception;

public class ProductHandlingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProductHandlingException(String mesg) {
		super(mesg);
	}

}
