package assignment6;

import java.util.NoSuchElementException;

public class MenuDrivenDQ {

	private Node front, rear;
	private int size;

	public MenuDrivenDQ()
	{
		front = null;
		rear = null;
		size = 0;
	}    
	
	public boolean isEmpty()
	{
		return front == null;
	}    
	
	public int getSize()
	{
		return size;
	}
	
	public void clear()
	{
		front = null;
		rear = null;
		size = 0;
	}
	
	public void insertAtFront(int val)		//insert an element at begining
	{
		Node nptr = new Node(val, null);    
		size++ ;    
		if (front == null) 
		{
			front = nptr;
			rear = front;
		}
		else 
		{
			nptr.setLink(front);
			front = nptr;
		}
	}
	
	public void insertAtRear(int val)		//insert an element at end
	{
		Node nptr = new Node(val,null);    
		size++ ;    
		if (rear == null) 
		{
			rear = nptr;
			front = rear;
		}
		else 
		{
			rear.setLink(nptr);
			rear = nptr;
		}
	}    
	
	public int removeAtFront()		//remove front element from the queue
	{
		if (isEmpty() )
			throw new NoSuchElementException("Underflow Exception");
		Node ptr = front;
		front = ptr.getLink();

		if (front == null)
			rear = null;
		size-- ;

		return ptr.getData();
	}
	
	public int removeAtRear()		//remove rear element from the queue
	{
		if (isEmpty() )
			throw new NoSuchElementException("Underflow Exception");
		int ele = rear.getData();
		Node s = front;
		Node t = front;
		while (s != rear)
		{
			t = s;
			s = s.getLink();
		}
		rear = t;
		rear.setLink(null);
		size --;

		return ele;
	}        
	
	public int peekAtFront()		//check the front element of the queue
	{
		if (isEmpty() )
			throw new NoSuchElementException("Underflow Exception");
		return front.getData();
	}
	
	public int peekAtRear()			//check the rear element of the queue
	{
		if (isEmpty() )
			throw new NoSuchElementException("Underflow Exception");
		return rear.getData();
	}    
	
	public void display()			//display the status of the queue
	{
		System.out.print("\nDequeue = ");
		if (size == 0)
		{
			System.out.print("Empty\n");
			return ;
		}
		Node ptr = front;
		while (ptr != rear.getLink() )
		{
			System.out.print(ptr.getData()+" ");
			ptr = ptr.getLink();
		}
		System.out.println();        
	}
}