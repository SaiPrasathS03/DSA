package sorting;
import java.util.*;
class MergeSort {
    public static void main(String[] args) {
        int[] arr = {21,12,45,1,55,11};    
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int low,int high){
        if(low==high) return;
        int mid=(low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public static void merge(int[] arr,int low,int mid,int high){
        int[] temp = new int[arr.length];
        int left=low,right=mid+1,index=0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[index++]=arr[left];
                left++;
            }
            else{
                temp[index++]=arr[right];
                right++;
            }
        }
        while(left<=mid) temp[index++]=arr[left++];
        while(right<=high) temp[index++]=arr[right++];
        for(int i=low;i<=high;i++){
            arr[i] = temp[i-low];
        }
    }
}