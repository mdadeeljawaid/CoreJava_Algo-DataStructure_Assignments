package assignment1;

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
	
	public void insertItemAfterAnotherItem(int item, int afterItem) throws SpaceFullException {
		if (isSpace()) {
			boolean flag = false;
			// loop to check another item is present or not
			for (int i = 0; i < noOfItem; i++) {
				// if matched
				if (array[i] == afterItem) {
					// loop to shift all elements from last by 1 position
					// j > i + 1 because we want to add element after element at ith position
					for (int j = noOfItem; j > i + 1; j--) {
						array[j] = array[j - 1];
					}
					// assign item to [i +1] position
					array[i + 1] = item;
					// increment number of items
					noOfItem++;
					flag = true;
					return;
				}
			}
			if (flag == false) {
				System.out.println(afterItem + " is unavailable in array");
			}

		} else {
			throw new SpaceFullException();
		}
	}
	
	public void insertItemBeforeAnotherItem(int item, int beforeItem) throws SpaceFullException {
		if (isSpace()) {
			boolean flag = false;
			// loop to check another item is present or not
			for (int i = 0; i < noOfItem; i++) {
				// if matched
				if (array[i] == beforeItem) {
					// loop to shift all elements from last by 1 position
					// j > i - 1 because we want to add element before element at ith position
					for (int j = noOfItem; j > i - 1; j--) {
						array[j] = array[j - 1];
					}
					// assign item to [i +1] position
					array[i] = item;
					// increment number of items
					noOfItem++;
					flag = true;
					return;
				}
			}
			if (flag == false) {
				System.out.println(beforeItem + " is unavailable in array");
			}

		} else {
			throw new SpaceFullException();
		}
	}
		
	public void insertItemAtSpecificPosition(int item, int position) throws SpaceFullException {
		if (isSpace()) {
			for (int i = noOfItem; i > position; i--) {
				array[i] = array[i - 1];
			}
			array[position] = item;
			noOfItem++;

		} else {
			throw new SpaceFullException();
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
	
	public void deleteItemAtSpecificPosition(int position) throws UnderFlowException {
		if(noOfItem==0) {
			for (int i = position - 1; i < noOfItem - 1; i++) {
				array[i] = array[i + 1];
			}
			noOfItem--;

		} else {
			throw new UnderFlowException();
		}
	}		
		public void searchItem(int item) throws UnderFlowException {
			if(noOfItem==0) {
				boolean flag = false;
				int i;
				for (i = 0; i < noOfItem; i++) {
					if (array[i] == item) {
						flag = true;
						break;
					}
				}
				if (flag == true) {
					System.out.println(item + " is available at index " + i);
				} else {
					System.out.println(item + " is unavailable in array");
				}
				System.out.println();
			} else {
				throw new UnderFlowException();
			}
		}
		
		public void searchPositionOfItem(int position) throws UnderFlowException {
			if(noOfItem==0) {
				boolean flag = false;
				int item = 0;
				for (int i = 0; i < noOfItem; i++) {
					if (i == position) {
						item = array[position];
						flag = true;
						break;
					}
				}
				if (flag == true) {
					System.out.println(item + " is at position " + position);
				} else {
					System.out.println("Nothing at index " + position);
				}
				System.out.println();

			} else {
				throw new UnderFlowException();
			}
		}
		
		public void emptyEntireList() throws InterruptedException {
			for (int i = 0; i < noOfItem; i++) {
				array[i] = 0;
			}
			for (int j = 0; j <= 100; j++) {
				System.out.print("Clearing array elements " + j + "%");
				//thread.sleep(20);
			}
			System.out.println("\nDone.\n");

			noOfItem = 0;
		} 
	
		public void show(){
			for(int i=0; i<noOfItem; i++) {
				System.out.println(array[i]);
			}
		}
	}
	