package maj.graph.stack;

import maj.graph.matrix.Edge;

public class Stack {
	Node top;	
	public Stack() {
		top = null;		//empty Stack	
	}

	public void push(Edge data) {
		if(top == null) top = new Node(data);	//1st node
		else {
			Node newNode = new Node(data);
			newNode.link = top;	
			top = newNode;
		}
	}

	public Edge pop() {							//deleteAtBeg of SLL
		if(top == null) {
			System.out.println("Stack is empty");
			return null;
		}
		else {
			Edge data = top.data;	//copy data of first node
			Node temp = top;
			top = top.link;			//advance head to next node
			temp.link = null;		//break the reference
			temp = null;			//GC will automatically clean up the object
			return data;
		}
	}	

	public boolean isEmpty() {
		return (top == null) ? true : false;
	}
}