#leetCode #Stack

1. [Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/description/)

```java
int[] nextGreaterElementRight(int[] arr) {  
    Deque<Integer> deque = new ArrayDeque<>();  
    int[] output = new int[arr.length];  
    for (int i = 0; i < arr.length; i++) {  
        while (!deque.isEmpty() && arr[i] > arr[deque.peek()]) {  
            output[deque.pop()] = arr[i];  
        }  
        if (deque.isEmpty()) {  
            deque.push(i);  
        } else if (arr[i] <= arr[deque.peek()]) {  
            deque.push(i);  
        }  
    }  
    while (!deque.isEmpty()) {  
        output[deque.pop()] = -1;  
    }  
    return output;  
}  
  
public int[] nextGreaterElement(int[] nums1, int[] nums2) {  
    Map<Integer,Integer> map = new HashMap<>();  
    int[] nextGreaterRightElt = nextGreaterElementRight(nums2);  
    for (int i = 0; i < nums2.length; i++) {  
        map.put(nums2[i],nextGreaterRightElt[i]);  
    }  
    int[] output = new int[nums1.length];  
    for (int i = 0; i < output.length; i++) {  
        output[i] = map.get(nums1[i]);  
    }  
    return output;  
}
```

`Time Complexity:` O(n) + O(nums1.length + nums2.length)\
`Space Complexity:` O(nums2.length)

2. [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)
**If largest rectangle contains at least 1 bar in full then if we find areas of all largest rectangles for each bar being included full then we can find the maximum rectangle area**
****
```java
int largestRectangleInHistogram(int[] heights) {  
    int maxArea = 0;  
    //find next left smaller element/ left limit index  
    Deque<Integer> stack = new ArrayDeque<>();  
    int[] leftLimitIndex = new int[heights.length];  
    int[] rightLimitIndex = new int[heights.length];  
  
    for (int i = 0; i < heights.length; i++) {  
        if (stack.isEmpty()) {  
            leftLimitIndex[i] = 0;  
        } else if (stack.size() > 0 && heights[stack.peek()] < heights[i]) {  
            leftLimitIndex[i] = stack.peek() + 1;  
        } else if (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {  
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {  
                stack.pop();  
            }  
            if (stack.isEmpty()) {  
                leftLimitIndex[i] = 0;  
            } else {  
                leftLimitIndex[i] = stack.peek() + 1;  
            }  
        }  
        stack.push(i);  
    }  
    //find next right smaller element / right limit index  
    stack.clear();  
    for (int i = heights.length - 1; i >= 0; i--) {  
        if (stack.isEmpty()) {  
            rightLimitIndex[i] = heights.length - 1;  
        } else if (stack.size() > 0 && heights[stack.peek()] < heights[i]) {  
            rightLimitIndex[i] = stack.peek() - 1;  
        } else if (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {  
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {  
                stack.pop();  
            }  
            if (stack.isEmpty()) {  
                rightLimitIndex[i] = heights.length - 1;  
            } else {  
                rightLimitIndex[i] = stack.peek() - 1;  
            }  
        }  
        stack.push(i);  
    }  
    // Calculate area for each possible rectangle  
    for (int i = 0; i < heights.length; i++) {  
        maxArea = Math.max(maxArea, ((rightLimitIndex[i] - leftLimitIndex[i]) + 1) * heights[i]);  
    }  
    return maxArea;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

3. [Minimum Cost Tree From Leaf Values](https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/)

```java
int mctFromLeafValues(int[] arr) {  
    int sum = 0;  
    int len = arr.length;  
    Deque<Node> stack = new ArrayDeque<>();  
  
    for (int index = 0; index < len; index++) {  
        Node node = new Node(index, arr[index]);  
        while (!stack.isEmpty() && stack.peekFirst().val <= node.val) {  
            Node poll = stack.pollFirst();  
            if (stack.isEmpty())  
                sum = sum + poll.val * node.val;  
            else  
                sum = sum + poll.val * Math.min(node.val, stack.peekFirst().val);  
        }  
        stack.offerFirst(node);  
    }  
    while (stack.size() >= 2) {  
        Node poll = stack.pollFirst();  
        sum = sum + poll.val * stack.peekFirst().val;  
    }  
    return sum;  
}  
  
static class Node {  
    int index, val;  
  
