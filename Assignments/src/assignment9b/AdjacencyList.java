package assignment9b;

import java.util.LinkedList;
public class AdjacencyList {
	LinkedList<LinkedList<Integer> > adj;
	int size;
	public AdjacencyList(int size) {
		this.size = size;
		adj = new LinkedList<LinkedList<Integer> >();
		for (int i = 0; i < size; ++i) {
			adj.add(new LinkedList<Integer>());
		}
	}
	public void addEdge(int u, int v) {
		// Creating bi-directional vertex
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	public void printadjacencylist() {
		for (int i = 0; i < size; ++i) {
			// Printing the head
			System.out.print(i + "->");
			for (int v : adj.get(i)) {
				// Printing the nodes
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
}