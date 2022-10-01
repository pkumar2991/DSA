package com.notes;

public class Algorithms {

    /*Moore's Voting Algorithm*/
    int findMajorityCandidate(int[] arr) {
        if (arr.length == 0) return -1;
        else if (arr.length == 1) {
            return arr[0];
        } else {
            /*Find the eligible majority Candidate*/
            int count = 1;
            int candidate = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (candidate == arr[i]) {
                    count++;
                } else {
                    count--;
                }
                if (count == 0) {
                    candidate = arr[i];
                    count++;
                }
            }
            /*Check if it has majority*/
            count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (candidate == arr[i]) {
                    count++;
                }
            }
            if (count >= (arr.length / 2)) {
                return candidate;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 5, 3, 3};
        Algorithms algorithms = new Algorithms();
        System.out.println(algorithms.findMajorityCandidate(arr));
    }
}
