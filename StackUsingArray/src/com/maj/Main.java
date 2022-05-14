package com.maj;

public class Main {

	public static void main(String[] args) {
		MyStack s = new MyStack();
		int item;
		
		try {
			s.push(10);
			s.push(20);
			item = s.pop();
			System.out.println("Poped Item = "+item);
			System.out.println("Poped Item = "+s.pop());
			item = s.pop();
			System.out.println("Success");
		}
			catch(OverFlowException e) {
				System.out.println(e);
			}
			catch(UnderFlowException e) {
				System.out.println(e);
		}
			finally {
				System.out.println("Over");
		}
	}

}
