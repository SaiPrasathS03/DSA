package customarraylist;

public class AL {
	
	int capacity;
	Object[] arr;
	int size;
	
	public AL(){
		capacity=10;
		arr = new Object[capacity];
		size=0;
	}
	
	public AL(int capacity) {
		this.capacity=capacity;
		arr=new Object[capacity];
		size=0;
	}
	
	public void add(int val) {
		checkCapacity();
		arr[size]=val;
		size++;
	}
	
	public void checkCapacity() {
		if(size>=(0.75*capacity)) {
			capacity*=2;
			Object[] newArr = new Object[capacity];
			for(int i=0;i<size;i++) {
				newArr[i]=arr[i];
			}
			arr=newArr;
		}
	}
	
	public void display() {
		System.out.print("[");
		for(int i=0;i<size-1;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println(arr[size-1]+"]");
		
	}
	
	public Object get(int index) {
		if(index>=size) throw new ArrayIndexOutOfBoundsException(index+" is out of bound");
		return arr[index];
	}
	
	public Object remove(int index) {
		
		if(index<0 || index>=size) throw new ArrayIndexOutOfBoundsException(index+" is out of bound");
		int removed=(int) arr[index];
		for(int i=index;i<size-1;i++) {
			arr[i]=arr[i+1];
		}
		arr[size-1]=null;
		size--;
		return removed;
	}
	
	public int size() {
		return size;
	}
	

}
