package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FindMaxSizeOfSubArrNonRepeatingChars {

	public static void main(String[] args) {
		String input = "abcccqwertyuio";
		int i = 0;
		int j = 0;
		int max = 0;

		Map<Character, Integer> map = new HashMap<>();

		while (j < input.length()) {
			char ch = input.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			if (map.size() == j - i + 1) {
				max = Math.max(max, map.size());
			}

			while (map.size() < j - i + 1) {
				char ch1 = input.charAt(i);
				map.computeIfPresent(ch1, (key, val) -> {
					val -= 1;
					if(val == 0) {
						map.remove(key);
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
