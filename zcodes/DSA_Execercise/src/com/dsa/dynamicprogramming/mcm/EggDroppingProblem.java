package com.dsa.dynamicprogramming.mcm;

import java.util.Arrays;

public class EggDroppingProblem {
    /**
     * Problem statement: You are given N floor and K eggs. You have to minimize the number of times you have to drop the eggs to find the critical floor where critical floor means the floor beyond which eggs start to break. Assumptions of the problem:
     *
     * If egg breaks at ith floor then it also breaks at all greater floors.
     * If egg does not break at ith floor then it does not break at all lower floors.
     * Unbroken egg can be used again.
     * Note: You have to find minimum trials required to find the critical floor not the critical floor.
     *
     * Example:
     * Input:
     *     4
     *     2
     *
     *     Output:
     *     Number of trials when number of eggs is 2 and number of floors is 4: 3
     */
    static int[][] dpTable = new int[11][50];
    public static void main(String[] args) {
        int floor = 4;
        int egg = 2;
        populateDpTable();
        int minNoOfTrials = findMinNoOfTrialsOptimized(egg,floor);
        System.out.println(minNoOfTrials);
    }
    static void populateDpTable(){
        for (int i = 0; i < dpTable.length; i++) {
            Arrays.fill(dpTable[i],-1);
        }
    };
    private static int findMinNoOfTrials(int egg, int floor) {
        if(floor == 0 || floor == 1){
            return floor;
        }
        if(egg == 1){
            return floor;
        }
        if(dpTable[egg][floor] != -1){
            return dpTable[egg][floor];
        }
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= floor; k++) {
            int temp = 1 + Math.max(findMinNoOfTrials(egg-1,k-1),findMinNoOfTrials(egg,floor-k));
            min = Math.min(min,temp);
        }
        dpTable[egg][floor] = min;
        return min;
    }
    private static int findMinNoOfTrialsOptimized(int egg, int floor) {
        if(floor == 0 || floor == 1){
            return floor;
        }
        if(egg == 1){
            return floor;
        }
        if(dpTable[egg][floor] != -1){
            return dpTable[egg][floor];
        }
        int min = Integer.MAX_VALUE;
        int low = -1;
        int high = -1;
        for (int k = 1; k <= floor; k++) {
            if(dpTable[egg-1][k-1] != -1){
                low = dpTable[egg-1][k-1];
            }else{
                low = findMinNoOfTrials(egg-1,k-1);
                dpTable[egg-1][k-1] = low;
            }
            if(dpTable[egg][floor-k] != -1){
                high = dpTable[egg][floor-k];
            }else{
                high = findMinNoOfTrials(egg,floor-k);
                dpTable[egg][floor-k] = high;
            }

            int temp = 1 + Math.max(low,high);
            min = Math.min(min,temp);
        }
        dpTable[egg][floor] = min;
        return min;
    }
}
