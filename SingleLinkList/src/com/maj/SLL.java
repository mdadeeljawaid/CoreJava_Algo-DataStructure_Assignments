package com.maj;

public class SLL {
	Node head;	//holds reference of first node
	
	public SLL() {
		head = null;	//empty SLL
		
	}
	
	public void append(int data) {
		if(head == null) head = new Node(data);	//1st node
		else {
			//traverse in SLL and reach to the last node
			Node tr; 
			for(tr = head; tr.link != null; tr = tr.link);
			//for(tr = head; tr.plink != null; tr = tr.plink);
				//Now 'tr' will be referencing to the last node
				//create and attach a new node with the last node
				tr.link = new Node(data);
				//tr.plink = new Node(data);	
				//tr.plink.nlink = tr;
	}

}
	
	public void addAtBeg(int data) {
		if(head == null) head = new Node(data);	//1st node
		else {
			Node newNode = new Node(data);
				newNode.link = head;	
				head = newNode;
	}

}
	public int deleteAtBeg() {
		if(head == null) {
			System.out.println("SLL is empty"); 
			return 0;
		}
		else {
			int data = head.data;	//copy data of first node
			Node temp = head;
			head = head.link;		//advance head to next node
			temp.link = null;		//break the reference
			temp = null;		//GC will automatically clean up the object
			return data;
	}

}
	
	public void addBefore(int data, int before) {
		if(head == null) head = new Node(data); //first node
		else {
			//traverse in SLL and reach to the node that contains "before"
			Node tr = head;	//pointing to first node
			Node p = null;	//pointing to parent of first node
			while(tr != null && tr.data != before) {
				p = tr;
				tr = tr.link;	//moves 'tr' to next node
			}
			
				//case 1 --> Before data is not present
			if(tr == null) { System.out.println("Before data is not present");return; }
			
				//case 2 --> Before data is present in other node (except first node)
			if(p!=null) {
				p.link = new Node(data);
				p.link.link = tr;
				return;
			}
			
				//case 3 --> Before data is present in first node
			p = new Node(data);
			p.link = head;
			head = p;
			
		}
	}
	
	public void show() {
		//traverse in SLL until SLL not over
		for(Node tr = head; tr != null; tr = tr.link)
			System.out.println(tr.data);
	}
}