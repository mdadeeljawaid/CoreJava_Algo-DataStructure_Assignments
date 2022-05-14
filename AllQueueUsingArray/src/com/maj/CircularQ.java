package com.maj;

public class CircularQ {
	private int []array;
	private int front, rear;
	
	public CircularQ() {
		array = new int[3];
		front = rear = -1;		//empty Q
	}
	
	public void enqueue(int item) throws OverFlowException {
		int bi = (front == 0) ? array.length-1 : front - 1;
		
		if(bi == rear) {
			throw new OverFlowException();
		}
		else {
			rear++;
			array[rear] = item;
			if(front == -1) 	//if CQ was earlier empty
				front =0;
		}
		
	}
	
	public int dequeue() throws UnderFlowException {
		if(front == -1) {
			throw new UnderFlowException();
		}
		else {
			int item = array[front];	//item at front is copied
			
			if(front == rear) {		//case 1 : is CQ has single item
				front = rear = -1;
			}
			else {					//case 2 : CQ has more than one items
				
				/* **** advance front **** */
				//method1
				//front++;
				//if(front == array.length) front = 0; 
				
				
				//method2
				//if(front == array.length-1) front = -1;
				//front++;
				
				
				//method3
				front = (front == array.length-1) ? 0 : front + 1; 
			}
			return item;
		}
	}
}
