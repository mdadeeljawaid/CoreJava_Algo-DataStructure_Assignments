package maj.graph.disjoint;

public class DisjointSet {
	SetNode head = null;

	public void addToSet(ItemNode data) {
		if(head == null) {
			head = new SetNode(data); 
			return;
		}
		SetNode t = new SetNode(data);
		t.link = head; 
		head = t;
	}
	
	//this method returns the reference of 'set' which contains vertex 'i'
	public ItemNode getTheSet(int i) {
		for(SetNode tr = head; true; tr=tr.link) {	//traverse in vertical
			for(ItemNode ti=tr.data; ti!=null; ti=ti.link) {	//traverse in horizontal			
				if(ti.data == i) {
					return tr.data;		//returning reference of first node
				}
			}					
		}
	}
	
	public void mergeAndAdd(ItemNode s1, ItemNode s2) {
		//remove both from list-set
		deleteTheSet(s1);
		deleteTheSet(s2);
		//append s2 set with s1
		ItemNode tr;
		for(tr=s1; tr.link !=null; tr=tr.link);	//put reference of first node of second set
		tr.link = s2;
		//add s1 to list-set
		addToSet(s1);
		}
	
	private void deleteTheSet(ItemNode s) {  // removal of node from SLL
		SetNode p,tr;
		for(p = null, tr = head; tr.data!=s && tr != null; p = tr, tr = tr.link);
		if(p == null) head = head.link;
		else p.link = tr.link;
	}
	
	public void showTheSet() {
		for(SetNode tr = head; tr != null; tr = tr.link) {			// traverse in vertical
			System.out.println("Set.....");
			for(ItemNode ti = tr.data; ti != null; ti = ti.link) {	// traverse in horizontal
				System.out.print(ti.data + ", ");
			}
			System.out.println("");
		}
	}
}
