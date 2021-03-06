package org.learn.java;

import java.util.PriorityQueue;

public class Solution {
	public static void main(String[] args) {
		int nums[] = { 20, 7, 10 };
		int k = 4;
		find(nums, k);
	}

	public static void find(int arr[], int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
		for (int i : arr)
			maxHeap.add(i);
		while (maxHeap.size() > 0 && k > 0) {
			int maxElement = maxHeap.poll();
			double ele = Math.ceil(maxElement / 2.0);
			maxHeap.add((int) ele);
			k--;
		}
		int sum = 0;
		for (int i : maxHeap)
			sum += i;
		System.out.println(sum);
	}
}
