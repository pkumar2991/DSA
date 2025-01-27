package com.dsa.dynamicprogramming.lcs;

public class FindMinInsertDelete {
    /**
     * Minimum number of deletions and insertions to transform one string into another
     * Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to
     * remove/delete and insert minimum number of characters from/in str1 so as to transform it
     * into str2. It could be possible that the same character needs to be removed/deleted from one
     * point of str1 and inserted to some another point.
     * Example:
     * Input : str1 = "geeksforgeeks", str2 = "geeks"
     * Output : Minimum Deletion = 8
     *          Minimum Insertion = 0
     */

    public static void main(String[] args) {
        String s1 = "Manisha";
        String s2 = "Prabhakar";
        int deleteCount = s1.length() - FindLcsWithDP.findLcsCount(s1,s2);
        int insertCount = s2.length() - FindLcsWithDP.findLcsCount(s1,s2);
        System.out.printf("Delete Count:%d Insert Count:%d",deleteCount,insertCount);
    }
}
