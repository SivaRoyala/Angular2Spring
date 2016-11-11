package com.siva.exception;

public class StudentDaoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private int errorCode;
	
	private String errorMsg;

	public StudentDaoException(){
		super();
	}
	
	public StudentDaoException( int code, String msg){
		super(msg);
		this.errorCode = code;
	}
	
	public StudentDaoException(String msg){
		super(msg);
		this.errorMsg = msg;
	}
	
	public StudentDaoException(String message, int code, Throwable cause) {
		super(message, cause); 
		this.errorCode = code; 
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
