package assignment3;

public class Queue<x> {

	private Node<x> front;
	private Node<x> rear;
	private int length;

	private static class Node<x>{
		private final x data;
		private Node<x> next;

	public Node(x data) {
		super();
			this.data = data;
			this.next = null;
		}		
	}

	public void enqueue(x data) {
		if(front == null){
			rear = new Node<x>(data);
			front = rear;
		}
		else{
			rear.next = new Node<x>(data);
			rear = rear.next;
		}
		length++;
	}

	public x dequeue(){
		if(front != null){
			x result =front.data;
			front = front.next;
			length--;
			return result;
		}
		return null;
	}

	public int size(){
		return length;
	}
	public void display() {
		Node<x> currentNode = front;
		while(currentNode != null){
			System.out.print(currentNode.data+" ");
			currentNode = currentNode.next;
		}
	}

	public static void main(String[] args) {

		Queue <Integer> queue = new Queue<>();
		queue.enqueue(15);
		queue.enqueue(25);
		queue.enqueue(45);
		queue.enqueue(80);

		System.out.println("The size of Queue is : "+queue.size());
		queue.display();
		System.out.println("\nAn Item is being Dequeue : "+queue.dequeue());
		System.out.println("Now the size of Queue is : "+queue.size());
		queue.display();
	}
}
