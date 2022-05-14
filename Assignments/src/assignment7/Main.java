package assignment7;

/*a. ADD two integer numbers (Number may be very large).
Hints:
First DLL contains first no. Each node contains single digit of
number
Second DLL contains factors of second no.
Third DLL will contain answer no.*/

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		DLL l1 = new DLL();
		Scanner sc = new Scanner(System.in);
		System.out.print( "Enter first number: ");
		String num1=sc.next();
		System.out.println();
		System.out.print( "Enter second number: ");
		String num2=sc.next();
		System.out.println();
		int len1=num1.length();
		int len2=num2.length();
		while(len1!=len2) {
			if(len1>len2) {
				num2="0"+num2;
				len2=num2.length();
			}
			else {
				num1="0"+num1;
				len1=num1.length();
			}
		}
		char[] digitOne=num1.toCharArray();
		char[] digitTwo=num2.toCharArray();
		for (int i=num1.length()-1;i>=0;i--) {
			int a = Integer.parseInt(String.valueOf(digitOne[i]));
			l1.firstDigit(a);
		}
		for (int i=num2.length()-1;i>=0;i--) {
			int a = Integer.parseInt(String.valueOf(digitTwo[i]));
			l1.secondDigit(a);
		}
		l1.showFirstNumber();
		System.out.print( " + " );
		l1.showSecondNumber();
		System.out.print( " = " );
		l1.length = num2.length();
		l1.add();
		l1.showResult();
		sc.close();
	}
}