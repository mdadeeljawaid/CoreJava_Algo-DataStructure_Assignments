package com.maj;

public class PriorityQ{
	private Comparable[] array;
	private int index;


	public PriorityQ() {
		array=new Comparable[5];
		index=0;
	}

	public void insert(Comparable item ) throws OverFlowException{
		if(index == array.length){
			throw new OverFlowException();}
		else {
			array[index] = item;
			index++;
			System.out.println("Adding element: "+item);
		}
	}

	public Comparable remove() throws UnderFlowException{
		if(index == 0){
			throw new UnderFlowException();}
		else {
			int maxIndex = 0;
			// find the index of the item with the highest priority 
			for (int i=1; i<index; i++) { 
				if (array[i].compareTo (array[maxIndex]) > 0) { 
					maxIndex = i; 
				} 
			} 

			Comparable result = array[maxIndex]; 
			System.out.println("removing: "+result);
			// move the last item into the empty slot 
			index--; 
			array[maxIndex] = array[index]; 
			return result;
		}
	}
}