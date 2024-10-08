package com.dsa.stack;

import java.util.ArrayList;
import java.util.List;

public class FindMaxAreaRecBinaryMatrix {
    /**
     * Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
     * Example:
     *
     * Input :   0 1 1 1
     *           1 1 1 1
     *           1 1 1 1
     *           1 1 1 0
     *
     * Convert 2D array into 1D array. If value is 1, add it to the existing height otherwise height would be zero.
     * 1D array 1x4 - 0 1 1 0 - Calculate MAH for this 1D array
     *          2x4 - 1 2 2 1 - Calculate MAH for this 1D array
     *          3x4 - 2 3 3 2 - Calculate MAH for this 1D array
     *          4x4 - 3 4 0 0 - Calculate MAH for this 1D array
     *
     * Max of all calculated MAH would be the answer.
     */

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,0}
        };
        FindMaxAreaRecBinaryMatrix maxAreaRecBinaryMatrix = new FindMaxAreaRecBinaryMatrix();
       int maxArea = maxAreaRecBinaryMatrix.findMaxAreaRecBinaryMatrix(matrix);
        System.out.println(maxArea);
    }

    private int findMaxAreaRecBinaryMatrix(int[][] matrix) {
        FindMaxAreaOfHistogram findMaxAreaOfHistogram = new FindMaxAreaOfHistogram();
        int[] heights = new int[matrix[0].length];
        int maxArea = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] > 0){
                    heights[j] += matrix[i][j];
                }else{
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea,findMaxAreaOfHistogram.findMaxArea(heights));
        }
        return maxArea;
    }
}
