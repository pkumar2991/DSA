# Problems on Binary Tree
![binary_tree.png](https://github.com/pkumar2991/DSA/blob/main/images/binary_tree.png)
![[binary_tree.png]]
## Binary Tree
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

*Instead of deleting the node we could replace the data with the deepest node and delete the deepest node. This approach will not disturb the hierarchy of the existing tree after deleting the deepest node.*

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

14. Find number of leaf nodes in a binary tree
	*Nodes without any child is termed as Leaf Node.*

```java
int leafNodesCount(Node root) {  
    int count = 0;  
    if (root != null) {  
        Queue<Node> queue = new LinkedList<>();  
        queue.add(root);  
        while (!queue.isEmpty()) {  
            root = queue.poll();  
            if (root.left == null && root.right == null) {  
                count++;  
            } else {  
                if (root.left != null) {  
                    queue.add(root.left);  
                }  
                if (root.right != null) {  
                    queue.add(root.right);  
                }  
            }  
        }  
  
    }  
    return count;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

15. Find the count of full nodes in a binary tree.
	*Node having both left and right child is termed as full node.*
```java
int fullNodeCount(Node root) {  
    int count = 0;  
    if (root != null) {  
        Queue<Node> queue = new LinkedList<>();  
        queue.add(root);  
        while (!queue.isEmpty()) {  
            root = queue.poll();  
            if (root.left != null && root.right != null) {  
                count++;  
            }  
            if (root.left != null) {  
                queue.add(root.left);  
            }  
            if (root.right != null) {  
                queue.add(root.right);  
            }  
        }  
    }  
    return count;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

16. Find the count of half nodes in a binary tree.
	*Node having either left child or right child (but not both) is termed as half node*
```java
int halfNodeCount(Node root) {  
    int count = 0;  
    if (root != null) {  
        Queue<Node> queue = new LinkedList<>();  
        queue.add(root);  
        while (!queue.isEmpty()) {  
            root = queue.poll();  
            if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {  
                count++;  
            }  
            if (root.left != null) {  
                queue.add(root.left);  
            }  
            if (root.right != null) {  
                queue.add(root.right);  
            }  
        }  
    }  
    return count;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

17. Compare two trees if they are identical

```java
boolean identicalTree(Node root1, Node root2){  
    if(root1 == null && root2 == null){  
        return  true;  
    }  
    if(root1 == null || root2 == null){  
        return false;  
    }  
    return (root1.data == root2.data) && identicalTree(root1.left,root2.left) && identicalTree(root1.right,root2.right);  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

18. Find the diameter of a binary tree
**Diameter: Total number of nodes from deepest node of the left to the deepest node to the right of the tree.**
*There are three cases while evaluating the diameter of binary tree:*
- start of the diameter lies on left and end lies on right side of the tree
- start and end both lies on left side of the tree
- start and end both lies on right side of the tree

If we consider only first case, the solution would be the below one:
```java
int diameter(Node root){  
    if(root == null) return 0;  
    int lh = heightOfTree(root.left);  
    int rh = heightOfTree(root.right);  
	 // No of nodes = no of edges + 1; 
	 // No of edges = 2 (if two child) or 1 (if only one child)  
    return lh + rh + 3;
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

But considering all case, the solution would be the below one:

```java
int diameter(Node root){  
    if(root == null) return  0;  
    int left = diameterOn2(root.left);  
    int right = diameterOn2(root.right);  
    int htmax = heightOfTree(root.left) + heightOfTree(root.right) + 3;//7  
    int max = Math.max(htmax,Math.max(left,right));  
    return max;  
}
```

`Time Complexity:` O(n^2)\
`Space Complexity:` O(n)

It could be improvised by calculating height in the same recursion

```java
class DiaPair {  
    int diameter;  
    int height;  
  
    @Override  
    public String toString() {  
        return "DiaPair{" +  
                "diameter=" + diameter +  
                '}';  
    }
}

DiaPair findDiameter(Node root, DiaPair diaPair) {  
    if (root == null) {  
        DiaPair dia = new DiaPair();  
        dia.height = -1;  
        dia.diameter = 0;  
        return dia;  
    }  
    DiaPair leftDiaPair = findDiameter(root.left, diaPair);  
    DiaPair rightDiaPair = findDiameter(root.right, diaPair);  
    DiaPair dp = new DiaPair();  
    dp.height = Math.max(leftDiaPair.height, rightDiaPair.height) + 1;  
    int fes = leftDiaPair.height + rightDiaPair.height + 3;  
    dp.diameter = Math.max(fes, Math.max(leftDiaPair.diameter, rightDiaPair.diameter));  
    return dp;  
}
```
19. Find the level that has maximum sum in the binary tree.
```java
int findLevelWithMaxiSum(Node root) {  
    int currentSum = 0, maxSum = 0;  
    int level = 0;  
    int maxLevel = 0;  
    if (root == null) return 0;  
    Queue<Node> queue = new LinkedList<>();  
    queue.add(root);  
    queue.add(null);  
    while (!queue.isEmpty()) {  
        root = queue.poll();  
        if (root != null) {  
            currentSum = currentSum + root.data;  
            if (root.left != null) {  
                queue.add(root.left);  
            }  
            if (root.right != null) {  
                queue.add(root.right);  
            }  
        } else {  
            if (currentSum > maxSum) {  
                maxSum = currentSum;  
                maxLevel = level;  
            }  
            level++;  
            currentSum = 0;  
            if (!queue.isEmpty())  
                queue.add(null);  
        }  
  
    }  
    return maxLevel;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

20. Print all the nodes of root-to-leaf paths

```java
void printRootToLeafPath(Node root, ArrayList<Integer> list) {  
    if (root == null) return;  
    list.add(root.data);  
    if (root.left == null && root.right == null) {  
        printPath(list);  
    } else {  
        printRootToLeafPath(root.left, list);  
        list.remove(list.size() - 1);  
        printRootToLeafPath(root.right, list);  
        list.remove(list.size() - 1);  
    }  
  
}  
void printPath(ArrayList<Integer> list) {  
    Stream.of(list).forEach(System.out::print);  
    System.out.println();  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

21. Check existence of path with given sum.

```java
boolean hasPathWithSum(Node root, int sum) {  
    if (root == null) return false;  
    boolean ans = false;  
    int subSum = sum - root.data;  
    if (root.left == null && root.right == null) {  
        if (subSum != 0) return false;  
        return true;  
    }  
    if (root.left != null) {  
        ans = hasPathWithSum(root.left, subSum);  
    }  
    if (!ans && root.right != null) {  
        ans = hasPathWithSum(root.right, subSum);  
    }  
    return ans;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

22. Find sum of all elements in a binary tree

```java
int sum(Node root){  
    if(root == null) return 0;  
    return root.data + sum(root.left)+sum(root.right);  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

23. Find sum of all elements in a binary tree without recursion

```java
int sumWithoutRecursion(Node root) {  
    if (root == null) return 0;  
    Queue<Node> queue = new LinkedList<>();  
    queue.add(root);  
    int sum = 0;  
    while (!queue.isEmpty()) {  
        root = queue.poll();  
        sum = sum + root.data;  
  
        if (root.left != null) {  
            queue.add(root.left);  
        }  
        if (root.right != null) {  
            queue.add(root.right);  
        }  
    }  
    return sum;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

24. Replace the tree with its mirror tree

```java
Node mirrorBinaryTree(Node root) {  
    if (root == null) return null;  
    mirrorBinaryTree(root.left);  
    mirrorBinaryTree(root.right);  
    Node temp = root.right;  
    root.right = root.left;  
    root.left = temp;  
    return root;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

25. Check if two trees are mirror of each other.

```java
boolean areMirrorTrees(Node root1, Node root2) {  
    if (root1 == null && root2 == null) return true;  
    if (root1 == null || root2 == null) return false;  
    if (root1.data != root2.data)  
        return false;  
    else {  
        return areMirrorTrees(root1.left, root2.right) && areMirrorTrees(root1.right, root2.left);  
    }  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

26. Find least common ancestor(LCA) for two nodes in a tree
*The Lowest Common Ancestor (LCA) of two nodes ![u](https://www.baeldung.com/wp-content/ql-cache/quicklatex.com-e817933126862db10ae510d35359568e_l3.svg "Rendered by QuickLaTeX.com") and ![v](https://www.baeldung.com/wp-content/ql-cache/quicklatex.com-796872219106704832bd95ce08640b7b_l3.svg "Rendered by QuickLaTeX.com") in a rooted tree is the lowest (deepest) node that is an ancestor of both ![u](https://www.baeldung.com/wp-content/ql-cache/quicklatex.com-e817933126862db10ae510d35359568e_l3.svg "Rendered by QuickLaTeX.com") and ![v](https://www.baeldung.com/wp-content/ql-cache/quicklatex.com-796872219106704832bd95ce08640b7b_l3.svg "Rendered by QuickLaTeX.com").*

```java
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
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

27. Create tree with inorder and preorder traversal output of a tree

```java
Node buildBinaryTree(int[] inorder, int[] preorder, int inOrderStart, int inOrderEnd) {  
    if (inorder.length == 0 || preorder.length == 0) {  
        return null;  
    }  
    if (inOrderStart > inOrderEnd) return null;  
    int data = preorder[preOrderIndex];  
    Node node = new Node(data);  
    preOrderIndex++;  // Should be static variable
    if (inOrderStart == inOrderEnd) return node;  
    int inOrderIndex = -1;  
    for (int i = 0; i <= inOrderEnd; i++) {  
        if (inorder[i] == data) {  
            inOrderIndex = i;  
            break;  
        }  
    }  
    node.left = buildBinaryTree(inorder, preorder, inOrderStart, inOrderIndex - 1);  
    node.right = buildBinaryTree(inorder, preorder, inOrderIndex + 1, inOrderEnd);  
    return node;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

28. If we are given two traversal sequences, can we construct the binary tree uniquely?

*Tree can be constructed only if one of the traversal method is* **inorder**.

29. Print all ancestors of a node in the given tree

```java
boolean printAllAncestors(Node root, int data) {  
    if (root == null) return false;  
    if (root.data == data || printAllAncestors(root.left, data) || printAllAncestors(root.right, data)) {  
        System.out.print(root.data + " ");  
        return true;  
    }  
    return false;  
}
```

`Input:` 7\
`Output:` 1 3 7

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

30. Print the elements of tree in zigzag pattern

```java
void zigzagTraversal(Node root) {  
    if (root == null) return;  
    Deque<Node> currentLevelStack = new ArrayDeque<>();  
    Deque<Node> nextLevelStack = new ArrayDeque<>();  
    int leftToRight = 1;  
    Node temp = null;  
    currentLevelStack.push(root);  
  
    while (!currentLevelStack.isEmpty()) {  
        temp = currentLevelStack.pop();  
        if (temp != null) {  
            System.out.print(temp.data + " ");  
            if (leftToRight == 1) {  
                if (temp.left != null) nextLevelStack.push(temp.left);  
                if (temp.right != null) nextLevelStack.push(temp.right);  
            } else {  
                if (temp.right != null) nextLevelStack.push(temp.right);  
                if (temp.left != null) nextLevelStack.push(temp.left);  
            }  
        }  
        if (currentLevelStack.isEmpty()) {  
            leftToRight = 1 - leftToRight;  
            Deque<Node> tempStack = currentLevelStack;  
            currentLevelStack = nextLevelStack;  
            nextLevelStack = tempStack;  
        }  
    }  
}
```

`Output:` 1 3 2 4 5 6 7 8

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

31. Print vertical sum of a binary tree.

```java
void verticalSumInBinaryTree(Node root, int column, Map<Integer, Integer> map) {  
    if (root == null) return;  
    if (map.containsKey(column)) {  
        map.put(column, (map.get(column) + root.data));  
    } else {  
        map.put(column, root.data);  
    }  
    verticalSumInBinaryTree(root.left, column - 1, map);  
    verticalSumInBinaryTree(root.right, column + 1, map);  
}
```

Sort the map by key and then print the values of each map entry.

`Output:` 4 2 12 3 7

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

32. How many different binary trees are possible with n nodes?

*No of possible trees = (2^n) - n*

33. Create binary tree from preorder assuming that a node has either 0 or 2 node and leaf node is represented by L.

```java
CharNode buildTreeWithPreOrder(char[] preorder, int index) {  
    if (preorder.length == 0) return null;  
    CharNode node = new CharNode(preorder[index]); // created with root  
    if (preorder[index] == 'L') {  
        return node;  
    }  
    node.left = buildTreeWithPreOrder(preorder, index + 1);  
    index++;  
    node.right = buildTreeWithPreOrder(preorder, index + 1);  
    return node;  
}
```

`Input:` [I,L,I,L,L]\
`Output:` I L I L L -*preorder traversal of the tree built*

`Time Complexity:` O(n)

34. Fill the next pointer of each node in the tree/ Populate next pointer of each node

![[populateNextPointer.png]]

![populateNextPointer.png](https://github.com/pkumar2991/DSA/blob/main/images/populateNextPointer.png)

*`Condition:`* 
-  By default, next Pointer would be null for each node
-  If the right child of the node is null, next pointer would be null

https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

```java
class Node {  
    int data;  
    Node left;  
    Node right;  
    Node next;  
  
    public Node(int data) {  
        this.data = data;  
    }
}

void fillNext(Node root) {  
    if (root == null) {  
        return;  
    }  
    Queue<Node> queue = new LinkedList<>();  
    queue.add(root);  
    queue.add(null);  
    Node temp = null;  
    while (!queue.isEmpty()) {  
        temp = queue.poll();  
        if (temp == null) {  
            if (!queue.isEmpty()) {  
                queue.add(null);  
            }  
        } else {  
            temp.next = queue.peek();  
            if (temp.left != null) queue.add(temp.left);  
            if (temp.right != null) queue.add(temp.right);  
        }  
    }  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

35. Solve the above problem using recursion.

```java
void fillNextRecursion(Node root) {  
    if (root == null) return;  
    if (root.left != null) {  
        root.left.next = root.right;  
    }  
    if(root.right != null){  
        root.right.next = root.next != null ? root.next.left : null;  
    }  
    fillNextRecursion(root.left);  
    fillNextRecursion(root.right);  
}
```

`Time Complexity:` O(n)

## Generic Tree

![[GenericTree.png]]

![GenericTree.png](https://github.com/pkumar2991/DSA/blob/main/images/GenericTree.png)

*Represent the Generic tree in terms of nodes*

```java
class TreeNode {  
    int data;  
    TreeNode firstChild;  
    TreeNode nextSibling;  
  
    public TreeNode(int data) {  
        this.data = data;  
    }  
  
    @Override  
    public String toString() {  
        return data + "";  
    }  
}
```

*Create generic tree*

```java
TreeNode createGenericTree() {  
    TreeNode root = new TreeNode(1);  
    root.firstChild = new TreeNode(2);  
    root.firstChild.nextSibling = new TreeNode(3);  
  
    root.firstChild.nextSibling.nextSibling = new TreeNode(4);  
    root.firstChild.nextSibling.nextSibling.nextSibling = new TreeNode(5);  
  
    root.firstChild.nextSibling.firstChild = new TreeNode(6);  
    root.firstChild.nextSibling.firstChild.nextSibling = new TreeNode(7);  
  
    root.firstChild.nextSibling.nextSibling.firstChild = new TreeNode(8);  
    root.firstChild.nextSibling.nextSibling.firstChild.nextSibling = new TreeNode(9);  
    return root;  
  
  
}
```
36. Find the sum of all elements of the tree

```java
int findSum(TreeNode root) {  
    if (root == null) return 0;  
    return root.data + findSum(root.firstChild) + findSum(root.nextSibling);  
}
```

`output:` 45\
`Time Complexity:` O(n)\
`Space Complexity:` O(n)

39. Given a parent array P, where P[i] indicates the parent of ith node in the tree (assume parent of root node indicated with -1). Find the height or depth of the tree.

```java
int findDepthInGenericTree(int parentArr[]) {  
    int currentDepth = -1;  
    int maxDepth = -1;  
    int j = -1;  
    for (int i = 0; i < parentArr.length; i++) {  
        currentDepth = 0;  
        j = i;  
        while (parentArr[j] != -1) {  
            currentDepth++;  
            j = parentArr[j];  
        }  
        maxDepth = Math.max(currentDepth, maxDepth);  
    }  
    return maxDepth;  
}
```

`Input:` [-1, 0, 1, 6, 6, 0, 0, 2, 7]\
`Output`: 4

`Time Complexity:` O(n^2)

40. Find the siblings count of a given node

```java
int siblingsCount(TreeNode node){  
    int count = 0;  
    while (node.nextSibling != null){  
        count++;  
        node = node.nextSibling;  
    }  
    return count;  
}
```


`Time Complexity:` O(n)\
`Space Complexity:` O(1)

41. Find the count of children for a given node.

```java
int childCount(TreeNode node) {  
    int count = 0;  
    node = node.firstChild;  
    while (node != null) {  
        count++;  
        node = node.nextSibling;  
    }  
    return count;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)

42. Find if given two trees are **Isomorphic** to each other.

`Isomorphic Tree:`  Two trees are isomorphic if they are equal in structure even though value at each node is not same.

```java
boolean isIsomorphicTree(Node root1, Node root2) {  
    if (root1 == null && root2 == null) {  
        return true;  
    }  
    if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {  
        return false;  
    }  
    return isIsomorphicTree(root1.left, root2.left) && isIsomorphicTree(root1.right, root2.right);  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

43. Find if the given two trees are quasi-isomorphic to each other or not.

`Quasi-Isomorphic`: Tree will be quasi isomorphic if any subtree satisfies either of following conditions.
-  **Isomorphic Tree**: Structure of one subtree tree is identical to another subtree.
-  **Mirror Tree:** Structure of one subtree is mirror of another subtree.

```java
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
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)

44. **Pending**

## Threaded Binary Tree

![[ThreadedBinaryTree.png]]


### Classifying Threaded Binary Trees
- Left Threaded Binary Trees - Predecessor info stored only in one of the left subtree
- Right Threaded Binary Trees - Successor info stored only in one of the right subtree
- Fully Threaded Binary Trees - Predecessor info stored in left pointer and Successor info stored in right pointer.

### Types of Threaded Binary Trees
- PreOrder Threaded Binary Tree - Left pointer stores predecessor of preOrder and right pointer stores successor of preOrder.
- InOrder Threaded Binary Tree - Left pointer stores predecessor of InOrder and right pointer stores successor of InOrder.
- PostOrder Threaded Binary Tree - Left pointer stores predecessor of PostOrder and right pointer stores successor of PostOrder.

**Threaded Binary Tree Node**

```java
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
```

**Create InOrder Threaded Binary Tree**

```java
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
```

**Find Inorder Successor in InOrder Threaded Binary Tree**

```java
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
```