    Node(int index, int val) {  
        this.index = index;  
        this.val = val;  
    }  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

4. [Flatten Nested List Iterator](https://leetcode.com/problems/flatten-nested-list-iterator/description/)

```java
public class NestedIterator implements Iterator<Integer> {
    Deque<Integer> stack = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList == null) return;
        for(int i=nestedList.size() - 1; i >= 0; i--){
            populate(nestedList.get(i));
        }
    }
    private void populate(NestedInteger nInteger){
        if(nInteger.isInteger()){
            stack.push(nInteger.getInteger());
        }else{
            List<NestedInteger> list= nInteger.getList(); 
            for(int i=list.size() - 1; i >= 0; i--){
                populate(list.get(i));
            }
        }
    }
    @Override
    public Integer next() {
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

5. [Min Stack](https://leetcode.com/problems/min-stack/description/)

```java
class MinStack {

    private Node head;
    public MinStack() {
    }

    public void push(int val) {
        if (head == null)
            head = new Node(val, val, null);
        else
            head = new Node(val, Math.min(val, head.min), head);
    }

    public void pop() {
        if(head != null){
            head = head.next;
        }
    }

    public int top() {
        if(head != null){
            return head.val;
        }
       return -1;
    }
    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
```

`Time Complexity:` O(1) \
`Space Complexity:` O(n)

6. [Simplify Path](https://leetcode.com/problems/simplify-path/description/)

```java
public String simplifyPath(String path) {  
    String[] fnames = path.split("/");  
    StringBuilder sb = new StringBuilder("");  
    Deque<String> stack = new ArrayDeque<>();  
    for(int i = 1; i < fnames.length; i++){  
        if(fnames[i].equals("..") && stack.size() > 0){  
            stack.pollFirst();  
        }else if(!fnames[i].equals(".") && !fnames[i].equals("") && !fnames[i].equals("..")){  
            stack.offerFirst(fnames[i]);  
        }  
    }  
    if(stack.isEmpty()) {  
        sb.append("/");  
        return sb.toString();  
    }  
  
    while(stack.size() > 0){  
        sb.append("/");  
        sb.append(stack.pollLast());  
    }  
    return sb.toString();  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

7. [Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/)

```java
public void flatten(TreeNode root) {  
    if (root == null) return;  
    Deque<TreeNode> stack = new ArrayDeque<>();  
    stack.offerFirst(root);  
    while (stack.size() > 0) {  
        TreeNode current = stack.pollFirst();  
        if (current.right != null) {  
            stack.offerFirst(current.right);  
        }  
        if (current.left != null) {  
            stack.offerFirst(current.left);  
        }  
        if (stack.size() > 0) {  
            current.right = stack.peekFirst();  
        }  
        current.left = null;  
    }  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

8. [Reorder List](https://leetcode.com/problems/reorder-list/description/)

```java
public void reorderList(ListNode head) {  
    ListNode current = head;  
    Deque<ListNode> stack = new ArrayDeque<>();  
    int len = 0;  
    while (current != null) {  
        stack.offerFirst(current);  
        current = current.next;  
        len++;  
    }  
    current = head;  
    for (int i = 1; i <= len / 2; i++) {  
        ListNode temp = current.next;  
        ListNode endNode = stack.pollFirst();  
        current.next = endNode;  
        endNode.next = temp;  
        current = temp;  
    }  
    current.next = null;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

9. [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/)

```java
public int evalRPN(String[] tokens) {  
    Deque<Integer> stack = new ArrayDeque<>();  
    int op1 = 0;  
    int op2 = 0;  
    for (String str : tokens) {  
        if (str.equals("*")) {  
            op1 = stack.pollFirst();  
            op2 = stack.pollFirst();  
            stack.offerFirst(op1 * op2);  
        } else if (str.equals("/")) {  
            op1 = stack.pollFirst();  
            op2 = stack.pollFirst();  
            stack.offerFirst(op2 / op1);  
        } else if (str.equals("+")) {  
            op1 = stack.pollFirst();  
            op2 = stack.pollFirst();  
            stack.offerFirst(op1 + op2);  
        } else if (str.equals("-")) {  
            op1 = stack.pollFirst();  
            op2 = stack.pollFirst();  
            stack.offerFirst(op2 - op1);  
        } else {  
            stack.offerFirst(Integer.parseInt(str));  
        }  
    }  
    if (stack.size() > 0) return stack.pollFirst();  
    else  
        return 0;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

10. [Construct Binary Search Tree from Preorder Traversal](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/)

```java
public TreeNode bstFromPreorder(int[] preorder) {  
    Deque<TreeNode> stack = new ArrayDeque<>();  
    TreeNode root = new TreeNode(preorder[0]);  
    stack.offerFirst(root);  
    for (int i = 1; i < preorder.length; i++) {  
        TreeNode current = new TreeNode(preorder[i]);  
        if (stack.peekFirst().val > preorder[i]) {  
            stack.peekFirst().left = current;  
        } else {  
            TreeNode parent = stack.peek();  
            while (!stack.isEmpty() && preorder[i] > stack.peekFirst().val) {  
                parent = stack.pollFirst();  
            }  
            parent.right = current;  
        }  
        stack.offerFirst(current);  
    }  
    return root;  
}
```

`Time Complexity:` O(n) \
`Space Complexity:` O(n)

