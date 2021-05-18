package com.geeks.array;

import java.util.HashMap;
import java.util.Map;

public class ElementAppearMoreThanKTimes {

	public static void main(String[] args) {
		int arr[]={3, 1, 2, 2, 1, 2, 3, 3} ;
		int k = 4;
		findEle(arr, k);
	}
	public static void findEle(int arr[],int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int val = arr.length/k;
		int count=0;
		for(int i:arr) 
			map.put(i, map.getOrDefault(i, 0)+1);
		
		for(Map.Entry<Integer, Integer> m:map.entrySet()) {
			if(m.getValue()>val) {
				count++;
			}
		}
		System.out.println(count);
	}

}
