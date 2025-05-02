package sll;

public class LLMain {
	public static void main(String[] args) {
		LL ll = new LL();
		ll.insertFirst(20);
		ll.insertFirst(10);
		ll.insertFirst(30);
		ll.insertFirst(90);
		ll.insertLast(17);
		ll.insert(1, 0);
		ll.printList();
		int size = ll.size;
		System.out.println(size);
		ll.deleteLast();
		ll.printList();
		size = ll.size;
		System.out.println(size);
		ll.delete(2);
		ll.printList();
//		ll.insertLast(170);
//		ll.printList();
		
		
		size = ll.size;
		System.out.println(size);
	}
}