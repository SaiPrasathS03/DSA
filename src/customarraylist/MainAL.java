package customarraylist;

public class MainAL {

	public static void main(String[] args) {
		AL list = new AL();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		list.display();
		System.out.println("size: "+list.size());
		System.out.println(list.get(1));
		System.out.println(list.remove(11));
		list.display();
		System.out.println("size: "+list.size());
	}
}
