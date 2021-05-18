package com.geeks.array;

public class MissingNumber {

	public static void main(String[] args) {
		int arr[]={1, 2, 3, 5};
		inPlaceSort(arr);
	}
	// 1 2 3 5
	// 1 2 3 4 5 
	public static void inPlaceSort(int arr[]) {
		int x1=arr[0];
		int x2=1;
		for(int i=1;i<arr.length;i++) {
			x1^=arr[i];
		}
		for(int i=2;i<=arr.length+1;i++) {
			x2^=i;
		}
		System.out.println(x1^x2);
	}
	

}
