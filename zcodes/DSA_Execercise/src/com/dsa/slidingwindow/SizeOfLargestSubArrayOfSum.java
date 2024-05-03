package com.dsa.slidingwindow;

public class SizeOfLargestSubArrayOfSum {
	
	// Find the sub-array size having sum k
	// Solution is valid for positive numbers only

	public static void main(String[] args) {
		int[] arr = {4,1,1,1,1,3,5};
		int k = 8;
		int size = arr.length;
		int i = 0;
		int j = 0;
		int max = 0;
		int sum = 0;
		
		while (j < size) {
			sum += arr[j];
			if(sum == k) {
				max = Math.max(max, j - i +1);
			}
			
			if(sum > k) {
				while(sum > k) {
					sum -= arr[i]; // valid for +v numbers only
					i++;
				}
			}
			j++;
		}
		
		System.out.println("Size of largest sub-array of maximum sum k is : " + max);
	}
}
// TODO - Write code considering that input values can be negative