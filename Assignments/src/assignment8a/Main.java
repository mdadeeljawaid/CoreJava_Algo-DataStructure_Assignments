package assignment8a;

/*a. Modify MAXHEAP method to create MAX-HEAP completely.*/

public class Main {
	public static void main(String[] args) {
		MyList l1 = new MyList(10);
		try {
			l1.insertItemAtEnd(8);
			l1.insertItemAtEnd(900);
			l1.insertItemAtEnd(78);
			l1.insertItemAtEnd(90);
			l1.insertItemAtEnd(34);
			l1.insertItemAtEnd(7);
			l1.insertItemAtEnd(2);
			l1.insertItemAtEnd(35);
			l1.insertItemAtEnd(5);
			l1.insertItemAtEnd(40);
			l1.show();
			l1.heapSort();
			l1.show();
		}
		catch(SpaceFullException e) {
			System.out.println(e);
		}
	}
}