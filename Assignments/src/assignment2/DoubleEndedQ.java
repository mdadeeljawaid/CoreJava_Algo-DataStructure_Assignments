package assignment2;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class DoubleEndedQ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch;
		ArrayDeque<Integer> ad=new ArrayDeque<>();
		do {
			System.out.println("Testing of DoubleEndedQ");	
			System.out.println("Main Menu");
			System.out.println("Insert at front end: Press 1");
			System.out.println("Insert at rear end: Press 2");
			System.out.println("Delete at front end: Press 3");
			System.out.println("Delete at rear end: Press 4");
			System.out.println("To Display: Press 5");
			System.out.println("To Exit: Press 6");
			System.out.println("------------------------------------------------------");
			int x,a,b;
			System.out.println("Enter the operation code : ");
			x=sc.nextInt();

			switch(x){
			case 1:
				System.out.println("Enter an element to be added at Front End: ");
				b=sc.nextInt();
				ad.addFirst(b);
				break;
			case 2:
				System.out.println("Enter an element to be added at Rear End: ");
				a=sc.nextInt();
				ad.addLast(a);
				break;
			case 3:
				if(ad.isEmpty())
					System.out.println("The Queue is Empty!");
				else 
					ad.pollFirst();
				break;
			case 4:
				if(ad.isEmpty())
					System.out.println("The Queue is Empty!");
				else 
					ad.pollLast();
				break;
			case 5:
				Iterator itr=ad.iterator();
				while(itr.hasNext()){
					System.out.print(" "+itr.next());
				}
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("You have entered an Invalid Input");
			}
			System.out.println("\nDo you want to continue[y/n]: ");
			ch=sc.next().charAt(0);
		}while(ch=='y');

		sc.close();
	}
}
