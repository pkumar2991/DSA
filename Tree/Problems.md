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
`output:` 7\
`Time Complexity:` O(n)\
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

`output:` 7\
`Time Complexity:` O(n)\
`Space Complexity:` O(n)

3. Search an element in tree (return 1 if found otherwise return 0)

```java
int searchElt(Node root, int data) {
    int temp = 0;
    if (root == null) {
        return 0;
    } else {
        if (root.data == data) {
            return 1;
        }
        temp = searchElt(root.left, data);
        if (temp == 1)
            return 1;
        return searchElt(root.right, data);
    }

}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

4. Search an element in tree using queue
```java
int searchEltQueue(Node root, int data) {  
    Deque<Node> deque = new LinkedList<>();  
    deque.add(root);  
    while (!deque.isEmpty()) {  
        root = deque.poll();  
        if (root.data == data) {  
            return 1;  
        }  
        if (root.left != null) {  
            deque.add(root.left);  
        }  
        if (root.right != null) {  
            deque.add(root.right);  
        }  
    }  
    return 0;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

5. Insert a node into the binary tree
```java
void insetUsingQueue(Node root, int data) {  
    Deque<Node> deque = new LinkedList<>();  
    if (root == null) {  
        root = new Node(data);  
    }  
    deque.add(root);  
    while (!deque.isEmpty()) {  
        root = deque.poll();  
        if (root.left == null) {  
            root.left = new Node(data);  
            return;  
        } else {  
            deque.add(root.left);  
        }  
        if (root.right == null) {  
            root.right = new Node(data);  
            return;  
        } else {  
            deque.add(root.right);  
        }  
    }  
  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

6. Find the total number of nodes in the binary tree
```java
int sizeOfBinaryTree(Node root) {  
    if (root == null) return 0;  
    return sizeOfBinaryTree(root.left) + sizeOfBinaryTree(root.right) + 1;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

7. Find the total number of nodes in the binary tree without recursion

```java
int sizeOfBinaryTreeWithoutRecursion(Node root) {  
    if (root == null) return 0;  
    Deque<Node> deque = new LinkedList<>();  
    deque.add(root);  
    int count = 0;  
    while (!deque.isEmpty()) {  
        root = deque.poll();  
        count++;  
        if (root.left != null) {  
            deque.add(root.left);  
        }  
        if (root.right != null) {  
            deque.add(root.right);  
        }  
    }  
    return count;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

8.  Print the level order traversal in reverse way
```java
void reverseLevelNodePrint(Node root) {  
    if (root == null) return;  
    Deque<Node> deque = new LinkedList<>();  
    Deque<Node> stack = new ArrayDeque<>();  
    deque.add(root);  
    while (!deque.isEmpty()) {  
        root = deque.poll();  
        if (root.right != null) {  
            deque.add(root.right);  
        }  
        if (root.left != null) {  
            deque.add(root.left);  
        }  
        stack.push(root);  
    }  
    while (!stack.isEmpty()) {  
        System.out.print(stack.pop() + " ");  
    }  
}
```

`Output:` 4 5 6 7 2 3 1\

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

9. Delete a tree

```java
Node deleteTree(Node root) {  
    if (root == null) return null;  
    deleteTree(root.left);  
    deleteTree(root.right);  
    root.left = null;  
    root.right = null;  
    root = null;  
    return root;  
  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

