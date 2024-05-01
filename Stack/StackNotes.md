#DSA #Stack 

### Identification
- Array should be there as input
- Bruteforce solution will have O(n2) and second iteration would be the function of first

```java
for(int i = 0; i < n; i++)
for(int j = i + 1; j < n; j++)
```

### Next Greater / largest Element
Nearest Greater to Right

```java
int[] nextGreaterElementRight(int[] arr) {  
    Deque<Integer> stack = new ArrayDeque<>();  
    List<Integer> output = new ArrayList<>();  
    for (int i = arr.length - 1; i >= 0; i--) {  
        if (stack.isEmpty()) {  
            output.add(-1);  
        } else if (stack.size() > 0 && stack.peek() > arr[i]) {  
            output.add(stack.peek());  
        } else if(stack.size() > 0 && stack.peek() <= arr[i]){  
            while (stack.size() != 0 && stack.peek() <= arr[i]) {  
                stack.pop();  
            }  
            if(stack.size() == 0){  
                output.add(-1);  
            }else {  
                output.add(stack.peek());  
            }  
        }  
        stack.push(arr[i]);  
    }  
    Collections.reverse(output);  
    return output.stream().mapToInt(x->x).toArray();  
}
``` 

### Nearest Greater To Left
```java
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
```

`Time Complexity:` O(n)\
`Space Complexity:`  O(n)

### Next Smaller to left
```java
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
```

`Time Complexity:` O(n)\
`Space Complexity:`  O(n)

### Next smaller to right
```java
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
```

`Time Complexity:` O(n)\
`Space Complexity:`  O(n)

### StockSpan

```java
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
```

`Time Complexity:` O(n)\
`Space Complexity:`  O(n)

### Max Area Histogram
```java
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
```

`Time Complexity:` O(n)\
`Space Complexity:`  O(n)

### Maximum area of rectangle in Binary Matrix
```java
int maxAreaRectangleBinaryMatrix(int[][] arr) {  
    /*Consider each array of this matrix as an Histogram.  
     * Convert binary into decimal values histogram array     * Calculate maxAreaHistogram for each array     * Find max among all calculated maxAreaHistogram     * */    int max = Integer.MIN_VALUE;  
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
```

`Time Complexity:` O(n^2)\
`Space Complexity:`  O(n)

### Rain water trapping
```java
int rainWaterTrapping(int[] arr) {  
    /* Calculate water logged in between building of different heights  
     * */    int[] maxLeft = new int[arr.length];  
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
```

`Time Complexity:` O(n)\
`Space Complexity:`  O(n)

### Min Stack with Extra Space
```java
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
```

`Time Complexity:` O(n)\
`Space Complexity:`  O(n)

### Min Stack with NO Extra Space
```java
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
    addFirst(stack, 18);  
    addFirst(stack, 19);  
    addFirst(stack, 29);  
    addFirst(stack, 15);  
    System.out.println(getMinElement(stack));  
    removeFirst(stack);  
    System.out.println(getMinElement(stack));  
}
```

`Time Complexity:` O(n)\
`Space Complexity:`  O(1)

