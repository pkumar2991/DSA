package com.dsa.dynamicprogramming.tree;

public class MaxPathSumLeafToLeafNode {
    /**
     * Maximum path sum from leaf to leaf
     *
     * If a binary tree is given, how to find Maximum path sum between two leaves of binary tree.
     *
     * All should be numbers
     * The maximum sum path may or may not go through root.
     * For example, in the following binary tree, the maximum sum is 27(3 + 6 + 9 + 0 – 1 + 10). Expected time complexity is O(n).
     *
     *   -15
     *  /  \
     *        5    6
     *       / \  / \
     *     -8  1  3  9
     *     / \       \
     *    2   6       0
     *        / \
     *       4  -1
     *   /
     * 10
     */

    static int sum = 0;
    public static void main(String[] args) {
        Node root = populateTree();
        findPathSum(root);
        System.out.println("Maximum path sum:"+sum);
    }

    private static int findPathSum(Node root) {
        if(root == null)
            return 0;

        int left = findPathSum(root.left);
        int right = findPathSum(root.right);

        int temp = Math.max(left,right)+root.data;
        if(root.left == null && root.right == null){
            temp = Math.max(temp,root.data);
        }
        int sumAtCurrentNode = left + right + root.data;
        sum = Math.max(sum,sumAtCurrentNode);
        return temp;
    }
    private static Node populateTree() {
        Node root = new Node(-15);

        root.left = new Node(9);
        root.right = new Node(-20);
        root.right.left = new Node(15);

        root.right.right = new Node(-10);
        return root;
    }
}
