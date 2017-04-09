package net.readify.knockknock.api.exception;

import net.readify.knockknock.api.model.ErrorMessage;

public class InvalidRequestException extends Exception {

	private static final long serialVersionUID = 188036535948857864L;
	
	private ErrorMessage errorMessage;
	
	public InvalidRequestException(final String error) {
		super(error);
		errorMessage = new ErrorMessage();
		errorMessage.setMessage(error);
	}
	
	public ErrorMessage getErrorMessage(){
		return errorMessage;		
	}

}
