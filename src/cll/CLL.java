package cll;

public class CLL {
	Node head;
	Node tail;
	private class Node{
		int val;
		Node next;
		
		public Node(int val) {
			this.val=val;
		}
	}
	
	public void insert(int val) {
		Node node = new Node(val);
		if(head==null) {
			head=node;
			tail=node;
			return;
		}
		tail.next=node;
		node.next=head;
		tail=node;
	}
	
	public void delete(int val) {
		Node  temp = head;
		if(temp.val==val) {
			head=head.next;
			tail.next=head;
			return;
		}
		
		while(temp.next.val!=val) {
//			temp.next=temp.next.next;
			temp=temp.next;
		}
		temp.next=temp.next.next;
	}
	
	public void display() {
		Node temp=head;
		if(head!=null) {
			do {
				System.out.print(temp.val+"->");
				temp=temp.next;
			}while(temp!=head);
		}
	}
}
