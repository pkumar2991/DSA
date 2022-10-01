package com.notes;

import java.util.ArrayList;
import java.util.List;

class Tree {
    Node createTree() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right.left = new Node(6);
        node.right.right = new Node(7);
        return node;
    }

    boolean areMirrorTrees(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.data != root2.data)
            return false;
        else {
            return areMirrorTrees(root1.left, root2.right) && areMirrorTrees(root1.right, root2.left);
        }
    }

    boolean isIsomorphicTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }
        return isIsomorphicTree(root1.left, root2.left) && isIsomorphicTree(root1.right, root2.right);
    }

    boolean isQuasiIsomorphicTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }
        return (isQuasiIsomorphicTree(root1.left, root2.left) && isQuasiIsomorphicTree(root2.right, root2.right)
                || (isQuasiIsomorphicTree(root1.left, root2.right) && isQuasiIsomorphicTree(root1.right, root2.left)));
    }

    KNode buildKAryTree(int[] A, int n, int k, int ind) {
        if (n <= 0) {
            return null;
        }
        KNode node = new KNode(A[ind]);
        for (int i = 0; i < k; i++) {
            if (k * ind + 1 < n) {
                ind++;
                node.childNodes.add(new KNode(A[ind]));
            }
        }
        return null;
    }

    ThreadedBinaryTreeNode findInOrderSuccessor(ThreadedBinaryTreeNode root) {
        if (root == null) return null;
        if (root.rTag == 0) {
            return root.right;
        } else {
            ThreadedBinaryTreeNode current = root.right;
            while (current.lTag == 1) {
                current = current.left;
            }
            return current;
        }
    }

    void inOrderTraversal(ThreadedBinaryTreeNode root) {
        ThreadedBinaryTreeNode p = findInOrderSuccessor(root);
        while (p != root) {
            System.out.print(p.data + ",");
            p = findInOrderSuccessor(p);
        }
    }

    Node findEltInBST(Node root, int data) {
        if (root == null) return null;
        if (root.data == data) return root;
        if (data < root.data) {
            return findEltInBST(root.left, data);
        } else {
            return findEltInBST(root.right, data);
        }
    }

    Node findEltInBSTNonRecursive(Node root, int data) {
        if (root == null) return null;

        while (root != null) {
            if (root.data == data) return root;
            else if (data < root.data)
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }

    Node findMinBST(Node root) {
        if (root == null) return null;
        if (root.left == null) return root;
        return findMinBST(root.left);
    }

    Node findMinBSTNonRecursive(Node root) {
        if (root == null) return null;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    Node findMaxBST(Node root) {
        if (root == null) return null;
        if (root.right == null) return root;
        return findMaxBST(root.right);
    }

    // Non-Recursive Solution
    Node findMaxBSTNonRecursive(Node root) {
        if (root == null) return null;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    Node insertEltBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data == data) return null;
        if (data < root.data) {
            root.left = insertEltBST(root.left, data);
        } else {
            root.right = insertEltBST(root.right, data);
        }
        return root;
    }

    Node deleteNodeBST(Node root, int data) {
        if (root == null) return null;
        else if (root.data > data) {
            root.left = deleteNodeBST(root.left, data);
        } else if (root.data < data) {
            root.right = deleteNodeBST(root.right, data);
        } else {
            if (root.left != null && root.right != null) {
                Node temp = root;
                Node max = findMaxBST(temp.left);
                root.data = max.data;
                root.left = deleteNodeBST(root.left, root.data);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    Node findLCA(Node root, int node1, int node2) {
        if (root == null) return root;
        if (root.data == node1 || root.data == node2) {
            return root;
        }
        Node left = findLCA(root.left, node1, node2);
        Node right = findLCA(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }

    Node findLCABST(Node root, int node1, int node2) {
        while (true) {
            if ((node1 < root.data && root.data < node2) || (node2 < root.data && root.data < node1)) {
                return root;
            }
            if (node1 < root.data && node2 < root.data) {
                root = root.left;
            } else if (node1 > root.data && node2 > root.data) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    boolean isBST(Node root) {
        if (root == null) return true;
        if (root.left != null && findMaxBST(root.left).data > root.data)
            return false;
        if (root.right != null && findMinBST(root.right).data < root.data)
            return false;
        if (!isBST(root.left) || !isBST(root.right)) {
            return false;
        }
        return true;
    }

    boolean isBST1(Node root, int min, int max) {
        if (root == null) return true;
        return (root.data > min && root.data < max) && (isBST1(root.left, min, root.data)) && (isBST1(root.right, root.data, max));
    }

    boolean isBSTUsingInOrder(Node root, int previous) {
        if (root == null) return true;
        if (!isBSTUsingInOrder(root.left, previous)) {
            return false;
        }
        if (root.data < previous) {
            return false;
        }
        previous = root.data;
        return isBSTUsingInOrder(root.right, previous);
    }

    void inOrderTraverseBST(Node root) {
        if (root == null) return;
        inOrderTraverseBST(root.left);
        System.out.print(root + " ");
        inOrderTraverseBST(root.right);
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        Node root = t.createBST();

        System.out.println(t.isBST(root));
        System.out.println(t.isBSTUsingInOrder(root, Integer.MIN_VALUE));
        System.out.println(t.isBST1(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    Node createBST() {
        Node node = new Node(7);
        node.left = new Node(44);
        node.right = new Node(9);

        node.left.left = new Node(2);
        node.left.right = new Node(5);
        node.left.right.right = new Node(6);

        return node;
    }

    ThreadedBinaryTreeNode createThreadedBinaryTree() {
        ThreadedBinaryTreeNode dummy = new ThreadedBinaryTreeNode(-1);

        ThreadedBinaryTreeNode root = new ThreadedBinaryTreeNode(1);
        root.lTag = 1;
        root.rTag = 1;
        root.left = new ThreadedBinaryTreeNode(2);
        root.left.rTag = 1;
        root.left.lTag = 1;
        root.right = new ThreadedBinaryTreeNode(3);
        root.right.rTag = 1;
        root.right.lTag = 1;

        root.left.left = new ThreadedBinaryTreeNode(4);
        root.left.left.lTag = 0;
        root.left.left.rTag = 0;
        root.left.left.left = dummy;
        root.left.left.right = root.left;
        root.left.right = new ThreadedBinaryTreeNode(5);
        root.left.right.lTag = 0;
        root.left.right.rTag = 0;
        root.left.right.right = root;
        root.left.right.left = root.left;

        root.right.left = new ThreadedBinaryTreeNode(6);
        root.right.left.lTag = 0;
        root.right.left.rTag = 0;
        root.right.left.left = root;
        root.right.right = new ThreadedBinaryTreeNode(7);
        root.right.right.lTag = 0;
        root.right.right.rTag = 0;
        root.right.right.left = root.right;
        root.right.right.right = dummy;

        dummy.right = dummy;
        dummy.left = root;
        dummy.lTag = 1;
        dummy.rTag = 1;

        return root;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "";
    }
}

class KNode {
    int data;
    List<KNode> childNodes = new ArrayList<>();

    public KNode(int data) {
        this.data = data;
    }
}

class ThreadedBinaryTreeNode {
    int data;
    ThreadedBinaryTreeNode left;
    ThreadedBinaryTreeNode right;
    int lTag;
    int rTag;

    public ThreadedBinaryTreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "";
    }
}