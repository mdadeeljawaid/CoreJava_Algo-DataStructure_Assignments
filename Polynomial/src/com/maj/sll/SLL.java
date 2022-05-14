package com.maj.sll;

import com.maj.poly.PolyTerm;

public class SLL {
	public Node head;			//holds reference of first node
	
	public SLL() {
		head = null;	//empty SLL
		
	}
	
	public void append(PolyTerm data) {
		if(head == null) head = new Node(data);	//1st node
		else {
			Node tr; 
			for(tr = head; tr.link != null; tr = tr.link); 
				tr.link = new Node(data);	
	}

}
	
	public void show() {
		//traverse in SLL until SLL not over
		for(Node tr = head; tr != null; tr = tr.link)
			System.out.println(tr.data);
	}
}