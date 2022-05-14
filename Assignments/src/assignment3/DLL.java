package assignment3;

public class DLL {

	private int data;
	private int size;
	public DLL previous;
	public DLL next;
	private DLL head;


	public DLL(int data){
		previous = null;
		this.data =data;
		next = null;
	}

	public DLL(DLL previous, int data, DLL next){
		this.previous = previous;
		this.data = data;
		this.next = next;
	}

	public int  Data() {
		return data;
	}

	public DLL(){
		head = null;
		size = 0;
	}

	public void addAtFront(int data) {						//Inserting data from Front End
		if(head == null)
			head = new DLL(null,data,head);
		else
		{
			DLL link = new DLL(null,data,head);
			head.previous = link;
			head = link;
		}
		size++;
	}

	public void addAtRear(int data) {				//Inserting data from Rear End
		if(head == null)
			head = new DLL(null,data,null);
		else
		{
			DLL current = head;
			while(current.next != null)
			{
				current = current.next;
			}
			DLL link = new DLL(current, data, null);
			current.next = link;
		}
		size++;
	}

	public void removeAtFront() {					//Removing data from Front End
		if(head == null) return;
		head = head.next;
		head.previous = null;
		size--;
	}

	public void removeAtRear() {					//Removing data from Rear End
		if(head == null) return;
		if(head.next == null)
		{
			head = null;
			size--;
			return;
		}
		DLL current = head;
		while(current.next.next != null)
		{
			current = current.next;
		}
		current.next = null;
		size--;
	}

	public void insertAtLocation(int index, int data) {			//Inserting data at given location
		if(head == null) return;
		if(index < 1 || index > size) return;
		DLL current = head;
		int i = 1;
		while(i < index){
			current = current.next;
			i++;
		}
		if(current.previous == null) {
			DLL link = new DLL(null, data, current);
			current.previous = link;
			head = link;
		}
		else{
			DLL link = new DLL(current.previous, data, current);
			current.previous.next = link;
			current.previous = link;
		}
		size++;
	}

	public void removeAtLocation(int index) {					//Removing data at given location
		if(head == null) return;
		if(index < 1 || index > size) return;
		DLL current = head;
		int i = 1;

		while(i < index){
			current = current.next;
			i++;
		}

		if(current.next == null){
			current.previous.next = null;
		}
		else if(current.previous == null){
			current = current.next;
			current.previous = null;
			head = current;
		}
		else{
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
		size--;
	}

	public int size(){
		return size;
	}

	public void display() {						//Display method
		DLL current = head;
		while(current != null){
			System.out.print( current.Data()+" -->> ");
			current = current.next;
		}
		System.out.println();
	}

	public boolean isEmpty(){
		return head == null;
	}
}