package com.maj;

import com.maj.exception.SpaceFullException;
import com.maj.exception.UnderFlowException;

public class MyList {

	private int[] array;
	private int noOfItem;

	public MyList() {
		noOfItem = 0;			//set to zero
		array = new int[5];		//default array size = 5(assumed)
	}

	public MyList(int size) {
		noOfItem = 0;			//set to zero
		array = new int[size];		//default array size = 5(assumed)

	}

	//check if storage has space
	public boolean isSpace() {
		/*if(noOfItem<array.length) 
		return true;
	else
		return false;
		 */
		return (noOfItem<array.length) ? true : false;
	}

	public void insertItemAtEnd(int item) throws SpaceFullException{
		if(isSpace()) {
			array[noOfItem++] = item;
		}
		else throw new SpaceFullException();	// raise our exception
	}

	private void swap(int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}

	public void bubbleSort () {
		for(int i = 0; i<array.length-1; i++) {
			for(int j = 0; i<array.length-1; j++) {
				if(array[j] > array[j+1]) {
					swap(j, j+1);
				}

			}
		}
	}

	public void selectionSort () {
		for(int i = 0; i<array.length-1; i++) {
			for(int j = i+1; j<array.length; j++) {
				if(array[i] > array[j]) {
					swap(j, j);
				}

			}
		}
	}

	public void quickSort() {
		//quickSortRecursion(0, array.length-1);
		quickSortNonRecursion();
	}

	private void quickSortRecursion(int lb, int ub) {
		int li, ri;
		int pivot;
		System.out.println("LB:"+lb+ " UB:"+ub);
		if(lb < ub) {
			System.out.println("Worked LB:"+lb+ " UB:"+ub);
			for(pivot = array[lb], li = lb + 1, ri = ub; li <= ri;) {
				while(li <  array.length && pivot >= array[li] ) li++;
				while(pivot < array[ri]) ri--;
				if(li < ri) swap(li,ri);
			}
			swap(lb,ri);
			quickSortRecursion(lb, ri-1);	// L11   =>>  lb, ri-1;  (Left)
			quickSortRecursion(ri+1,ub);	// L12   =>>  ri+1, ub;  (Right)

		}
	}	

	private void quickSortNonRecursion(){
		int li,ri;
		int pivot;
		//BOUND INFO is Pushed into the STACK

		Stack s = new Stack();
		s.push(new Bound(0,array.length-1));
		while(!(s.isStackEmpty()) ){	//stack is not empty
			Bound b = s.pop();
			for(pivot = array[b.lb], li = b.lb + 1, ri = b.ub;   li <= ri; ) {
				while(li <  array.length && pivot >= array[li] ) li++;
				while(pivot < array [ri]) ri--;
				if(li < ri) swap(li, ri);
			}
			swap(b.lb, ri);
			// now list will split.......
			if(ri+1 < b.ub){					//right  part ==>>    ri+1, ub	
				s.push(new Bound(ri+1, b.ub) );
			}
			if(b.lb < ri-1){					//left  part ==>>   lb,   ri-1	
				s.push(new Bound(b.lb, ri-1) );
			}	 
		}

	}

	public void insertionSort () {
		int j;
		for(int i = 0; i<array.length; i++) {	//i is indexing to sorted list
			int pick = array[i];
			for(j = i-1; j>=0 && pick < array[j]; j--) {	//j is indexing to unsorted list
				array[j+1] = array[j];
			}
			array[j+1] = pick;
		}
	}

	/* ********************ASSIGNMENT NO 5 QUESTION********************* */
	public void mergeSort() {
		int size,k;
		int lb1,ub1,i;	//first list
		int lb2,ub2,j;	//second list
		int []aux = new int[array.length];	//auxiliary array


		for(size = 1; size < array.length; size *= 2) {
			k=0;	
			lb1 = 0;	//
			while(lb1+size < array.length) {	// is L2 can be formed
				//ub1 = ((lb1 + size -1) < array.length) ? lb1 + size -1: array.length - 1; 
				lb2 = lb1 + size;
				ub1 = lb2 - 1;
				ub2 = ((lb2 + size -1) < array.length) ? lb2 + size -1: array.length - 1; 

				//merging process starts here........................................

				for(i=lb1, j=lb2; i<=ub1 && j<=ub2; k++) {
					aux[k] = ( array[i] <= array[j]) ? array[i++] : array[j++];
				}
				//Remaining items of L1 or L2 are copied
				for(;i<=ub1; k++) {
					aux[k] = array[i++];
				}
				for(;j<=ub2; k++) {
					aux[k] = array[j++];
				}
				//merging ends here...................................................

				lb1 = ub2 +1;	//now set LB1 to next list-set

			}

			//if single list is left out. then it has to be directly copied
			for(i = lb1; i < array.length; i++) {
				aux[i] = array[i];
			}

			/*for(; k < array.length; k++) {
			aux[k] = array[k];
			}
			 */

			//copy all items of AUX to array
			for(k=0; k < aux.length; k++) {
				array[k]= aux[k];
			}
		}	
	}

	private void makeMAXHeap(int noOfItem) {
		int pi = noOfItem / 2 - 1;	//set pi to the last parent-index reaching to
		while(pi>=0) {
			//find the larger child CH
			int ci = pi * 2 + 1;	//set to LC
			if(ci + 1 < noOfItem && array[ci] < array[ci+1]) ci++;

			//set MAX HEAP by comparing larger child CH and parent
			if(array[pi]<array[ci]) { 
				swap(pi,ci);
			}
			pi--;
		}
	}

	public void heapSort() {
		int noOfItem = array.length;
		while(noOfItem>1) {
			makeMAXHeap(noOfItem);
			show();
			swap(0,noOfItem-1);
			noOfItem--;
		}
	}	

	public void show(){
		System.out.println("List item");
		for(int i=0; i<noOfItem; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("");
	}

}	
