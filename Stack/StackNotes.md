#DSA #Stack 

### Identification
- Array should be there as input
- Brutefore solution will have O(n2) and second iteration would be the function of first

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

`Time Complexity:` O(n)\
`Space Complexity:`  O(n)

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

