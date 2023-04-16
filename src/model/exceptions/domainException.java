package model.exceptions;

public class domainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public domainException(String msg) {
		super(msg);
	}
}
