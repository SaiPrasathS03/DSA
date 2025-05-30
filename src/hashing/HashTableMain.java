package hashing;

import java.util.LinkedList;

public class HashTableMain {
	public static void main(String[] args) {
		Hashing h = new Hashing();
		h.insert(0);
		h.insert(1);
		h.insert(10);
		h.insert(33);
		h.insert(122);
		h.insert(24);
		h.insert(119);
		h.insert(55);
		h.insert(96);
		h.insert(888);
		h.insert(87);
		h.insert(777);
		h.display();
	}
}

class Hashing{
	final int size = 10;
	LinkedList<Integer>[] hashTable;
	
	public Hashing() {
		hashTable = new LinkedList[size];
		for(int i=0;i<size;i++) {
			hashTable[i] = new LinkedList<>();
		}
	}
	private int hash(int num) {
		return num%size;
	}
	public void insert(int num) {
		int ind = hash(num);
		hashTable[ind].add(num);
	}
	public void remove(int num) {
		int ind = hash(num);
		hashTable[ind].remove(num);
	}
	
	public void display() {
		for(int i=0;i<size;i++) {
			System.out.print("Bucket"+i+"->");
			for(Integer num:hashTable[i]) {
				System.out.print(num+"->");
			}
			System.out.println("null");
		}
	}
}
