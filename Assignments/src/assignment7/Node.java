package assignment7;

public class Node {
	int data;
	Node nextLink;
	Node previousLink;

	public Node(int data) {
		nextLink = null;
		this.data = data;
		previousLink = null;
	}
}