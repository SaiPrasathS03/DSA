package dll;

public class DLL {
	Node head;
	
	private class Node{
		int val;
		Node next;
		Node prev;
		
		public Node(int val) {
			this.val=val;
		}
		public Node(int val,Node next,Node prev) {
			this.val=val;
			this.next=next;
			this.prev=prev;
		}
	}
	
	public void insertFirst(int val) {
		Node node = new Node(val);
		
		node.next=head;
		node.prev=null;
		if(head!=null) head.prev=node;
		head=node;
	}
	
	public void display() {
		Node temp=head;
		Node last=null;
		while(temp!=null) {
			System.out.print(temp.val+"->");
			last=temp;
			temp=temp.next;
		}
		System.out.print("END");
		System.out.println();
//		
		while(last!=null) {
			System.out.print(last.val+"->");
			last=last.prev;
		}
		System.out.print("START");
		System.out.println();
	}
	
	public void insertLast(int val) {
		Node node = new Node(val);
		if(head==null) {
			insertFirst(val);
			return;
		}
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=node;
		node.prev=temp;
		node.next=null;
		
	}
	
	public void insert(int index,int val) {
		if(index==0) {
			insertFirst(val);
		}
		Node temp=head;
		for(int i=0;i<index-1;i++) {
			temp=temp.next;
		}
		Node node = new Node(val);
		node.next=temp.next;
		temp.next=node;
		if(node.next!=null) node.next.prev=node;
		node.prev=temp;
	}
	
	public void deleteFirst() {
		if(head==null) return;
//		System.out.println(head.prev+" "+head.val+" "+head.next);
		head=head.next;
		head.prev=null;
//		System.out.println(head.prev+" "+head.val+" "+head.next);
	}
	
	public void deleteLast() {
		Node temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		temp.next=null;
	}
	
	public void deletePos(int index) {
		if(index==0) {
			deleteFirst();
			return;
		}
		Node temp=head;
		for(int i=0;i<index-1;i++) {
			temp=temp.next;
		}
		temp.next.next.prev=temp;
		temp.next=temp.next.next;
		
	}
	
	
}
