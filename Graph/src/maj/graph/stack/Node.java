package maj.graph.stack;

import maj.graph.matrix.Edge;

public class Node {
	Edge data;
	Node link;
	
	public Node(Edge data) {
		this.data = data;
		link = null;	
	}
}
