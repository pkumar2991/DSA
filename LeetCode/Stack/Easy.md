## LeetCode Easy Problems on Stack
1. [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/description/)
- Input String must be of even length.
- If the first char of the input is closing parentheses, then not a balanced parentheses

```java
public boolean isValid(String s) {  
    Deque<Character> stack = new ArrayDeque<>();  
    if (s.length() % 2 != 0) {  
        return false;  
    } else {  
        char first = s.charAt(0);  
        if (first == ')' || first == ']' || first == '}') {  
            return false;  
        }  
    }  
    for (char c : s.toCharArray()) {  
        if (c == '(' || c == '{' || c == '[') {  
            stack.offerFirst(c);  
        } else {  
            if (stack.isEmpty()) return false;  
            else {  
                char top = stack.peekFirst();  
                if (top == '[' && c != ']') {  
                    return false;  
                } else if (top == '(' && c != ')') {  
                    return false;  
                } else if (top == '{' && c != '}') {  
                    return false;  
                }  
                stack.pollFirst();  
            }  
        }  
    }  
    return stack.isEmpty();  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

2. [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/description/)
```java
public List<Integer> inorderTraversal(TreeNode root) {  
    Deque<TreeNode> stack = new ArrayDeque<>();  
    List<Integer> output = new ArrayList<>();  
    if (root == null) return output;  
    while (true) {  
        while (root != null) {  
            stack.offerFirst(root);  
            root = root.left;  
        }  
  
        if (stack.isEmpty()) {  
            break;  
        }  
        root = stack.pollFirst();  
        output.add(root.val);  
        root = root.right;  
    }  
    return output;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

3. [Binary Tree PreOrder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)

```java
public List<Integer> inorderTraversal(TreeNode root) {  
    Deque<TreeNode> stack = new ArrayDeque<>();  
    List<Integer> output = new ArrayList<>();  
    if (root == null) return output;  
    while (true) {  
        while (root != null) {
	        output.add(root.val);    
            stack.offerFirst(root);  
            root = root.left;  
        }  
  
        if (stack.isEmpty()) {  
            break;  
        }  
        root = stack.pollFirst();  
        root = root.right;  
    }  
    return output;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

4. [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/description/)

```java
public List<Integer> postorderTraversal(TreeNode root) {  
    List<Integer> output = new ArrayList<>();  
    if (root == null) {  
        return output;  
    }  
    TreeNode previous = null;  
    Deque<TreeNode> stack = new ArrayDeque<>();  
    while (true) {  
        while (root != null) {  
            stack.offerFirst(root);  
            root = root.left;  
        }  
        while (root == null && stack.size() > 0) {  
            root = stack.peekFirst();  
            if (root.right == null || root.right == previous) {  
                output.add(root.val);  
                stack.pollFirst();  
                previous = root;  
                root = null;  
            } else {  
                root = root.right;  
            }  
        }  
        if (stack.isEmpty()) {  
            break;  
        }  
    }  
    return output;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

5. [Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/description/)

```java
class MyStack {  
    Deque<Integer> stack;  
    public MyStack() {  
        stack = new ArrayDeque<>();  
    }  
  
    public void push(int x) {  
        stack.addFirst(x);  
    }  
  
    public int pop() {  
        return stack.removeFirst();  
    }  
  
    public int top() {  
        return stack.peekFirst();  
    }  
  
    public boolean empty() {  
        return stack.isEmpty();  
    }  
}
```

6. [Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/description/)

```java
class MyQueue {  
    Deque<Integer> s1;  
    Deque<Integer> s2;  
    public MyQueue() {  
        s1 =  new ArrayDeque<>();  
        s2 =  new ArrayDeque<>();  
    }
      
    public void push(int x) {  
        s1.offerFirst(x);  
    }  
    
    public int pop() {  
        while(s1.size() > 0){  
            s2.offerFirst(s1.pollFirst());  
        }  
        int top = s2.pollFirst();  
        while(s2.size() > 0){  
            s1.offerFirst(s2.pollFirst());  
        }  
        return top;  
    }
      
    public int peek() {  
        while(s1.size() > 0){  
            s2.offerFirst(s1.pollFirst());  
        }  
        int top = s2.peekFirst();  
        while(s2.size() > 0){  
            s1.offerFirst(s2.pollFirst());  
        }  
        return top;  
    }  
    
    public boolean empty() {  
        return s1.isEmpty();  
    }  
}
```

7. [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/description/)

```java
public boolean isPalindrome(ListNode head) {  
    Deque<ListNode> stack = new ArrayDeque<>();  
    ListNode current = head;  
    while(current != null){  
        stack.offerFirst(current);  
        current = current.next;  
    }  
    current = head;  
    while(current != null){  
        if(stack.size() > 0 && stack.pollFirst().val != current.val){  
            return false;  
        }  
        current = current.next;  
    }  
    return true;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

8. [N-ary Tree Preorder Traversal](https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/)

```java
public List<Integer> preorder(Node root) {  
    Deque<Node> stack = new ArrayDeque<>();  
    List<Integer> output = new ArrayList<>();  
    if(root == null) return output;  
    stack.offerFirst(root);  
    while(stack.size() > 0){  
        output.add(root.val);  
        Node current = root;  
        for(int i = root.children.size() - 1; i >= 0; i--){  
            current = root.children.get(i);  
            stack.offerFirst(current);  
        }  
        root = stack.pollFirst();  
    }  
    return output;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

9. [N-ary Tree Postorder Traversal](https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/)

```java
public List<Integer> postorder(Node root) {  
    Deque<Node> stack = new ArrayDeque<>();  
    List<Integer> output = new ArrayList();  
    if (root == null) return output;  
    stack.offerFirst(root);  
    while (stack.size() > 0) {  
        Node top = stack.pollFirst();  
        output.add(top.val);  
        for (Node node : top.children) {  
            stack.offerFirst(node);  
        }  
    }  
    Collections.reverse(output);  
    return output;  
}
```