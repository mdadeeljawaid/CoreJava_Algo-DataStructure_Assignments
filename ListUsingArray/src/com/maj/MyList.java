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
	
	public void insertItemAtEnd(int item) throws SpaceFullException 
	{
		if(isSpace()) {
			// store item at noOfItem location
						array[noOfItem] = item;
						// update number of items
						noOfItem++;
		}
		else throw new SpaceFullException();	//raise our exception
	}
	
	public void insertItemAtBegining(int item) throws SpaceFullException{
		if(isSpace()) {
			// shifting all items.............
			for(int i = noOfItem; i > 0; i--) {
				array[i] = array[i-1];
			}
			// store item at 0th index of array
			array[0] = item;
			// update number of items
			noOfItem++;
		}
		else throw new SpaceFullException();		// raise our exception
	}
	
	public void show(){
		for(int i=0; i<noOfItem; i++) {
			System.out.println(array[i]);
		}
	}
	
	
	public int deleteItemAtEnd(int item) throws UnderFlowException
	{
		if(noOfItem==0) {
			throw new UnderFlowException();
		}
		else{
			item = array[noOfItem--];
			return item;
		}	
	}	
	
	public int deleteItemAtBegining(int item) throws UnderFlowException
	{
		if(noOfItem==0){
			throw new UnderFlowException();
		}
		else{
			item = array[0];
			//shifting all items
			for (int i=0; i<noOfItem; i++) {
				array[i] = array[i+1];
			}
			noOfItem--;
			return item;
		}
}	
	
}