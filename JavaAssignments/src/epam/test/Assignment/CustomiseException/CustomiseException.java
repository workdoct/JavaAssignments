package epam.test.Assignment.CustomiseException;

import org.apache.log4j.Logger;

public class CustomiseException extends RuntimeException{

	
	public CustomiseException(String strMessage) {
		super(strMessage);
	}
	
	public CustomiseException() {
		super();
	}
	
	public CustomiseException(Throwable object) {
		super(object);
	}
}
