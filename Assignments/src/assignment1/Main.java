package assignment1;

public class Main {		//Object is the Parent Class

	public static void main(String[] args) {
		System.out.println("Hello");
		MyList l1 = new MyList();
		
		//MyList l2 = new MyList(10);
		
		try {
			l1.insertItemAtEnd(10);
			System.out.println("1st item inserted at End");
			l1.insertItemAtEnd(20);
			System.out.println("2nd item inserted at End");
			
			l1.insertItemAtEnd(30);	//(1)If SpaceFullException object is raised
									//(2)No further statements of this 'try' block will execute
									//(3)The execution flow will get into the particular catch
			
			System.out.println("3rd Item inserted at End");		//this will not execute
			l1.show();
			
			l1.insertItemAtBegining(100);
			System.out.println("1st item inserted at Begining");
			System.out.println("All Items of  LIST DS");
			l1.show();
			
			// l1.insertItemAfterAnotherItem(200, 200);
			l1.insertItemAfterAnotherItem(200, 100);
			System.out.println("1st item inserted after another item");
			l1.show();
			
			l1.insertItemBeforeAnotherItem(300, 10);
			System.out.println("1st item inserted before another item");
			l1.show();
			
			l1.insertItemAtEnd(67);
			System.out.println("4th item inserted at End");
			l1.show();
			l1.insertItemAtEnd(45);
			System.out.println("5th item inserted at End");
			l1.show();
			l1.insertItemAtEnd(80);
			System.out.println("6th item inserted at End");
			l1.show();
			
			l1.insertItemAtSpecificPosition(400, 3);
			System.out.println("1st item inserted at specific position");
			l1.show();
			
			//l1.deleteItemAtEnd(30); 
			//System.out.println("3rd item deleted at end");
			//l1.show();
			
			//l1.deleteItemAtBegining(30); 
			//System.out.println("3 delete");
			//System.out.println("All Items of  LIST DS");
			//l1.show();
			
			//l1.deleteItemAtSpecificPosition(5);
			//System.out.println("1 item deleted at position 5 or index 4.");
			//l1.show();

			System.out.println("Searching item 20");
			l1.searchItem(20);
			l1.show();

			System.out.println("Searching item at position 3");
			l1.searchPositionOfItem(3);
			l1.show();

			//l1.emptyEntireList();
			//l1.show();
			
			System.out.println("All Items of LIST DS");
			l1.show();
		}
	
		catch(SpaceFullException e) {
			System.out.println(e);
		}
		
		catch(UnderFlowException e) {
			System.out.println(e);
	}
		finally {
		
		System.out.println("This is end of the program");
		}
	}
}
