package com.maj;

public class Main {

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(10);
		bst.insert(5);
		bst.insert(100);
		bst.insert(2);
		bst.insert(8);
		bst.insert(6);
		bst.show();
		
		bst.eachNodeHeight();
		System.out.println("\nTree with height");
		bst.show();
		
		//bst.delete(5);
		//bst.show();
		
		System.out.println("\nTree ends");

	}

}
