package com.maj.exception;

//custom exception.....
public class SpaceFullException extends Exception {
	
	static final long serialVersionUID = 110001L;
	
	@Override
	public String toString() //member of "Object Class"
	{
		return "Space is Full";
	}
}
