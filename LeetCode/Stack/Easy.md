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

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

10. [Baseball Game](https://leetcode.com/problems/baseball-game/description/)

```java
public int calPoints(String[] operations) {  
    Deque<Integer> stack = new ArrayDeque<>();  
    for (String op : operations) {  
        if (stack.size() > 0 && op.equals("C")) {  
            stack.removeFirst();  
        } else if (stack.size() > 0 && op.equals("D")) {  
            stack.offerFirst(stack.peekFirst() * 2);  
        } else if (stack.size() > 0 && op.equals("+")) {  
            int num = stack.pollFirst();  
            int sum = num + stack.peekFirst();  
            stack.offerFirst(num);  
            stack.offerFirst(sum);  
  
        } else {  
            stack.offerFirst(Integer.parseInt(op));  
        }  
    }  
    int sum = 0;  
    while (stack.size() > 0) {  
        sum += stack.pollFirst();  
    }  
    return sum;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

11. [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/description/)

```java
public boolean backspaceCompare(String s, String t) {  
    Deque<Character> stack = new ArrayDeque<>();  
    for (char c : s.toCharArray()) {  
        if (c == '#') {  
            stack.pollFirst();  
        } else {  
            stack.offerFirst(c);  
        }  
    }  
    s = "";  
    while (stack.size() > 0) {  
        s += stack.pollFirst();  
    }  
    for (char c : t.toCharArray()) {  
        if (c == '#') {  
            stack.pollFirst();  
        } else {  
            stack.offerFirst(c);  
        }  
    }  
    t = "";  
    while (stack.size() > 0) {  
        t += stack.pollFirst();  
    }  
    if (s.equals(t)) {  
        return true;  
    } else {  
        return false;  
    }  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

12. [Increasing Order Search Tree](https://leetcode.com/problems/increasing-order-search-tree/description/)

```java
public TreeNode increasingBST(TreeNode root) {  
    if (root == null) {  
        return null;  
    }  
    Deque<TreeNode> stack = new ArrayDeque<>();  
    TreeNode newTree = null;  
    TreeNode newTreeHead = null;  
    while (true) {  
        while (root != null) {  
            stack.offerFirst(root);  
            root = root.left;  
        }  
        if (stack.isEmpty()) {  
            break;  
        }  
        root = stack.pollFirst();  
        if (newTree == null) {  
            newTree = new TreeNode(root.val, null, null);  
            newTreeHead = newTree;  
        } else {  
            newTree.right = new TreeNode(root.val, null, null);  
            newTree = newTree.right;  
        }  
        root = root.right;  
    }  
    return newTreeHead;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

13. [Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/description/)

```java
public String removeOuterParentheses(String s) {  
    if(s.length() == 0){  
        return s;  
    }  
    Deque<Character> stack = new ArrayDeque<>();  
    StringBuilder sb = new StringBuilder();  
    for(char c : s.toCharArray()){  
        if(c == '('){  
            if(stack.size() > 0){  
                sb.append(c);  
            }  
            stack.offerFirst(c);  
        }else{  
            if(stack.size() > 1){  
                sb.append(c);  
            }  
            stack.pollFirst();  
        }  
    }  
    return sb.toString();  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

14. [Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/)

```java
public String removeDuplicates(String s) {  
    Deque<Character> stack = new ArrayDeque<>();  
    StringBuilder ans = new StringBuilder();  
    char[] letters = s.toCharArray();  
    for (int i = letters.length - 1; i >= 0; i--) {  
        if (stack.size() > 0 && stack.peekFirst() == letters[i]) {  
            stack.pollFirst();  
        } else {  
            stack.offerFirst(letters[i]);  
        }  
    }  
    while (stack.size() > 0) {  
        ans.append(stack.pollFirst());  
    }  
    return ans.toString();  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

15. [Final Prices With a Special Discount in a Shop](https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/)

```java
public int[] finalPrices(int[] prices) {  
    Deque<Integer> stack = new ArrayDeque<>();  
    int[] output = new int[prices.length];  
    for(int i = prices.length - 1; i >= 0; i--){  
        while(stack.size() > 0 && prices[stack.peekFirst()] > prices[i]){  
            stack.pollFirst();  
        }  
        if(stack.size() > 0 && stack.peekFirst() > i)  
            output[i] = prices[i] - prices[stack.peekFirst()];  
        if(stack.isEmpty()){  
            output[i] = prices[i];  
        }  
        stack.offerFirst(i);  
    }  
    return output;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

16. [Make The String Great](https://leetcode.com/problems/make-the-string-great/description/)

```java
public String makeGood(String s) {  
    Deque<Character> stack = new ArrayDeque<>();  
    StringBuilder sb = new StringBuilder();  
    char[] chars = s.toCharArray();  
    for (int i = chars.length - 1; i >= 0; i--) {  
        if (stack.size() > 0 && Character.isUpperCase(stack.peekFirst()) && Character.isLowerCase(chars[i])  
                && Character.toLowerCase(stack.peekFirst()) == chars[i]) {  
            stack.pollFirst();  
        } else if (stack.size() > 0 && Character.isUpperCase(chars[i]) && Character.isLowerCase(stack.peekFirst())  
                && Character.toLowerCase(chars[i]) == stack.peekFirst()) {  
            stack.pollFirst();  
        } else {  
            stack.offerFirst(chars[i]);  
        }  
    }  
    while (stack.size() > 0) {  
        sb.append(stack.pollFirst());  
    }  
    return sb.toString();  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

17. [Crawler Log Folder](https://leetcode.com/problems/crawler-log-folder/description/)

```java
public int minOperations(String[] logs) {  
    Deque<String> stack = new ArrayDeque<>();  
    int countToMainFolder = 0;  
    for (String log : logs) {  
        if (stack.size() > 0 && log.equals("../")) {  
            stack.pollFirst();  
        } else if (!log.equals("./") && !log.equals("../")) {  
            stack.offerFirst(log);  
        }  
    }  
    while (stack.size() > 0) {  
        stack.pollFirst();  
        countToMainFolder++;  
    }  
    return countToMainFolder;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

18. [Maximum Nesting Depth of the Parentheses](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/)

```java
public int maxDepth(String s) {  
    int depth = 0;  
    int openParentheses = 0;  
    Deque<Character> stack = new ArrayDeque<>();  
    for (char c : s.toCharArray()) {  
        if (c == '(') {  
            stack.offerFirst(c);  
            openParentheses++;  
        }  
        while (stack.size() > 0 && c != '(' && c != ')') {  
            stack.pollFirst();  
        }  
        depth = Math.max(depth, openParentheses);  
        if (c == ')') {  
            openParentheses--;  
        }  
    }  
    return depth;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

