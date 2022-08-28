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
        return;  
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

10. Find height of the binary tree

```java
public int heightOfTree(Node root) {  
    if (root == null) return 0;  
    int leftHt = 0;  
    int rightHt = 0;  
  
    leftHt = heightOfTree(root.left);  
    rightHt = heightOfTree(root.right);  
    if (leftHt > rightHt) {  
        return leftHt + 1;  
    } else {  
        return rightHt + 1;  
    }  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

11. Find height of the binary tree without recursion

```java
public int heightOfTreeWithoutRecursion(Node root) {  
    int height = 0;  
    if (root != null) {  
        Queue<Node> queue = new LinkedList<>();  
        queue.add(root);  
        queue.add(null);  
        while (!queue.isEmpty()) {  
            root = queue.poll();  
            if (root == null) {  
                if (!queue.isEmpty()) {  
                    queue.add(null);  
                }  
                height++;  
            } else {  
                if (root.left != null)  
                    queue.add(root.left);  
                if (root.right != null)  
                    queue.add(root.right);  
            }  
        }  
    }  
    return height;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

12. Find the deepest node of the binary tree.

```java
public Node deepestNode(Node root) {  
    Node deepNode = null;  
    if (root != null) {  
        Queue<Node> queue = new LinkedList<>();  
        queue.add(root);  
        while (!queue.isEmpty()) {  
            root = queue.poll();  
            if (root.left != null) {  
                queue.add(root.left);  
            }  
            if (root.right != null) {  
                queue.add(root.right);  
            }  
        }  
        deepNode = root;  
    }  
    return deepNode;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

13. Delete a node from the binary tree

1. Find the node that need to be deleted
```java
Node findNode(Node root, int data) {  
	/*  
	 * Depth First Search     * */    if (root == null) {  
		return null;  
	} else {  
		if (root.data == data) return root;  
		Node node = findNode(root.left, data);  
		if (node == null) {  
			node = findNode(root.right, data);  
		}  
		return node;  
	}  
}
```

2. Find the deepest node
```java
public Node deepestNode(Node root) {  
	Node deepNode = null;  
	if (root != null) {  
		Queue<Node> queue = new LinkedList<>();  
		queue.add(root);  
		while (!queue.isEmpty()) {  
			root = queue.poll();  
			if (root.left != null) {  
				queue.add(root.left);  
			}  
			if (root.right != null) {  
				queue.add(root.right);  
			}  
		}  
		deepNode = root;  
	}  
	return deepNode;  
}	
```

3. Delete the deepest node 
```java
void deleteDeepestNode(Node root, Node deepestNode) {  
    if (root != null && deepestNode != null) {  
        Queue<Node> queue = new LinkedList<>();  
        queue.add(root);  
        while (!queue.isEmpty()) {  
            root = queue.poll();  
            if (root.left != null) {  
                if (root.left == deepestNode) {  
                    root.left = null;  
                    return;  
                } else {  
                    queue.add(root.left);  
                }  
            }  
            if (root.right != null) {  
                if (root.right == deepestNode) {  
                    root.right = null;  
                } else {  
                    queue.add(root.right);  
                }  
            }  
  
        }  
    }  
}
```
5. Replace the data of deepest node with the data of the node that need to be deleted and then delete the deepest node

`Instead of deleting the node we could replace the data with the deepest node and remove the deepest node. This approach will not disturb the hierarchy of the existing tree after deleting the deepest node.
`
```java
void deleteNode(Node root, int data) {  
	Node nodeTobeDeleted = findNode(root, data);  
	Node currentNode = root;  
	if (nodeTobeDeleted != null) {  
		Node deepestNode = deepestNode(currentNode);  
		if (deepestNode != null) {  
			nodeTobeDeleted.data = deepestNode.data;  
			deleteDeepestNode(root, deepestNode);  
		}  
	}
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)
