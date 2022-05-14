package com.maj;

public class BinarySearchTree {
	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int data) {
		//1.if BST is empty 
		if(root == null) { root = new Node(data); return; }
		//2.BST is not empty
		Node tr = root;


		//apply BST rule (left child is smaller than right child
		while(true) {
			if(data <= tr.data) {
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
			inorder(r.lc);
			System.out.println(r.data+ " , " + r.ht);
			inorder(r.rc);
		}
	}

	public void show() {
		System.out.println("\nBST --> ");
		inorder(root);
	}

	public void delete(int data) {
		//1.if BST is empty 
		if(root == null) { System.out.println("BST empty"); return; }

		//2.BST is not empty
		Node tr = root;
		Node p = null;
		while(tr != null) {
			if(data == tr.data) {
				doDeletion(p,tr);	//data found then do deletion
				return;
			}
			p = tr;
			tr = (data < tr.data) ? tr.lc : tr.rc;	//traverse using BST rule (left child is smaller than right child)
		}
		System.out.println("Data not found in BST");		
	}

	private void doDeletion(Node p, Node tr) {
		//1.Node to be removed has only LC
		if(tr.lc != null && tr.rc == null) {
			if(p == null) {			//i.Node to be removed (tr) is root
				root = tr.lc;
				tr.lc = null;
			}
			else if(p.lc == tr) {	//ii.Node to be removed (tr) is LC of its parent (p)
				p.lc = tr.lc;
			}
			else {					//iii.Node to be removed (tr) is RC of its parent (p)
				p.rc = tr.lc;
			}
			return;
		}

		//2.Node to be removed has only RC
		if(tr.lc == null && tr.rc != null) {
			if(p == null) {			//i.Node to be removed (tr) is root
				root = tr.rc;
				tr.lc = null;
			}
			else if(p.lc == tr) {	//ii.Node to be removed (tr) is LC of its parent (p)
				p.lc = tr.rc;
			}
			else {					//iii.Node to be removed (tr) is RC of its parent (p)
				p.rc = tr.rc;
			}	
			return;
		}
	}
	
	//............22.11.21.............
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

