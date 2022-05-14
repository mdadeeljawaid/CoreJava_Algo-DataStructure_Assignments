package assignment10;

/* Create function for breadthFirstSearch.
(Hint: In depdthFirstSearch we have used Stack. For breadthFirstSearch
use Queue instead of Stack)*/

public class Main {
	public static void main(String[] args) {
		AdjacencyMatrix g1 = new AdjacencyMatrix(10);
		//ADD vertex...................................
		g1.addVertex("A"); //0
		g1.addVertex("B"); //1
		g1.addVertex("C"); //2
		g1.addVertex("D"); //3
		//ADD edge...................................
		g1.addEdge(0,1,1); // <A,B>
		g1.addEdge(1,2,1); // <B,C>
		g1.addEdge(2,3,1); // <C,D>
		g1.addEdge(0,3,1); // <A,D>
		g1.showGraph();
		g1.removeVertex(0); //A
		System.out.println("Aftre deletion of vertex A ");
		g1.showGraph();
		g1.removeVertex(0); //B
		System.out.println("Aftre deletion of vertex A ");
		g1.showGraph();
		System.out.println("BFS SPANNING TREE.............");
		AdjacencyMatrix st = g1.BreadthFirstSearch(0);
		st.showGraph();
	}
}
