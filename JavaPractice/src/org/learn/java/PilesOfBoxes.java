package org.learn.java;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PilesOfBoxes {

	public static void main(String[] args) {
		int[] arr = {4,5,5,2,4}; // 2 4 4 5 5 
		int n = 5;
		System.out.println(minSteps(arr));
	}
	
	private static int minSteps(int[] piles) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
	
		for(int p : piles) {
			map.put(p, map.getOrDefault(p, 0)+1);
		}
		Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getKey() - a.getKey());
		maxHeap.addAll(map.entrySet());
		while(maxHeap.size() > 1) {
			Map.Entry<Integer, Integer> entry1 = maxHeap.poll();
			Map.Entry<Integer, Integer> entry2 = maxHeap.poll();
			res += entry1.getValue();
			entry2.setValue(entry2.getValue() + entry1.getValue());
			maxHeap.offer(entry2);
		}
		return res;
	}

}
