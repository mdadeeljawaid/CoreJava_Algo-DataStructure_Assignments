package assignment5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print( "Enter a number: " );
		int num = sc.nextInt();
		FactorOfNumber factor = new FactorOfNumber(num);
		factor.findFactors();
		System.out.println();
		System.out.println( "List of factors of " +num+ " is : ");
		factor.display();
		sc.close();
	}
}
