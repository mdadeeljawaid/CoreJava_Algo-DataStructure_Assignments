package assignment3;

public class DLL_Application {

	public static void main(String[] args) {

		DLL dll = new DLL();
		System.out.println("Adding at Front");
		dll.addAtFront(10);
		dll.addAtFront(15);
		dll.addAtFront(16);
		dll.addAtFront(20);
		dll.display();
		System.out.println("\nAdding at Rear");
		dll.addAtRear(35);
		dll.display();
		System.out.println("\nRemoving from Front");
		dll.removeAtFront();
		dll.display();
		System.out.println("\nRemoving from Rear");
		dll.removeAtFront();
		dll.display();
		System.out.println("\nAfter Adding, Inserting at given location");
		dll.insertAtLocation(2, 26);
		dll.display();
		System.out.println("\nAfter Adding, Removing at given location");
		dll.removeAtLocation(3);
		dll.display();
	}

}
