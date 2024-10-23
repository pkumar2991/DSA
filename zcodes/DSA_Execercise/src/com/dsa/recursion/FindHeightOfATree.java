package com.dsa.recursion;

public class FindHeightOfATree {

    public static void main(String[] args) {
        TreeNode root = buildTree();
        System.out.println(findHeight(root));
    }

    private static TreeNode buildTree() {
        TreeNode fifthNode = new TreeNode(null, null, 5);
        TreeNode fourthNode = new TreeNode(null, fifthNode, 2);
        TreeNode thirdNode = new TreeNode(null, null, 1);
        TreeNode secondNode = new TreeNode(thirdNode, fourthNode, 12);

        TreeNode three = new TreeNode(null, null, 3);
        TreeNode four = new TreeNode(null, three, 4);
        TreeNode fifteen = new TreeNode(null, four, 15);
        TreeNode eleven = new TreeNode(null, fifteen, 11);


        TreeNode root = new TreeNode(secondNode, eleven, 10);
        return root;
    }

    private static int findHeight(TreeNode root) {
        if (root == null) // Base Condition
            return 0;
        int heightLeft = findHeight(root.left); // Hypothesis
        int heightRight = findHeight(root.right);
        return 1 + Math.max(heightRight, heightLeft); // Induction
    }

    private static class TreeNode {

        private final TreeNode left;
        private final TreeNode right;
        private final int data;

        public TreeNode(TreeNode left, TreeNode right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }
}
