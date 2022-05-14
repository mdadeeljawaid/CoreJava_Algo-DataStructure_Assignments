package assignment8b;

public class BST {
	private Node root;
	public BST() {
		root = null;
	}
	public void insert(int data) {
		//(1) BST is empty
		if(root == null) { root = new Node(data); return; }
		//(2) BST is not empty
		Node tr = root;
		// Applying BST Rule
		while(true) {
			if(data <= tr.data ) {
				if(tr.lc == null) { tr.lc = new Node(data); return; }
				tr = tr.lc;
			}
			else {
				if(tr.rc == null) { tr.rc = new Node(data); return; }
				tr = tr.rc;
			}
		}
	}
	private void inorder(Node r) {
		if(r != null) {
			inorder(r.rc);
			System.out.println(r.data + ", " + r.ht);
			inorder(r.lc);
		}
	}
	public void show() {
		System.out.println("\nBST --> ");
		inorder(root);
	}
	public void levelByLevelTraversal() {
		Queue_Level ql = new Queue_Level();
		Node tr =root;
		ql.enqueue(root);
		while (ql.isEmpty() != true) {
			tr=ql.dequeue();
			System.out.println(tr.data + ", " + tr.ht);
			//Node tr = root;
			if(tr.lc != null) ql.enqueue(tr.lc);
			if(tr.rc != null) ql.enqueue(tr.rc);
		}
	}
	public void delete(int data) {
		//(1) BST is empty
		if(root == null) { System.out.println("BST Empty"); return; }
		//(2) BST is not empty
		Node tr = root;
		Node p = null;
		while(tr !=null) {
			if(data == tr.data ){
				doDeletion(p,tr);  //Data found. Do deletion
				return;
			}
			p = tr;
			tr = (data < tr.data ) ? tr.lc : tr.rc; 	// Traverse using BST Rule
		}
		System.out.println("Data not found in BST");
	}
	private void doDeletion(Node p, Node tr){
		//(I) Node to be removed has only 'LC'
		if(tr.lc != null && tr.rc == null) {
			if(p == null)		 //(a) Node to be removed ('tr') is 'ROOT'
			{
				root = tr.lc;
				tr.lc = null;
			}
			else if(p.lc == tr) 	//(b) Node to be removed ('tr') is 'LC' of its parent ('p')
			{
				p.lc = tr.lc;
			}
			else 				//(c) Node to be removed ('tr') is 'RC' of its parent ('p')
			{
				p.rc = tr.lc;
			}
			return;
		}
		//(II) Node to be removed has only 'RC'
		if(tr.lc == null && tr.rc != null) {
			if(p == null) 		//(a) Node to be removed ('tr') is 'ROOT'
			{
				root = tr.rc;
				tr.rc = null;
			}
			else if(p.lc == tr) 	//(b) Node to be removed ('tr') is 'LC' of its parent ('p')
			{
				p.lc = tr.rc;
			}
			else 			//(c) Node to be removed ('tr') is 'RC' of its parent ('p')
			{
				p.rc = tr.rc;
			}
			return;
		}
		if(tr.lc == null && tr.rc == null) {
			p.lc=null;
			p.rc=null;
			return;
		}
		if(tr.lc != null && tr.rc != null) {
			Node IS=null;
			IS=tr.rc;
			while(IS.lc != null) {
				IS=IS.lc;
			}
			tr.data =IS.data;
			//System.out.println("\n 40 = "+p.lc.rc.lc);//p.lc.rc.lc=null;
			//System.out.println("\n 40 = "+IS);
			//p.lc.rc.lc=null;
			IS=null;
			return;
		}
	}
	public void eachNodeHeight() {
		height(root);
	}
	private int height(Node r) {
		if(r!=null) {
			int h1 = height(r.lc);
			int h2 = height(r.rc);
			int h = ((h1 > h2) ? h1 : h2 );
			r.ht = h;
			return h+1;
		}
		else return 0;
	}
}
