package com.maj;

public class Main {

	public static void main(String[] args) {
		SimpleQ s = new SimpleQ(5);
		try {
			
	        s.enqueue(6);
	        s.dequeue();
	        s.enqueue(3);
	        s.enqueue(99);
	        s.enqueue(56);
	        s.dequeue();
	        s.enqueue(43);
	        s.dequeue();
	        s.enqueue(89);
	        s.enqueue(77);
	        s.dequeue();
	        s.enqueue(32);
	        s.enqueue(232);
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
		
		/*DoubleEndedQ dq = new DoubleEndedQ();
		int item;

		try {
			dq.insert_1(10);
			dq.insert_2(20);
			item = dq.delete_1();
			//System.out.println("Deleted Item = "+item);
			System.out.println("Deleted Item1 = "+dq.delete_1());
			item = dq.delete_2();
			//System.out.println("Deleted Item = "+item);
			System.out.println("Deleted Item2 = "+dq.delete_2());

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
		}*/
		
		/*CircularQ c = new CircularQ();
		int item;

		try {
			c.enqueue(10);
			c.enqueue(20);
			item = c.dequeue();
			System.out.println("Deleted Item = "+item);
			System.out.println("Deleted Item = "+s.dequeue());
			item = c.dequeue();
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
		}*/
	

		/*PriorityQ pq = new PriorityQ();
		try {
			pq.insert(34);
			pq.insert(23);
			pq.insert(5);
			pq.insert(87);
			pq.insert(32);
			pq.remove();
			pq.remove();
			pq.remove();
			pq.remove();
			pq.remove();
		}
		catch(OverFlowException e) {
			System.out.println(e);
		}
		catch(UnderFlowException e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Over");
		}*/
	}
}

