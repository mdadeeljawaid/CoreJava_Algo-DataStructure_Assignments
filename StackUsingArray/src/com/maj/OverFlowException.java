package com.maj;

public class OverFlowException extends Exception {
static final long serialVersionUID = 110001L;
	
	@Override
	public String toString() //member of "Object Class"
	{
		return "Stack Full";
	}
}

