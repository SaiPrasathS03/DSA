package sorting;

import java.util.Arrays;

public class SelectionSort {	// O(n^2)

	public static void main(String[] args) {
		int [] arr = {51,14,9,46,1,2};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	private static void selectionSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			int minimum=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[minimum]) {
					minimum=j;
				}
			}
			int temp=arr[i];
			arr[i] = arr[minimum];
			arr[minimum] = temp;
		}
	}
}
