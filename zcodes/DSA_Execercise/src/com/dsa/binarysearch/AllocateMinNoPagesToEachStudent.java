package com.dsa.binarysearch;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AllocateMinNoPagesToEachStudent {

    /**
     * Say, there are four books given having page count 10,20,30,40 respectively. There are two students.
     * Cases:
     * 1. Each student should not be overwhelmed with books to read.
     * 2. Each student must get at least a book to read.
     * 3. Books can be assigned in a sequence only. Random book allocation is NOT allowed.
     *
     * Question: Find a way to allocate books to each student provided student has to read minimum number of pages.
     */

    public static void main(String[] args) {
        int[] book = {10,20,30,40};
        int totalStudents = 3;
        int minPages = findMinNoPages(book,totalStudents);
        System.out.println(minPages);

    }
    static int findMinNoPages(int[] arr, int totalStudents){
        int start = findMax(arr);
        int end = getTotalPages(arr);
        int res = -1;
        if(arr.length <= totalStudents) return -1;

        while (start < end){
            int mid = start + ( end - start ) / 2;
            if(validAllocation(arr,mid,totalStudents)){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return res;

    }
    static int getTotalPages(int[] arr){
       return Arrays.stream(arr).sum();
    }

    static int findMax(int[] arr){
        return Arrays.stream(arr).max().getAsInt();
    }

    static boolean validAllocation(int[] arr, int maxPages, int totalStudent){
        int sum = 0;
        int studentCount = 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > maxPages){
                sum = arr[i];
                studentCount++;
            }
            if(studentCount > totalStudent){
                return false;
            }
        }
        return true;
    }
}
