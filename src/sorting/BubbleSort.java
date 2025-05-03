package sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {	//O(n^2)
		int [] arr = {51,14,9,46,1};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		int n=arr.length;
		int didSwap=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					didSwap=1;
				}
			}
			if(didSwap==0) break;
		}
	}

}
