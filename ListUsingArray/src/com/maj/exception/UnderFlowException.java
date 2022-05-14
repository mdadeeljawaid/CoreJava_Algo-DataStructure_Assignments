package com.maj.exception;

public class UnderFlowException extends Exception {
	
	static final long serialVersionUID = 110001L;

	@Override
	public String toString() //member of "Object Class"
	{
		return "Empty list";
	}
}

