package assignment5;

public class FactorOfNumber {

	int num;
	Node headOfFactors;
	public FactorOfNumber(int num) {
		this.num = num;
	}
	public void findFactors() {
		for ( int i = 1; i <= num; i++ ) {
			if ( num % i == 0 )
				if (headOfFactors == null)
					headOfFactors = new Node (i);
				else {
					Node newNode = new Node(i);
					Node current = headOfFactors;
					while ( null != current.link )
						current = current.link;
					current.link=newNode;
				}
		}
	}
	public void display() {
		for(Node tr = headOfFactors; tr != null; tr=tr.link)
			System.out.print(tr.data + "\t");
	}
}
