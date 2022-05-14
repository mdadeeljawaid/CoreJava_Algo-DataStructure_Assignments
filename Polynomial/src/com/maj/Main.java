package com.maj;

import com.maj.poly.PolyTerm;
import com.maj.poly.PolynomialEquation;

public class Main {

	public static void main(String[] args) {
		
		PolynomialEquation e1 = new PolynomialEquation();
		
		// 10X4 - 20X2 + 8X - 30 ---> This is the 1st equation
		e1.addPolyTerm(new PolyTerm(10, "X", 4));
		e1.addPolyTerm(new PolyTerm(-20, "X", 2));
		e1.addPolyTerm(new PolyTerm(8, "X"));
		e1.addPolyTerm(new PolyTerm(-30));
		
		System.out.println("Equation 1 : ");
		e1.showEquation();
		
		PolynomialEquation e2 = new PolynomialEquation();
		
		// 5X4 - 3X - 10 ---> This is the 2nd equation
		e2.addPolyTerm(new PolyTerm(5, "X", 4));
		e2.addPolyTerm(new PolyTerm(-3, "X"));
		e2.addPolyTerm(new PolyTerm(-10));
		
		System.out.println("\nEquation 2 : ");
		e2.showEquation();
		
		PolynomialEquation e3 = e1.addEquation(e2);	//e3=e1+e2
		
		System.out.println("\nEquation 3 : ");
		e3.showEquation();
		
		
		//PolynomialEquation e1 = new PolynomialEquation();
		
		// 10X4 - 20X2 + 8X - 30 ---> This is the 1st equation
		//e1.addPolyTerm(new PolyTerm(10, "X", 4));
		//e1.getEquation();
		System.out.println("\nEnd of our program");
		
	}

}
