package com.interview;

import java.util.Arrays;

public class MoveZeroToLeft {

	public static void main(String[] args) {
		int arr[] = {1, 10, 20, 0, 59, 63, 0, 88,0};
		move(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	/**
	 * 1. Take 2 pointer readIndex and writeIndex
	 * 2. if arr[readIndex]!=0 then write arr[writeIndex]=arr[readIndex] and decrement read and write pointer
	 * 		also if arr[readIndex]==0 then decrement readIndex
	 * 3. at last while writeindex !=0 put zero in it.
	 * */
	
	public static void move(int[]arr) {
		if(arr.length<1)
			return;
		int readIndex = arr.length-1;
		int writeIndex = arr.length-1;
		
		while(readIndex>=0) {
			if(arr[readIndex]!=0) {
				arr[writeIndex]=arr[readIndex];
				writeIndex--;
			}
			readIndex--;
		}
		while(writeIndex>=0) {
			arr[writeIndex]=0;
			writeIndex--;
		}
	}

}
