package cll;

public class MainCLL {

	public static void main(String[] args) {
		CLL cll = new CLL();
		
		cll.insert(10);
		cll.insert(20);
		cll.insert(30);
		cll.insert(40);
		cll.display();
		System.out.println();
		cll.delete(40);
		cll.display();
		
	}
}
