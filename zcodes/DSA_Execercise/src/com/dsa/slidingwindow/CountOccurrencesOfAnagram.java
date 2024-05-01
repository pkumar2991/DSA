package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagram {

	public static void main(String[] args) {
		String pattern = "for";
		String searchString = "forrfo";
		
		int j = 0;
		int i = 0;
		int k = pattern.length();
		int size = searchString.length();
		int count = 0;
		int anagram = 0;
		
		// Find the count of each letter in the pattern
		
		Map<Character,Integer> map = new HashMap<>();
		
		char[] searchStrArr= searchString.toCharArray();
		
		pattern.chars().forEach(c -> {
			char ch = (char)c;
			map.merge(ch, 1, Integer::sum);
		});
		count = map.size();
		System.out.println(map);
		
		while(j < size) {
			if(map.containsKey(searchStrArr[j])) {
				map.put(searchStrArr[j], map.get(searchStrArr[j]) - 1);
				if(map.get(searchStrArr[j]) == 0) {
					count--;
				}
			}
			
			if(j - i + 1 == k) {
				if(count == 0) {
					anagram++;
				}
				if(map.get(searchStrArr[i]) == 0)
					count++;
				map.put(searchStrArr[i], map.get(searchStrArr[i]) + 1);
				i++;
			}
			
			j++;
		}
		
		System.out.println(anagram++);
	}
}
