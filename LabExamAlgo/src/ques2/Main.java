package ques2;

public class Main {

	public static void main(String[] args) {

		SLL l1 = new SLL();
		l1.append(100);
		l1.append(200);
		l1.append(300);
		l1.insertAtFirst(10);
		l1.insertAtFirst(5);
		System.out.println("SLL");
		l1.show();

		int dd =l1.deleteAtFirst();
		System.out.println("Deleted data = " + dd);

		System.out.println("SLL");
		l1.show();
	}

}
