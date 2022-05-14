package com.maj;

import com.maj.exception.SpaceFullException;

public class Main {		//Object is the Parent Class

	public static void main(String[] args) {
		//System.out.println("Hello");

		MyList l1 = new MyList(11);

		try {
			l1.insertItemAtEnd(8);
			l1.insertItemAtEnd(900);
			l1.insertItemAtEnd(78);	
			l1.insertItemAtEnd(90);	
			l1.insertItemAtEnd(34);	
			l1.insertItemAtEnd(7);	
			l1.insertItemAtEnd(2);
			l1.insertItemAtEnd(8);
			l1.insertItemAtEnd(3445);
			l1.insertItemAtEnd(8);
			l1.insertItemAtEnd(200);
			l1.show();
			//l1.bubbleSort();
			//l1.selectionSort();
			//l1.quickSort();
			//l1.insertionSort();
			//l1.mergeSort();
			l1.heapSort();
			l1.show();
		}
		catch(SpaceFullException e) {
			System.out.println(e);
		}
		System.out.println("This is end of the program");
	}
}
