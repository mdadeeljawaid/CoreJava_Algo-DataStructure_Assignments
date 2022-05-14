package ques2;

public class SLL {
	Node head;	//holds reference of first node

	public SLL() {
		head = null;	//empty SLL

	}

	public void append(int data) {
		if(head == null) head = new Node(data);	//1st node
		else {
			Node tr; 
			for(tr = head; tr.link != null; tr = tr.link);
			tr.link = new Node(data);

		}

	}

	public void insertAtFirst(int data) {
		if(head == null) head = new Node(data);	//1st node
		else {
			Node newNode = new Node(data);
			newNode.link = head;	
			head = newNode;
		}

	}
	public int deleteAtFirst() {
		if(head == null) {
			System.out.println("SLL is empty"); 
			return 0;
		}
		else {
			int data = head.data;	
			Node temp = head;
			head = head.link;		
			temp.link = null;		
			temp = null;		
			return data;
		}

	}

	public void show() {
		for(Node tr=head;tr!=null;tr=tr.link)
			System.out.println(tr.data);
	}
}