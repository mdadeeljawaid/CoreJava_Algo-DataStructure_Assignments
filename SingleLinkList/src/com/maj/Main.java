package com.maj;

public class Main {

	public static void main(String[] args) {
		
		/*
		Node head = null;	//empty SLL
		head = new Node(100);		//node1
		head.link = new Node(200);		//node2
		head.link.link = new Node(300);		//node3
		head.link.link.link = new Node(400);  	//node4
		//show SLL
		System.out.println("SLL");
		Node tr = head;		//reference 'tr' to first node
		while(tr != null) {	//while SLL is not finished
			System.out.print(tr.data + " , ");	//print node's data
			tr = tr.link;		//advance tr to next node
		}
		*/
		
		SLL l1 = new SLL();
		l1.append(100);
		l1.append(200);
		l1.append(300);
		l1.addAtBeg(10);
		l1.addAtBeg(5);
		System.out.println("SLL");
		l1.show();
		
		int dd =l1.deleteAtBeg();
		System.out.println("Deleted data = " + dd);
		
		System.out.println("SLL");
		l1.show();
		
		//Stack
		MyStack s = new MyStack();
		s.push(100);
		s.push(200);
		System.out.println("SLL");
		
		System.out.println("Popped data = " + s.pop());
		
		System.out.println("Over");
	
	}

}
