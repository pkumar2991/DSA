package com.dsa.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindFirstNegativeInSubArray {
	
	// Find first negative number from every sub-array.
	
	public static void main(String[] args) {
		int arr[] = {1,-2,-3,11,-7,5};
		int size = arr.length;
		int k = 3, i = 0, j = 0;
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		while(j < size) {
			if(arr[j] < 0) {
				dq.offer(arr[j]);
			}
			if(j - i + 1 == k) {
				if(dq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(dq.peek());					
				}
				if(arr[i] < 0) {
					dq.poll();
				}
				i++;
			}
			j++;
		}
		
	}
}
