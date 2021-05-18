package com.geeks.array;

import java.util.HashSet;
import java.util.Set;

/*1. Check if it is not the highest element , set.contains(!arr[i]-1), then check for all the available higher
 * 	elements in set from this and increase the count variable.
 * */

public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		int arr[]= {0,3,7,2,5,8,4,6,0,1};
		count(arr);
	}
	
	public static void count(int arr[]) {
		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		int result = 0;
		for(int i:arr)
			set.add(i);
		
		for(int i=0;i<arr.length;i++) {
			count=0;
			if(!set.contains(arr[i]-1)) {
				int j = i;
				int tempVar = arr[j];
				while(set.contains(tempVar)) {
					j++;
					count++;
					tempVar++;
				}
				result = Math.max(count, result);
			}
		}
		System.out.println(result);
	}

}
