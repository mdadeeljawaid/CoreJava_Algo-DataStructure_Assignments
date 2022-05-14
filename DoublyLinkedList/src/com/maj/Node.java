package com.maj;

public class Node {
	public Node prev;
	public int data; 
	public Node next;
	
	public Node(int data) {
		this.data=data;
		prev = next = null;
	}
	
}