package com.maj;

public class MyStack {
	Node top;	
	public MyStack() {
		top = null;		//empty Stack
		
	}
	
	public void push(int data) {
		if(top == null) top = new Node(data);	//1st node
		else {
			Node newNode = new Node(data);
				newNode.link = top;	
				top = newNode;
	}

}
	
	public int pop() {
		if(top == null) {
			System.out.println("Stack is empty");
			return 0;
		}
		else {
			int data = top.data;	//copy data of first node
			Node temp = top;
			top = top.link;			//advance head to next node
			temp.link = null;		//break the reference
			temp = null;			//GC will automatically clean up the object
			return data;
		}

	}
	
}