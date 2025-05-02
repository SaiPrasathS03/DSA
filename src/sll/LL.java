package sll;

public class LL {
	private Node head;
	private Node tail;
	public int size;
	
	public LL() {
		size=0;
	}
	private class Node{
		private int val;
		private Node next;
		
		public Node(int val) {
			this.val=val;
		}
		public Node(int val,Node next) {
			this.val=val;
			this.next=next;
		}
	}
	public void insertFirst(int val) {
		Node node=new Node(val);
		node.next=head;
		head=node;
		if(tail==null) {
			tail=head;
		}
		size++;
	}
	
	public void insertLast(int val) {
		Node node = new Node(val);
		size++;
		if(tail==null) {
			insertFirst(val);
			return;
		}
		
		tail.next=node;
		tail=node;
		
	}
	
	public void insert(int index,int val) {
		
		if(index<0 || index>size) return;
		size++;
		if(index==0) {
			insertFirst(val);
			return;
		}
		if(index==size) {
			insertLast(val);
			return;
		}
		Node temp=get(index-1);
		Node node = new Node(val,temp.next);
		temp.next=node;
	}
	
	public void deleteFirst() {
		int val=head.val;
		head=head.next;
		if(head==null) {
			tail=null;
		}
		System.out.println(val);
		size--;
	}
	
	public void deleteLast() {
		if(size<=1) deleteFirst();
		
		Node temp=get(size-2);
		System.out.println(temp.next.val);
		tail=temp;
		tail.next=null;
		size--;
	}
	
	public void delete(int index) {
		if(index<0 || index>size) return;
		size--;
		if(index==0) {
			deleteFirst();
			return;
		}
		if(index==size) {
			deleteLast();
			return;
		}
		Node temp=get(index-1);
		temp.next=temp.next.next;
		
	}
	
	public Node get(int index) {
		Node temp=head;
		for(int i=0;i<index;i++) {
			temp=temp.next;
		}
		return temp;
	}
	
	public void insertRec(int val,int index) {
		head=insertRec(val,index,head);
	}
	
	private Node insertRec(int val, int index, Node node) {
		if(index==0) {
			Node temp=new Node(val,node);
			size++;
			return temp;
		}
		node.next=insertRec(val,index-1,node.next);
		return node;
	}

	public Node find(int val) {
		Node temp=head;
		while(temp!=null) {
			if(temp.val==val) return temp;
			temp=temp.next;
		}
		return null;
	}
	
	public void printList() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.val+"->");
			temp=temp.next;
		}
		
		System.out.println("null");
	}
}