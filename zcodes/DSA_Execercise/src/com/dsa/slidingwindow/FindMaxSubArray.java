package com.dsa.slidingwindow;

public class FindMaxSubArray {
	
	// Find maximum of sub-array of size 3.

	public static void main(String[] args) {
		int k = 3; // window size
		int arr[] = { 12, 5, 3, 2, 20 };
		int size = arr.length;
		int max = 0, sum = 0, i = 0, j = 0;

		while (j < size) {
			sum += arr[j];
			if (j - i + 1 == k) {
				max = Math.max(max, sum);
				sum -= arr[i];
				i++;
			}
			j++;
		}
		
		System.out.println("Max subarray value : " + max );
	}
}
