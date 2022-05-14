package maj.graph.matrix;

import maj.graph.disjoint.DisjointSet;
import maj.graph.disjoint.ItemNode;
import maj.graph.disjoint.SetNode;
import maj.graph.stack.Stack;

public class AdjacencyMatrix {

	String[] vertex;	//vertex
	int[][] matrix;		//adjacency matrix
	int noOfVertex;		//

	public AdjacencyMatrix(int size) {
		vertex = new String[size];
		matrix = new int[size][size];
		noOfVertex = 0;

		for(int i = 0; i<matrix.length; i++) {		//set 0
			for(int j = 0; j<matrix[i].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	public AdjacencyMatrix(AdjacencyMatrix m) {
		noOfVertex = m.noOfVertex;
		vertex = new String[noOfVertex];
		matrix = new int[noOfVertex][noOfVertex];

		//copy all vertex of 'question graph' into 'answer graph'.........
		for(int i=0; i<noOfVertex; i++) {
			vertex[i] = m.vertex[i];
		}

		for(int i=0; i<matrix.length; i++) {			// set 0 
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}	

	public void addVertex(String vertexName){
		if(noOfVertex == vertex.length) { System.out.println("Memory full"); return; }

		vertex[noOfVertex++] = vertexName;

	}

	public void addEdge(String sourceVertex, String destinationVertex, int weight){

	}

	public void addEdge(int svi, int dvi, int weight) {
		matrix[svi][dvi] = weight;
		matrix[dvi][svi] = weight;
	}

	public void removeVertex(int vi){
		//removing vi row and column; and vi vertex
		/*for(int i = vi; i<noOfVertex-1; i++) {
			vertex[i] = vertex[i+1];	//remove vertex by shifting all items into forward direction
			for(int j = 0; j<noOfVertex; j++) {
				matrix[i][j]=matrix[i+1][j];	//matrix[0][1]=matrix[0][2]	
				matrix[j][i]=matrix[j][i+1];
				matrix[noOfVertex-1][j] = 0;
				matrix[j][noOfVertex-1] = 0;
			}
		}
		noOfVertex--;
		*/
		
	//removing vi row
	for(int i = vi; i<noOfVertex-1; i++) {
			for(int j = 0; j<noOfVertex; j++) {
				matrix[i][j]=matrix[i+1][j];	//matrix[0][1]=matrix[0][2]	
					}
				}

		//removing vi column
		for(int i = vi; i<noOfVertex-1; i++) {
			for(int j = 0; j<noOfVertex; j++) {
				matrix[j][i]=matrix[j][i+1];	//matrix[0][1]=matrix[0][2]	
			}
		}

		//set last row and column to zero
		for(int i = 0; i<noOfVertex; i++) {
			matrix[noOfVertex-1][i] = 0;	//moving into row
			matrix[i][noOfVertex-1] = 0;	//moving into column
		}			

		//remove vertex by shifting all items into forward direction
		for(int j = vi; j<noOfVertex-1; j++) {
			vertex[j] = vertex[j+1];
		}
		noOfVertex--;
		 
	}	

	public void removeEdge(int svi, int dvi){
		matrix[svi][dvi] = 0;
		matrix[dvi][svi] = 0;
	}

	public void showGraph(){
		System.out.println("GRAPH..............");

		for(int i=0; i<noOfVertex; i++) {
			for(int j=0; j<noOfVertex; j++) {
				System.out.print(matrix[i][j] +" ");
			}
			System.out.println("");
		}

		System.out.println("**********************************");

		for(int i = 0; i<noOfVertex; i++) {	
			System.out.println(vertex[i]);		//source vertex

			for(int j = 0; j<noOfVertex; j++) {
				if(matrix[i][j] != 0);{
					System.out.print(vertex[j]);		//destination/adjacent vertex
					System.out.println("(" + matrix[i][j] +"), ");	//weight
				}
			}
			System.out.println("\n----------------------------------");
		}
	}		

	// ...............................18.11.2021.......................................
	public AdjacencyMatrix depthFirstSearch(int currentVI){
		AdjacencyMatrix st = new AdjacencyMatrix(this); 

		Stack s = new Stack();
		//Queue q = new Queue();
		int visited[] = new int[noOfVertex];
		int k=0;

		while(true) {
			visited[k++] = currentVI;

			//PUSH(ALL ADJACENT EDGE OF 'currentVI')..................
			for(int i=0; i<noOfVertex; i++) {
				if(matrix[currentVI][i] != 0){
					s.push(new Edge(currentVI, i));
					//q.insert(new Edge(currentVI, i));
				}
			}
			//pop the edge whose vertex2(destination vertex) is unvisited................	
			boolean found = false;
			Edge e;
			do {
				if(s.isEmpty()) {return st;}
				//if(q.isEmpty()) {return st;}
				e = s.pop();			
				//e = q.pop();
				//e.vertex1, e.vertex2
				//search 'e.vertex2' into 'visited' list
				found = false;
				for(int i=0; i<k; i++) {
					if(visited[i] == e.vertex2) {
						found = true;
						break;
					}
				}
			}	while(found == true);
			st.addEdge(e.vertex1,  e.vertex2, 1);
			currentVI = e.vertex2;	
		}
	}

	//..........20.11.2021..........

	public boolean iSCycleFormed(){

		//1. create set for each of the vertices
		//2. while(all edges are not picked from graph){ 
		//3. s1=findSet(SV), s2=findSet(DV) 
		//4. if(s1 != s2) { s = union(s1,s2), addSet(s)
		//5. else return true;
		//6.  }
		//7. return false;

		//1. create set for each of the vertices
		DisjointSet set = new DisjointSet();
		for(int i=0; i<noOfVertex; i++) {
			set.addToSet(new ItemNode(i));
		}

		//2. Fetch each of the edges from graph
		for(int i=0; i<noOfVertex; i++) {	// reads only upper triangle matrix
			// Suggested By Abhishek 
			//System.out.println("\n-----------------SET " + (i+1) + " ----------------");
			//set.showTheSet();
			for(int j=i; j<noOfVertex; j++) {
				if(matrix[i][j] != 0) {				// pick the edge
					//System.out.println("I = " + i + " J = " + j);
					// I------------------J
					ItemNode s1 = set.getTheSet(i);
					ItemNode s2 = set.getTheSet(j);  // error:  it was i in place of j
					if(s1 == s2) return true;	  //both vertices are in the same set
					//merge both and add both set
					set.mergeAndAdd(s1,s2);
				}
			}
		}
		return false;
	}
}
