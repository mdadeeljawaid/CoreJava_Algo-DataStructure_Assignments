package assignment8b;

public class Queue_Level {
	Queue_Node front;
	Queue_Node rear;
	public Queue_Level() {
		front= null;
		rear=null;
	}
	public void enqueue (Node root) {
		Queue_Node node = new Queue_Node (root);
		if (front == null)
		{
			front=node;
			rear=node;
		}
		else {
			rear.link=node;
			rear=node;
		}
	}
	public Node dequeue() {
		if (front == null) {
			return null;
		}
		else {
			Node data =front.data;
			Queue_Node temp = front;
			front =front.link;
			temp.link = null;
			temp=null;
			return data;
		}
	}
	public boolean isEmpty() {
		return (front == null) ? true : false;
	}
}
