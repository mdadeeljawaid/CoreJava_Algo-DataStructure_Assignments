package assignment8b;

public class Node {
	public Node lc;
	public int data;
	public Node rc;
	public int ht;
	public Node(int data) {
		this.data = data;
		lc = rc = null;
	}
}
