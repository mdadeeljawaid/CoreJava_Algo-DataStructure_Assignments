package com.maj;

public class MyStack {
	private int [] array;
	private int top;
	
	public MyStack() {
		array = new int[2];
		top = -1;		//empty stack
	}
	
	public void push(int item) throws OverFlowException{
		if(top == array.length-1) {
			throw new OverFlowException();
		}		
		else {
			array[++top] = item;
		}
	}
	
	public int pop () throws UnderFlowException {
		if(top == -1) {
			throw new UnderFlowException();
		}
		else {
			return array[top--];
		}
	}
}