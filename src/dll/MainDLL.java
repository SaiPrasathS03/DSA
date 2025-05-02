package dll;

public class MainDLL {

	public static void main(String[] args) {
		DLL dll = new DLL();
		
		dll.insertLast(50);
		dll.insertFirst(10);
		dll.insertFirst(20);
		dll.insertFirst(30);
		dll.insertFirst(40);
		dll.insert(2, 0);
		dll.insert(6, 1);
		dll.display();
		dll.deletePos(2);
		dll.display();
	}

}
