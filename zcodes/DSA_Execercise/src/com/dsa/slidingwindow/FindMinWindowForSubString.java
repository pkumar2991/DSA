package com.dsa.slidingwindow;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMinWindowForSubString {
    // Find the minimum window size for a substring from a given string which must have all
    // characters of the substring.
    // In the window, characters of the given substring may not be continuous.

    public static void main(String[] args) {
        String str = "totawwebctyyctab";
        findMinWindowSize(str);
        findMinWindowString(str);
    }

    static void findMinWindowString(String str){
        String searchString = "abc";
        int i = 0;
        int j = 0;
        int start = -1;
        int end = -1;
        int size = str.length();
        int min = Integer.MAX_VALUE;
        Map<Character, Long> map = searchString.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int count = map.size();

        while (j < size) {
            Character ch = str.charAt(j);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }
            while (count == 0){
                Character ch1 = str.charAt(i);
                if(map.containsKey(ch1)){
                    map.put(ch1,map.get(ch1) + 1);
                    if (map.get(ch1) > 0) {
                        count++;
                        if(min > (j-i+1)){
                            min = j - i + 1;
                            start = i;
                            end = j;
                        }

                    }
                }
                i++;
            }
            j++;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = start; k <= end; k++) {
            sb.append(str.charAt(k));
        }
        System.out.println("Min Window SubString:" + sb.toString());
    }
    static void findMinWindowSize(String str){
        String searchString = "abc";
        int i = 0;
        int j = 0;
        int size = str.length();
        int min = Integer.MAX_VALUE;
        Map<Character, Long> map = searchString.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int count = map.size();

        while (j < size) {
            Character ch = str.charAt(j);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }
            while (count == 0){
                Character ch1 = str.charAt(i);
                if(map.containsKey(ch1)){
                    map.put(ch1,map.get(ch1) + 1);
                    if (map.get(ch1) > 0) {
                        count++;
                        min = Math.min(min,j-i+1);
                    }
                }
                i++;
            }
            j++;
        }

        System.out.println("Min:" + min);
    }
}
