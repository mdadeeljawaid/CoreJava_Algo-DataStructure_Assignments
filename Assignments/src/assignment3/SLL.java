package assignment3;

public class SLL {

	private ListNode head;

	private static class ListNode{
		private int data;
		private ListNode next;

		public ListNode(int data){
			this.data = data;
			this.next = null;
		}
	}

	public void display(){
		ListNode current = head;
		while(current != null){
			System.out.println(current.data + " -->> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public int length(){
		if(head == null){
			return 0;
		}
		int count = 0;
		ListNode current = head;
		while(current != null){
			count++;
			current = current.next;
		}
		return 0;
	}

	public void insertAtFirst(int value){
		ListNode node = new ListNode(value);
		node.next = head;
		head = node;
	}

	public void insert(int position, int value){
		ListNode node = new ListNode(value);
		if(position == 1)
		{
			node.next = head;
			head = node;
		}
		else{
			ListNode previous = head;
			int count = 1;
			while(count < position-1){
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = node;
			node.next = current;
		}
	}

	public void insertAtLast(int value){
		ListNode node = new ListNode(value);
		if(head == null){
			head = node;
			return;
		}
	}

	public static void main(String[] args) {
		SLL sll = new SLL();

		sll.insert(1, 3);
		sll.display();
	}
}
