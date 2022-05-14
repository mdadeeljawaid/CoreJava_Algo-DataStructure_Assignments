package com.maj.poly;

import java.util.Scanner;

import com.maj.sll.Node;
import com.maj.sll.SLL;

public class PolynomialEquation {
	private SLL sl;
	
	public PolynomialEquation() {
		sl = new SLL();
	}
	
	public void addPolyTerm(PolyTerm t) {
		sl.append(t);
		
	}
	
	public void showEquation() {
		PolyTerm d;
		for (Node tr = sl.head; tr != null; tr = tr.link) {
			d = tr.data;
			String ps = (d.coef>=0) ? "+" : "";
			if(d.var.equals(""))
				System.out.print(ps + "" +d.coef);
			else if(d.exp == 1)
			System.out.print(ps + "" + d.coef + "" + d.var + "" );
			else
				System.out.print(ps + "" + d.coef + "" + d.var + "" + d.exp);
			
		}
		System.out.println("");
	}
	
	public PolynomialEquation addEquation(PolynomialEquation e2) {
		PolynomialEquation e3 = new PolynomialEquation();
		
		PolyTerm et1, et2;
		Node tr1 = sl.head;
		Node tr2 = e2.sl.head;
		
		while (tr1 != null && tr2 != null) {
			et1 = tr1.data;
			et2 = tr2.data;
			
			//add similar term of both equation
			if(et1.var.equals(et2.var) && et1.exp == et2.exp) {
				e3.addPolyTerm (new PolyTerm(et1.coef + et2.coef, et1.var, et2.exp));
				tr1 = tr1.link;
				tr2 = tr1.link;
			}
			
			else if(et1.var.equals(et2.var) && et1.exp > et2.exp) {
				e3.addPolyTerm (new PolyTerm(et1));
				tr1 = tr1.link;
			}
			
			else if(et1.var.equals(et2.var) && et1.exp < et2.exp) {
				e3.addPolyTerm (new PolyTerm(et2));
				tr2 = tr2.link;
			}
	
		
		}	
		
		//takes care of left over term of either equations
		while (tr1 != null) {
			e3.addPolyTerm (new PolyTerm(tr1.data));
			tr1 = tr1.link;
	}
		while (tr2 != null) {
			e3.addPolyTerm (new PolyTerm(tr2.data));
			tr2 = tr2.link;
	}
		return e3;
	}
	
	
	//e1.addPolyTerm(new PolyTerm(10, "X", 4));
			/*public void getEquation() {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter equation :");
				String eq = sc.nextLine();
				
				char []arr = eq.toCharArray();
				// 10X4 - 20X2 + 8X - 30 ---> This is the 1st equation
				
				
				
				for(int i=0; i<arr.length; i++) {
					if(arr[i]>='0' && arr[i]<='9') {
						
					}
				System.out.println(eq);
						
			}*/
	
}

