# Problems on Binary Tree
Refer the [[Notes]] page for the binary tree
1. Find maximum of a binary tree

```java
int findMax(Node root) {  
    int max = Integer.MIN_VALUE;  
    int rootVal = 0;  
    int left = 0;  
    int right = 0;  
    if (root != null) {  
        rootVal = root.data;  
        left = findMax(root.left);  
        right = findMax(root.right);  
        if (left > right) {  
            max = left;  
        } else {  
            max = right;  
        }  
        max = Math.max(max, rootVal);  
    }  
    return max;  
}
```
`output:` 7
`Time Complexity:` O(n)
`Space Complexity:` O(n)

2. Find maximum of a binary tree without using recursion
`Use level order traversal`
```java
int findMaxWithoutRecursion(Node root) {  
    Queue<Node> queue = new ArrayDeque<>();  
    queue.add(root);  
    int max = Integer.MIN_VALUE;  
    while (!queue.isEmpty()) {  
        root = queue.remove();  
        max = Math.max(max, root.data);  
        if (root.left != null) {  
            queue.add(root.left);  
        }  
        if (root.right != null) {  
            queue.add(root.right);  
        }  
    }  
    return max;  
}
```

`output:` 7
`Time Complexity:` O(n)
`Space Complexity:` O(n)