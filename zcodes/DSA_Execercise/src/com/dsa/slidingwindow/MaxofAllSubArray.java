package com.dsa.slidingwindow;

public class MaxofAllSubArray {

	// Find largest number from each sub-array.
	public static void main(String[] args) {
		int[] arr = {1,3,-2,5,9,1};
		int k = 3;
		int size = arr.length;
		int i = 0;
		int j = 0;
		int max = Integer.MIN_VALUE;
		
		while(j < size) {
			max = Math.max(max, arr[j]);
			if(j - i + 1 == k) {
				System.out.println("Maximum of subarray: " + max);
				if(arr[i] == max) {
					max = Integer.MIN_VALUE;
				}
				i++;
			}
			j++;
		}
				
	}
}
