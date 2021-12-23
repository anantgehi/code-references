package custom_exception;

@SuppressWarnings("serial")
public class BankingException extends Exception {
	public BankingException(String mesg) {
		super(mesg);
	}
}
