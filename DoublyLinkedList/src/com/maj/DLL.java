package com.maj;

public class DLL {
	Node head = null;
	
	public void insertDataAtEnd(int data) {
		if (head == null) {
			head = new Node(data);
		}
		else {
			Node tr;
			for(tr = head; tr.next != null; tr = tr.next);
			tr.next = new Node(data);  	// L to R
			tr.next.prev = tr;			// R to L	
		}
	}
	
	public void show() {
		Node tr;
		System.out.println("DLL..................");
		//print L to R all node's data except last node
		for(tr = head; tr.next != null; tr = tr.next) {
			System.out.print(tr.data + ", ");
		}
		//print last node's data
		System.out.println(tr.data + ", ");
		
		//print R to L all node's data
		for(; tr != null; tr = tr.prev) {
			System.out.print(tr.data + ", ");
		}	
	}
}