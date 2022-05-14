package assignment8b;

/*b. BST:
i. Display BST in decreasing order.
ii. Display BST in level-by-level order.
iii. Complete Deletion by considering all the possibilities.*/

public class Main {
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(10);
		bst.insert(5);
		bst.insert(100);
		bst.insert(2);
		bst.insert(8);
		bst.insert(6);
		System.out.print( "\nBST in decreasing order: ");
		bst.show();
		System.out.print( "\nBST: level by level: ");
		bst.levelByLevelTraversal();
		System.out.print( "\nDeleting :- ");
		bst.delete(8);
		bst.show();
	}
}
