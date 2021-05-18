package com.interview;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {38, 27, 43, 3, 9, 82, 10,-1};
		quickSort(arr, 0, arr.length - 1);
		

			for (int i : arr)
				System.out.print(i + " ");

		}
	
	public static void quickSort(int[] arr, int start , int end) {
		if(start<end) {
			int pi = partition(arr,start,end);
			
			quickSort(arr, start, pi-1);
			quickSort(arr, pi+1, end);
		}
	}
	public static int partition(int[]arr, int start , int end) {
		
		int i = start-1, j = start;
		for(j=start;j<end;j++)
		if(arr[j]<arr[end]) {
			i++;
			swap(arr, i, j);
		}
		swap(arr, i+1, end);
		
		return i+1;
	}
	public static void swap(int arr[], int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
