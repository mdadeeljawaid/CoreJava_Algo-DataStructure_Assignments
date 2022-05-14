package assignment10;

public class AdjacencyMatrix {
	String []vertex; //vertex
	int [][]matrix; //adjacency matrix
	int noOfVertex; //
	public AdjacencyMatrix(int size) {
		vertex = new String[size];
		matrix = new int[size][size];
		noOfVertex = 0;
		for(int i=0; i<matrix.length; i++) { // set 0
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	public AdjacencyMatrix(AdjacencyMatrix m) {
		noOfVertex = m.noOfVertex;
		vertex = new String[noOfVertex];
		matrix = new int[noOfVertex][noOfVertex];
		//copy all vertex of 'question graph' into 'answer graph'
		for(int i=0; i<noOfVertex; i++) {
			vertex[i] = m.vertex[i];
		}
		for(int i=0; i<matrix.length; i++) { // set 0
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	public void addVertex(String vertexName) {
		if(noOfVertex == vertex.length) {
			System.out.println("Memory Full");
			return;
		}
		vertex[noOfVertex++] = vertexName;
	}
	public void addEdge(int sourceVertex, int destinationVertex, int weight) {
		matrix[sourceVertex][destinationVertex] = weight;
		matrix[destinationVertex][sourceVertex] = weight;
	}
	public void removeVertex(int vi) {
		//Removing 'vi' Row
		for(int i=vi; i<noOfVertex-1; i++) {
			for(int j=0; j<noOfVertex; j++)
				matrix[i][j] = matrix[i+1][j];
		}
		//Removing 'vi' column
		for(int i=vi; i<noOfVertex-1; i++) {
			for(int j=0; j<noOfVertex; j++)
				matrix[j][i] = matrix[j][i+1];
		}
		// set last row & column to zero
		for(int i=0; i<noOfVertex; i++) {
			matrix[noOfVertex-1][i] = 0; // moving into row
			matrix[i][noOfVertex-1] = 0; // moving into column
		}
		//Remove vertex by shifting all items into forward direction.
		for(int j=vi; j<noOfVertex-1; j++)
			vertex[j] = vertex[j+1];
		noOfVertex--;
	}
	public void removeEdge(int sourceVertex, int destinationVertex) {
		matrix[sourceVertex][destinationVertex] = 0;
		matrix[destinationVertex][sourceVertex] = 0;
	}
	public void showGraph(){
		System.out.println("GRAPH");
		for(int i = 0; i < noOfVertex; i++) {
			for(int j = 0; j < noOfVertex; j++)
				System.out.print(matrix[i][j] +" ");
			System.out.println("");
		}
		System.out.println("**********************************");
		for(int i = 0; i < noOfVertex; i++) {
			System.out.println(vertex[i]);
			// source vertex
			for(int j=0; j<noOfVertex; j++) {
				if(matrix[i][j] != 0) {
					System.out.print(vertex[j]); //destination/adjacent vertex
					System.out.print( "(" + matrix[i][j] +"), "); // weight
				}
			}
			System.out.println("\n-----------------------------------------");
		}
	}
	public AdjacencyMatrix BreadthFirstSearch(int currentVertex){
		AdjacencyMatrix st = new AdjacencyMatrix(this);
		BFSQueue s = new BFSQueue();
		int visited[] = new int[noOfVertex];
		int k=0;
		while(true) {
			visited[k++] = currentVertex;
			for(int i=0; i<noOfVertex; i++) {
				if(matrix[currentVertex][i] != 0)
					s.enqueue(new Edge(currentVertex, i));
			}
			boolean found = false;
			Edge e;
			do {
				if(s.isEmpty())
					return st;
				e = s.dequeue();
				found = false;
				for(int i=0; i<k; i++) {
					if(visited[i] == e.vertex2) {
						found = true;
						break;
					}
				}
			} while(found == true);
			st.addEdge(e.vertex1, e.vertex2, 1);
			currentVertex = e.vertex2;
		}
	}
}
