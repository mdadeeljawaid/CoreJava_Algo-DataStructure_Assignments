package com.maj;

import com.maj.exception.SpaceFullException;
import com.maj.exception.UnderFlowException;

public class Main {		//Object is the Parent Class

	public static void main(String[] args) {
		System.out.println("Hello");
		MyList l1 = new MyList();
		
		//MyList l2 = new MyList(10);
		
		try {
			l1.insertItemAtEnd(10);
			System.out.println("1 insert");
			l1.insertItemAtEnd(20);
			System.out.println("2 insert");
			
			l1.insertItemAtEnd(30);	//(1)If SpaceFullException object is raised
									//(2)No further statements of this 'try' block will execute
									//(3)The execution flow will get into the particular catch
			
			System.out.println("3 insert");		//this will not execute
			
			l1.insertItemAtBegining(100);
			System.out.println("0 insert");
			System.out.println("All Items of  LIST DS");
			l1.show();
			
			l1.deleteItemAtEnd(30); 
			System.out.println("3 delete");
			System.out.println("All Items of  LIST DS");
			l1.show();
			
			//l1.deleteItemAtBegining(30); 
			//System.out.println("3 delete");
			//System.out.println("All Items of  LIST DS");
			//l1.show();
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
