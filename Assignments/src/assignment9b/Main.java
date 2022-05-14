package assignment9b;

/*b. Create Undirected Graph using Adjacency List.*/

public class Main {
	public static void main(String[] args) {
		// Creating vertex
		int size = 5;
		AdjacencyList g1 = new AdjacencyList(size);
		// Inserting nodes
		// Custom input node elements
		g1.addEdge(0, 1);
		g1.addEdge(0, 4);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(1, 4);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);
		// Printing adjacency list
		g1.printadjacencylist();
	}
}