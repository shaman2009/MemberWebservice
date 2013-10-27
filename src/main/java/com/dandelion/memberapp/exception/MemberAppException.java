package com.dandelion.memberapp.exception;

/**
 * The exception used in the Webservice library. It uses an error code and a message
 * to indicate an error. The error codes are defined in file "ErrorCode".
 * 
 * @author fengxiang
 */
public class MemberAppException extends Exception { 
	private static final long serialVersionUID = 8615689942272126971L;

	/**
	 * Constructor for WebserviceException.
	 * 
	 * @param errorCode
	 */
	public MemberAppException(int errorCode) {
		super("");
		this.errorCode = errorCode;
	}

	public MemberAppException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public MemberAppException(int errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public Throwable getCause() {
		return super.getCause();
	}

	private int errorCode;
}