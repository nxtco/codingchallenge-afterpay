package com.coding.challenge.api;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends Exception
{

	private static final long serialVersionUID = 1L;
	
	protected Map<String,String> errorList = null;
	
	 
	
	public ValidationException() 
	{
		super();
		errorList = new HashMap<String,String>();
	}

	public ValidationException(String message, Throwable throwable) 
	{
		super(message, throwable);
		errorList = new HashMap<String,String>();
	}

	public ValidationException(String message) 
	{
		super(message);
		errorList = new HashMap<String,String>();
	}


	public ValidationException(Throwable throwable) 
	{
		super(throwable);
		errorList = new HashMap<String,String>();
	}
	
	
	public ValidationException(Map<String, String> errorList) 
	{
		super();
		this.errorList = errorList;
	}

	/**
     * This method adds the errorCode and errorData to this exception.
     *
     * @param errorCode standard error code for mapping
     * @param errorData error data that caused this exception
     */
    public void addError(String errorCode, String errorDescription) {
        errorList.put(errorCode,errorDescription);
    }

	public Map<String, String> getErrorList() {
		return errorList;
	}
	
	

}
