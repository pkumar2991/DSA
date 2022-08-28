## Tree Traversal
- Pre-Order (D-L-R)
- In-Order (L-D-R)
- Post-Order (L-R-D)

## Complete Binary Tree
![alt tree_image] (https://github.com/pkumar2991/DSA/blob/main/binary_tree.png "Binary Tree Image")
### Create Node
```java
class Node{  
    int data;  
    Node left;  
    Node right;  
  
    public Node(int data) {  
        this.data = data;  
    }  
  
    @Override  
    public String toString() {  
        return data+"";  
    }  
}
```
### Create Tree
```java
Node  createTree(){  
    Node node = new Node(1);  
    node.left = new Node(2);  
    node.right = new Node(3);  
  
    node.left.left = new Node(4);  
    node.left.right = new Node(5);  
  
    node.right.left = new Node(6);  
    node.right.right = new Node(7);  
    return node;  
}
```

### Pre-Order Traversal
Traversing tree using recursion

*Time Complexity- O(n)*
*Space Complexity- O(n)*

```java
void preOrderRecursion(Node node){  
    if(node != null){  
        System.out.print(node + " ");  
        preOrderRecursion(node.left);  
        preOrderRecursion(node.right);  
    }  
}
```

`Output:` 1 2 4 5 3 6 7 

Traversing tree using stack

*Time Complexity- O(n)*
*Space Complexity- O(n)*

```java
void preOrderUsingStack(Node node){  
    Deque<Node> nodeDeque = new ArrayDeque<>();  
    while (true){  
        while(node != null){  
            System.out.print(node + " ");  
            nodeDeque.push(node);  
            node = node.left;  
        }  
        if(nodeDeque.isEmpty()){  
            break;  
        }  
        node = nodeDeque.pop();  
        node = node.right;  
    }  
}
```

`Output:` 1 2 4 5 3 6 7 

### In-Order Traversal
Traversing tree using recursion

*Time Complexity- O(n)*
*Space Complexity- O(n)*

```java
void inOrderRecursion(Node node) {  
    if (node == null) {  
        return;  
    }  
    inOrderRecursion(node.left);  
    System.out.print(node + "");  
    inOrderRecursion(node.right);  
}
```

`Output:` 4 2 5 1 6 3 7

Traversing tree using stack

*Time Complexity- O(n)*
*Space Complexity- O(n)*

```java
void inOrderUsingStack(Node node){  
    Deque<Node> nodeDeque = new ArrayDeque<>();  
    while (true){  
        while(node != null){  
            nodeDeque.push(node);  
            node = node.left;  
        }  
  
        if(nodeDeque.isEmpty()){  
            break;  
        }  
        node = nodeDeque.pop();  
        System.out.print(node +" ");  
        node = node.right;  
    }  
}
```

`Output:` 4 2 5 1 6 3 7

### Post-Order Traversal

https://www.youtube.com/watch?v=xLQKdq0Ffjg

Traversing tree using recursion

*Time Complexity- O(n)*
*Space Complexity- O(n)*

```java
void postOrderRecursion(Node node){  
    if(node == null) return;  
    postOrderRecursion(node.left);  
    postOrderRecursion(node.right);  
    System.out.print(node + " ");  
}
```

`Output:` 4 5 2 6 7 3 1

Traversing tree using stack

*Time Complexity- O(n)*
*Space Complexity- O(n)*

```java
void postOrderUsingStack(Node node) {  
    Deque<Node> nodeDeque = new ArrayDeque<>();  
    Node previous = null;  
    while (node != null || !nodeDeque.isEmpty()) {  
        while (node != null){  
          nodeDeque.push(node);  
          node = node.left;  
      }  
      while(node == null && !nodeDeque.isEmpty()){  
          node = nodeDeque.peek();  
          if(node.right == null || node.right == previous){  
              System.out.print(node+" ");  
              nodeDeque.pop();  
              previous = node;  
              node = null;  
          }else{  
              node = node.right;  
          }  
      }  
    }  
 }
```

`Output:` 4 5 2 6 7 3 1

### Level Order Traversal

Traversing tree using queue

*Time Complexity- O(n)*
*Space Complexity- O(n)*

```java
void levelTraversal(Node root) {  
    Queue<Node> queue = new ArrayDeque<>();  
    queue.add(root);  
    if (root == null) {  
        return;  
    }  
    while (!queue.isEmpty()) {  
        root = queue.remove();  
        System.out.print(root + " ");  
        if (root.left != null) {  
            queue.add(root.left);  
        }  
        if (root.right != null) {  
            queue.add(root.right);  
        }  
    }  
}
```
`Output:` 1 2 3 4 5 6 7
