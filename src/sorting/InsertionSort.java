package sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int [] arr = {51,14,99,46,1};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			int j=i;
			while(j>0 && arr[j-1]>arr[j]) {
				int temp=arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--;
			}
		}
	}

}
