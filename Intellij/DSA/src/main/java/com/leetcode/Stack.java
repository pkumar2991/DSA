package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Stack {
    static class StackNode {
        private int data;
        private int index;

        public StackNode(int data, int index) {
            this.data = data;
            this.index = index;
        }

    }

    int[] stockSpan(int[] arr) {
        // Find Next Greater to left
        Deque<StackNode> stack = new ArrayDeque<>();
        List<StackNode> list = new ArrayList<>();
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                list.add(new StackNode(-1, -1));
            } else if (stack.size() > 0 && stack.peek().data > arr[i]) {
                list.add(new StackNode(stack.peek().data, stack.peek().index));
            } else if (stack.size() > 0 && stack.peek().data <= arr[i]) {
                while (stack.size() > 0 && stack.peek().data <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    list.add(new StackNode(-1, -1));
                } else {
                    list.add(new StackNode(stack.peek().data, stack.peek().index));
                }
            }
            stack.push(new StackNode(arr[i], i));
        }
        for (int i = 0; i < arr.length; i++) {
            output[i] = i - list.get(i).index;
        }
        return output;
    }

    int[] nextSmallerElementRight(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (stack.size() > 0 && stack.peek() < arr[i]) {
                list.add(stack.peek());
            } else if (stack.size() > 0 && stack.peek() >= arr[i]) {
                while (stack.size() > 0 && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(x -> x).toArray();
    }

    int[] nextSmallerElementLeft(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                output[i] = -1;
            } else if (stack.size() > 0 && stack.peek() < arr[i]) {
                output[i] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() >= arr[i]) {
                while (stack.size() > 0 && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    output[i] = -1;
                } else {
                    output[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return output;
    }

    int[] nextGreaterElementLeft(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                output[i] = -1;
            } else if (stack.size() > 0 && stack.peek() > arr[i]) {
                output[i] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() <= arr[i]) {
                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    output[i] = -1;
                } else {
                    output[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return output;
    }

    int[] nextGreaterElementRight(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                output.add(-1);
            } else if (stack.size() > 0 && stack.peek() > arr[i]) {
                output.add(stack.peek());
            } else if (stack.size() > 0 && stack.peek() <= arr[i]) {
                while (stack.size() != 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    output.add(-1);
                } else {
                    output.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(output);
        return output.stream().mapToInt(x -> x).toArray();
    }

    int[] nextGreaterElementRight1(int[] arr) {
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
        Map<Integer, Integer> map = new HashMap<>();
        int[] nextGreaterRightElt = nextGreaterElementRight(nums2);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nextGreaterRightElt[i]);
        }
        int[] output = new int[nums1.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = map.get(nums1[i]);
        }
        return output;
    }

    int maxAreaHistogram(int[] arr) {
        if (arr.length == 0) return -1;
        Deque<StackNode> stack = new ArrayDeque<>();
        // find array of Next smaller element to the left
        List<StackNode> leftSmallerEltList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                leftSmallerEltList.add(new StackNode(arr[i], -1));
            } else if (stack.size() > 0 && stack.peek().data < arr[i]) {
                leftSmallerEltList.add(new StackNode(stack.peek().data, stack.peek().index));
            } else if (stack.size() > 0 && stack.peek().data >= arr[i]) {
                while (stack.size() > 0 && stack.peek().data >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    leftSmallerEltList.add(new StackNode(arr[i], -1));
                } else {
                    leftSmallerEltList.add(new StackNode(stack.peek().data, stack.peek().index));
                }
            }
            stack.push(new StackNode(arr[i], i));
        }
        // find array of Next smaller element to the right
        stack.clear();
        List<StackNode> rightSmallerEltList = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                rightSmallerEltList.add(new StackNode(arr[i], arr.length));
            } else if (stack.size() > 0 && stack.peek().data < arr[i]) {
                rightSmallerEltList.add(new StackNode(stack.peek().data, stack.peek().index));
            } else if (stack.size() > 0 && stack.peek().data >= arr[i]) {
                while (stack.size() > 0 && stack.peek().data >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    rightSmallerEltList.add(new StackNode(arr[i], arr.length));
                } else {
                    rightSmallerEltList.add(new StackNode(stack.peek().data, stack.peek().index));
                }
            }
            stack.push(new StackNode(arr[i], i));
        }
        Collections.reverse(rightSmallerEltList);
        // width array of each height
        int[] width = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            width[i] = rightSmallerEltList.get(i).index - leftSmallerEltList.get(i).index - 1;
        }
        //  areas of each height
        int[] areas = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            areas[i] = arr[i] * width[i];
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < areas.length; i++) {
            if (areas[i] > maxArea) {
                maxArea = areas[i];
            }
        }
        return maxArea;
    }

    int maxAreaRectangleBinaryMatrix(int[][] arr) {
        /*
         * Consider each array of this matrix as an Histogram.
         * Convert binary into decimal values histogram array
         * Calculate maxAreaHistogram for each array
         * Find max among all calculated maxAreaHistogram
         * */
        int max = Integer.MIN_VALUE;
        int input[] = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    input[j] += arr[i][j];
                } else {
                    input[j] = 0;
                }

            }
            max = Math.max(max, maxAreaHistogram(input));
        }
        return max;
    }

    int rainWaterTrapping(int[] arr) {
        /* Calculate water logged in between building of different heights
         * */
        int[] maxLeft = new int[arr.length];
        int[] maxRight = new int[arr.length];
        int maxLeftValue = arr[0];
        maxLeft[0] = maxLeftValue;
        int maxRightValue = arr[arr.length - 1];
        maxRight[arr.length - 1] = maxRightValue;
        // Find max left of each height
        for (int i = 1; i < arr.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        }
        // Find max right of each height
        for (int i = arr.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(arr[i], maxRight[i + 1]);
        }
        int[] water = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            water[i] = Math.min(maxLeft[i], maxRight[i]) - arr[i];
            sum += water[i];
        }
        return sum;
    }

    void push(int num, Deque<Integer> stack1, Deque<Integer> minStack) {
        stack1.addFirst(num);
        if (minStack.isEmpty()) {
            minStack.addFirst(num);
        } else if (num < getMin(minStack)) {
            minStack.addFirst(num);
        }
    }

    int pop(Deque<Integer> stack1, Deque<Integer> minStack) {
        if (stack1.isEmpty())
            return -1;
        int ans = stack1.peekFirst();
        if (ans == minStack.peekFirst()) {
            minStack.removeFirst();
        }
        return ans;
    }

    int getMin(Deque<Integer> minStack) {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peekFirst();
    }

    void minStackWithExtraSpace() {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();
        // 18,19,29,15,16
        push(18, stack, minStack);
        push(19, stack, minStack);
        push(29, stack, minStack);
        push(15, stack, minStack);
        System.out.println(getMin(minStack));
        pop(stack, minStack);
        System.out.println(getMin(minStack));
    }

    /*Min Stack with NO extra space*/
    int minElement = -1;

    int peekFirst(Deque<Integer> stack) {
        if (stack.isEmpty()) return -1;
        int top = stack.peekFirst();
        if (top < minElement) {
            return minElement;
        } else {
            return top;
        }
    }

    void addFirst(Deque<Integer> stack, int num) {
        if (stack.isEmpty()) {
            stack.addFirst(num);
            minElement = num;
        } else {
            if (num >= minElement) {
                stack.addFirst(num);
            } else {
                int ans = 2 * num - minElement;
                stack.addFirst(ans);
                minElement = num;
            }
        }
    }

    int removeFirst(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return -1;
        } else {
            int top = peekFirst(stack);
            if (top > minElement) {
                stack.removeFirst();
                return top;
            } else {
                int ans = minElement;
                // store previous min element to the variable
                minElement = 2 * minElement - stack.removeFirst();
                return ans;
            }
        }
    }

    int getMinElement(Deque<Integer> stack) {
        if (stack.isEmpty())
            return -1;
        return minElement;
    }

    void minStackWithNoExtraSpace() {
        Deque<Integer> stack = new ArrayDeque<>();
        // 18,19,29,15,16
        System.out.println(getMinElement(stack));
        addFirst(stack, -2);
        addFirst(stack, 0);
        addFirst(stack, -3);
        System.out.println(getMinElement(stack));
        removeFirst(stack);
        System.out.println(peekFirst(stack));
    }

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

    int minCostTreeFromLeafValues(int[] arr) {
        return -1;
    }

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

    public List<Integer> postorder(TNode root) {
        Deque<TNode> stack = new ArrayDeque<>();
        List<Integer> output = new ArrayList();
        if (root == null) return output;
        stack.offerFirst(root);
        TNode previous = null;
        while (stack.size() > 0) {
            TNode current = root;
            for (int i = root.children.size() - 1; i >= 0; i--) {
                current = root.children.get(i);
                stack.offerFirst(current);
            }
            previous = root;
            root = current;
            while (root.children == null && stack.size() > 0) {
                root = stack.peekFirst();
                boolean isPrevious = false;
                if (root.children != null)
                    for (TNode node : root.children) {
                        if (node.val == previous.val) {
                            isPrevious = true;
                        }
                    }
                if (root.children == null || isPrevious) {
                    output.add(root.val);
                    stack.pollFirst();
                    previous = root;
                    root.children = null;
                } else {
                    root = stack.pollFirst();
                }
            }
        }

        return output;
    }

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

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.simplifyPath("/home/");
//        TNode root = new TNode(1, null);
//        root.children = new ArrayList<>();
//        root.children.add(new TNode(3, null));
//        root.children.add(new TNode(2, null));
//        root.children.add(new TNode(4, null));
//
//        root.children.get(0).children = new ArrayList<>();
//        root.children.get(0).children.add(new TNode(5, null));
//        root.children.get(0).children.add(new TNode(6, null));
//
//        List<Integer> output = stack.postorder(root);
    }
}

class TNode {
    public int val;
    public List<TNode> children;

    public TNode() {
    }

    public TNode(int _val) {
        val = _val;
    }

    public TNode(int _val, List<TNode> _children) {
        val = _val;
        children = _children;
    }
}
