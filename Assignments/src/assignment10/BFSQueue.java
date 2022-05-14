package assignment10;

public class BFSQueue {
	Node front;
	Node rear;
	public BFSQueue() {
		front= null;
		rear=null;
	}
	public void enqueue(Edge data) {
		Node node = new Node (data);
		if (front == null) {
			front=node;
			rear=node;
		}
		else {
			rear.link=node;
			rear=node;
		}
	}
	public Edge dequeue() {
		if (front == null) {
			System.out.println("Queue is empty");
			return null;
		}
		else {
			Edge data =front.data;
			Node temp = front;
			front =front.link;
			temp.link = null;
			temp=null;
			return data;
		}
	}
	public void show() {
		for(Node tr = front;tr != null; tr=tr.link)
			System.out.println(tr.data);
	}
	public boolean isEmpty() {
		return (front == null) ? true : false;
	}
}