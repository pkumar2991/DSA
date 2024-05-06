package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FindMaxSizeOfSubArrWithKUniqueCharacters {

	// Find the max size of sub-array with K unique characters which may repeat

	public static void main(String[] args) {
		String input = "abccccccccccefefef";

		int i = 0;
		int j = 0;
		int max = 0;
		int size = input.length();
		int k = 3; // window size
		
		Map<Character, Integer> map = new HashMap<>();
		
		while(j < size) {
			char ch = input.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			
			if(map.size() == k) {
				int sum = map.values().stream().mapToInt(Integer::new).sum();
				max = Math.max(max, sum);
			}
			while(map.size() > k) {
				char ch1 = input.charAt(i);
				map.computeIfPresent(ch1, (key,val)->{
					val = val - 1;
					if(val == 0) {
						map.remove(ch1);
					}
					return val;
				});
				i++;
			}
			
			j++;
		}
		System.out.println("Result: " + max);
	}
}
