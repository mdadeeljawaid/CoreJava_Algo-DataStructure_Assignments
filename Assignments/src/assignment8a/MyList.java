package assignment8a;

public class MyList {
	private int []array;
	private int noOfItem;
	public MyList() {
		noOfItem = 0;
		array = new int[5];
	}
	public MyList(int size) {
		noOfItem = 0;
		array = new int[size];
	}
	public boolean isSpace(){
		return (noOfItem<array.length) ? true : false;
	}
	public void insertItemAtEnd(int item) throws SpaceFullException{
		if(isSpace()) {
			array[noOfItem++] = item;
		}
		else throw new SpaceFullException();
	}
	private void swap(int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	private void makeMAXHeap(int noOfItem) {
		int pi = noOfItem / 2 - 1; // set pi to the last parent-index reaching to
		while(pi>=0){
			//find the larger CH
			int ci = pi * 2 + 1; // set to LC...............
			if(ci + 1 < noOfItem && array[ci] < array[ci+1] ) ci++;
			//set MAX-HEAP by comparing larger CH & parent...............
			if(array[pi]<array[ci]) {
				swap(pi, ci);
			}
			pi--;
		}
	}
	public void heapSort(){
		int noOfItem = array.length;
		while(noOfItem>0) {
			makeMAXHeap(noOfItem);
			swap(0, noOfItem-1);
			noOfItem--;
		}
	}
	public void show(){
		System.out.println("List Item.......");
		for(int i=0; i<noOfItem; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("");
	}
}
