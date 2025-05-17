package sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {21,1,2,41,53};
		qs(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static void qs(int[] arr,int l,int h) {
		if(l<h) {
			int pIndex = partition(arr,l,h);
			qs(arr,l,pIndex-1);
			qs(arr,pIndex+1,h);
		}
	}
	public static int partition(int[] arr, int l, int h) {
		int pivot = arr[l];
		int i=l,j=h;
		while(i<j) {
			while(arr[i]<=pivot && i<h) i++;
			while(arr[j]>pivot && j>l) j--;
			if(i<j) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		int t = arr[l];
		arr[l] = arr[j];
		arr[j] = t;
		return j;
	}
}
