package maj.main;

import maj.graph.matrix.AdjacencyMatrix;

public class Main {

	public static void main(String[] args) {

		AdjacencyMatrix g1 = new AdjacencyMatrix(10);

		//g1.addVertex("Patna");
		//g1.addVertex("Muzaffarpur");
		//g1.addVertex("Motihari");
		//g1.addVertex("Samastipur");
		//g1.addVertex("Darbhanga");
		//g1.addVertex("Sasaram");

		//g1.addEdge(0,5,200);
		//g1.addEdge(0,1,100);
		//g1.addEdge(4,5,180);
		//g1.addEdge(3,5,180);
		//g1.addEdge(3,0,180);

		//add vertex
		g1.addVertex("A");	//0
		g1.addVertex("B");	//1
		g1.addVertex("C");	//2
		g1.addVertex("D");	//3

		//add edge
		g1.addEdge(0,1,1);		//<A,B>
		g1.addEdge(1,2,1);		//<B,C>
		g1.addEdge(2,3,1);		//<A,C>
		g1.addEdge(0,3,1);		//<A,D>

		g1.showGraph();

		//System.out.println("DFS SPANNING TREE");
		//AdjacencyMatrix st = g1.depthFirstSearch(0);
		//st.showGraph();

		/*
		g1.removeVertex(0);
		g1.showGraph();
		g1.removeVertex(0);
		g1.showGraph();
		g1.removeVertex(0);
		g1.showGraph();
		g1.removeVertex(0);
		g1.showGraph();

		g1.addVertex("A");	
		g1.showGraph();
		*/
		/*boolean status= g1.iSCycleFormed();
		if(status)
			System.out.println("Cycle Formed");
		else 
			System.out.println("No Cycle");*/
		
		g1.removeVertex(0);	//A
		System.out.println("After deletion of vertex A ");
		g1.showGraph();
		g1.removeVertex(0);	//B
		System.out.println("After deletion of vertex A ");
		g1.showGraph();
	}
}
