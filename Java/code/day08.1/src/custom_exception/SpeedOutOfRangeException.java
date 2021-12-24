package custom_exception;


@SuppressWarnings("serial")
public class SpeedOutOfRangeException extends Exception{
	public SpeedOutOfRangeException(String errMesg) {
		super(errMesg);//inits err mesg.
	}

}
