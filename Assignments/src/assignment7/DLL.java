package assignment7;

public class DLL {
	Node head1, head2, head3;
	Node tail1, tail2, tail3;
	public int length;
	public DLL() {
		head1 = null;
		tail1 = null;
		head2 = null;
		tail2 = null;
		head3 = null;
		tail3 = null;
	}
	public void firstDigit(int data) {
		Node node = new Node(data);
		if (head1 == null) {
			tail1 = node;
			head1 = node;
		}
		else {
			head1.previousLink = node;
			node.nextLink = head1;
			head1 = node;
		}
	}
	public void secondDigit(int data) {
		Node node = new Node(data);
		if (head2 == null) {
			tail2 = node;
			head2 = node;
		}
		else {
			head2.previousLink = node;
			node.nextLink = head2;
			head2 = node;
		}
	}
	public void add() {
		Node tr1 = tail1;
		Node tr2 = tail2;
		for(int i = 0; i < length; i++) {
			int d = 0;
			int c = tr1.data + tr2.data;
			if(c > 9){d = c % 10;
			resultantNumber(d);
			tr2.previousLink.data = tr2.previousLink.data + 1;
			}
			else
				resultantNumber(c);
			tr1 = tr1.previousLink;
			tr2 = tr2.previousLink;
		}
	}
	private void resultantNumber(int data) {
		Node node = new Node(data);
		if (head3 == null) {
			tail3 = node;
			head3 = node;
		}
		else {
			head3.previousLink = node;
			node.nextLink = head3;
			head3 = node;
		}
	}
	public void showFirstNumber() {
		Node tr = head1;
		while (tr != null) {
			System.out.print(tr.data);
			tr = tr.nextLink;
		}
	}
	public void showSecondNumber() {
		Node tr = head2;
		while (tr != null) {
			System.out.print(tr.data);
			tr = tr.nextLink;
		}
	}
	public void showResult() {
		Node tr = head3;
		while (tr != null) {
			System.out.print(tr.data);
			tr = tr.nextLink;
		}
	}
}