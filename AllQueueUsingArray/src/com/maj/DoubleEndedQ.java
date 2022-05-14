package com.maj;

public class DoubleEndedQ {
	private int []array;
	private int front, rear;
	
	public DoubleEndedQ() {
		array = new int[3];
		front = rear = -1;		//empty Q
	}
	
	public void insert_1(int item) throws OverFlowException {
		if(rear == array.length-1) {
			throw new OverFlowException();
		}
		else {
			front = 0;
			array[++rear] = item;
		}
	}
	
	public void insert_2(int item) throws OverFlowException {
		if(rear == array.length-1) {
			throw new OverFlowException();
		}
		else {
			front = 0;
			//shift all items backward
			for(int i = rear; i>=0; i--)
			array[i+1] = array[i];
		}
		++rear;		//rear also moved one place backward
		array[0] = item;
	}
	
	public int delete_1() throws UnderFlowException {
		if(front == -1) {
			throw new UnderFlowException();
		}
		else {
			int item = array[front];	//item at front is copied
			
			for(int i=front; i<rear; i++) {	//remaining all items shifted towards front
				array[i] = array[i+1];
			}
			
			rear--;
			if(rear == -1) front = -1;	//if Q has only one item and that is being removed
			return item;
		}
	}
	
	public int delete_2() throws UnderFlowException {
		if(front == -1) {
			throw new UnderFlowException();
		}
		else {
			int item = array[rear];	//item at front is copied
			rear--;
			if(rear == -1) front = -1;
			return item;
		}
	}
}
