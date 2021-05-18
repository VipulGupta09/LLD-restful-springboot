package com.interview;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = {38, 27, 43, 3, 9, 82, 10,-1};
		sort(arr);
		
		for (int i : arr)
			System.out.print(i + " ");

	}
	
	public static void sort(int []arr) {
		int n = arr.length;
		for(int i=1;i<n;i++) {
			int key = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
	}

}
