package com.dsa.backtracking;

import java.util.*;

public class PermutationOfStringUsingPassByRef {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcefsrtym");
        List<String> list = new ArrayList<>();
        findPermutations(sb,0,list);
        System.out.println(list);
        System.out.println("Size:"+list.size());
    }

    private static void findPermutations(StringBuilder sb, int index, List<String> list) {
        if(index == sb.length()){
            list.add(sb.toString());
            return;
        }
        Set<Character> processedSet = new HashSet<>();
        for (int i = index; i < sb.length(); i++) {
            if(!processedSet.contains(sb.charAt(i))){
                swap(sb,index, i);
                findPermutations(sb,index+1,list);
                swap(sb,index,i);
                processedSet.add(sb.charAt(i));
            }
        }
    }

    private static void swap(StringBuilder sb,int index1, int index2) {
        if(sb != null && sb.charAt(index1) != sb.charAt(index2)){
            char temp = sb.charAt(index2);
            sb.setCharAt(index2,sb.charAt(index1));
            sb.setCharAt(index1,temp);
        }
    }
}
