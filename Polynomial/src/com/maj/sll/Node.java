package com.maj.sll;

import com.maj.poly.PolyTerm;

public class Node {
	
	public PolyTerm data;
	public Node link;
	
	public Node(PolyTerm data) {
		this.data = data;
		link = null;
		
		
	}

}
