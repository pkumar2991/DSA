package com.dsa.dynamicprogramming.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterOfBT {
    /**
     * Given a binary tree, you need to compute the length of the diameter of the tree.
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
     * This path may or may not pass through the root.
     * <p>
     * Example:
     * Given a binary tree
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
     */
    static int diameter = 0;

    public static void main(String[] args) {
        Node root = populateBT();
        findDiameter(root);
        System.out.println(diameter - 1);// path or edge= node - 1
    }

    private static int findDiameter(Node root) {
        //Base condition
        if (root == null)
            return 0;

        // Hypothesis
        int left = findDiameter(root.left);
        int right = findDiameter(root.right);

        // Induction
        int temp = 1 + Math.max(left, right); // CASE 1 - Longest path which could be left or right path for next calculation
        int diameterAtCurrentNode = 1 + left + right;
        diameter = Math.max(diameter, diameterAtCurrentNode); // CASE 2 - Diameter at current node
        return temp;
    }

    private static Node populateBT() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(9);

        root.left.right = new Node(4);
        root.left.left = new Node(5);
        return root;
    }
}
