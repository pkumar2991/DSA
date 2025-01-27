package com.dsa.dynamicprogramming.tree;

public class MaxPathSum {
    /**
     * Given a non-empty binary tree, find the maximum path sum.
     *
     * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
     * along the parent-child connections. The path must contain at least one node and does not need to go through
     * the root.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * Output: 6
     * Example 2:
     *
     * Input: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * Output: 42
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

        int temp = Math.max(Math.max(left,right)+root.data,root.data);
        int sumAtCurrentNode = left + right + root.data;
        sum = Math.max(sum,sumAtCurrentNode);
        return temp;
    }

    private static Node populateTree() {
        Node root = new Node(-10);

        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);

        root.right.right = new Node(7);
        return root;
    }
}
