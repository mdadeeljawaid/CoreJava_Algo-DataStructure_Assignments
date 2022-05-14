package assignment4;

public class HCF {

	int num1, num2, hcf;
	Node headOfFactorsList1;
	Node headOfFactorsList2;
	Node headOfCommonFactors;

	public HCF(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2; this.hcf = 0;
		this.headOfFactorsList1 = null;
		this.headOfFactorsList2 = null;
		this.headOfCommonFactors = null;
	}

	public void findHCF() {
		findFactors();
		findCommonFactorList(); hcf = headOfCommonFactors.data;
	}

	private void findFactors() {
		for ( int i = 1; i <= num1; i++ ) {
			if ( num1 % i == 0 )
				appendFactorList1(i);
		}
		for ( int i = 1; i <= num2; i++ ) {
			if ( num2 % i == 0 )
				appendFactorList2(i);
		}
	}

	private void appendFactorList1(int i) {
		if (headOfFactorsList1 == null)
			headOfFactorsList1 = new Node (i);
		else {
			Node newNode = new Node(i);
			Node current = headOfFactorsList1;
			while ( null != current.link )
				current = current.link;
			current.link=newNode;
		}
	}

	private void appendFactorList2(int i) {
		if (headOfFactorsList2 == null)
			headOfFactorsList2 = new Node (i);
		else {
			Node newNode = new Node(i);
			Node current = headOfFactorsList2;
			while(null != current.link)
				current=current.link;
			current.link=newNode;
		}
	}

	private void findCommonFactorList() {
		for(Node tr = headOfFactorsList1; tr != null; tr = tr.link) {
			for(Node tr2 = headOfFactorsList2; tr2 != null; tr2 = tr2.link) {
				if(tr.data == tr2.data) {
					if (headOfCommonFactors == null)
						headOfCommonFactors = new Node (tr.data);
					else {
						Node newNode=new Node(tr.data);
						newNode.link = headOfCommonFactors;
						headOfCommonFactors = newNode;
					}
				}
			}
		}
	}

	public void display() {
		System.out.println( "Factors of " + num1);
		for(Node tr = headOfFactorsList1; tr != null; tr=tr.link)
			System.out.print(tr.data + "\t");
		System.out.println();
		System.out.println( "Factors of " + num2);
		for(Node tr = headOfFactorsList2; tr != null; tr=tr.link)
			System.out.print(tr.data + "\t");
		System.out.println();
		System.out.println( "Common Factors of " + num1 + " and " + num2);
		for(Node tr = headOfCommonFactors; tr != null; tr=tr.link)
			System.out.print(tr.data + "\t");
		System.out.println();
		System.out.println( "Highest Common Factor of " + num1 + " and " + num2 + " is " + hcf);
	} }


