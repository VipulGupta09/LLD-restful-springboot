package com.geeks.array;

public class FindDuplicate {

	public static void main(String[] args) {
		int arr[]={1, 2, 3, 4 ,3};
		findDuplicate(arr);
	}
	public static void findDuplicate(int []arr) {
		for(int i=0;i<arr.length;i++) {
			int temp = Math.abs(arr[i]);
			if(arr[temp]>0) {
				arr[temp]=-arr[temp];
			}
			else {
				System.out.print(temp+" ");
			}
		}
	}

}
