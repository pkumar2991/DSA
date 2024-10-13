package com.dsa.slidingwindow;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxofAllSubArray {

	// Find largest number from each sub-array.
	public static void main(String[] args) {
		int[] arr = {1,3,-2,5,9,4};
		int k = 3;
		int size = arr.length;
		int i = 0;
		int j = 0;

		Queue<Integer> queue = new ArrayDeque<>();

		while (j < size){
			if(queue.isEmpty()){
				queue.offer(arr[j]);
			}else if(queue.peek() < arr[j]){
				queue.clear();
				queue.offer(arr[j]);
			}else{
				queue.offer(arr[j]);
			}
			if(j-i+1 == k){
				System.out.println( queue.peek());
				if(queue.peek() == arr[i]){
					queue.poll();
				}
				i++;
			}
			j++;
		}

				
	}
}
