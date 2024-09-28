package com.dsa.binarysearch;

public class FindEltInRowAndColWiseSortedArray {

    /**
     * Find an element in the given two-dimensional array.
     * Each dimension has sorted elements.
     *
     */

    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {11, 23, 31, 43},
                {15, 25, 35, 45},
                {19, 33, 39, 49}
        };
        SearchElt searchElt = findElt(arr, 35);
        System.out.println(searchElt);
    }

    static SearchElt findElt(int[][] arr, int key) {
        int i = 0;
        int j = arr[i].length - 1;

        while (i < arr.length && j >= 0) {
            if (arr[i][j] == key) {
                return new SearchElt(i, j);
            } else if (arr[i][j] < key) {
                i++;
            } else {
                j--;
            }
        }
        return new SearchElt(-1, -1);
    }

    private static class SearchElt {
        private int i = -1;
        private int j = -1;

        public SearchElt(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "SearchElt{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

}
