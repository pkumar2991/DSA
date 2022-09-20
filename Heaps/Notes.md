# Priority Queues and Heaps

## What is a Heap?
Heap is a special data structure. It is a tree with special properties and can also be classified as Complete Binary Tree ( **Perfect Binary Tree** or **Almost Complete Binary Tree**).

**Almost Complete Binary Tree**
- Leaves should present only at last and second last level
- Leaves at same level must be added from left to right

**Maximum No of nodes at height (level) h =** 2^h
**Maximum No of nodes in a complete binary tree =** (2^(h+1) - 1)

In a perfect binary tree, **No of Internal Nodes =** No of leaves - 1.

To represent a Heap, an array is used. The maximum requried size of the array would be the maximum number of nodes in a complete binary tree.

**Height Of Tree (Complete Binary Tree)** = floor (log N) of base 2

For Zero based index
**Range of leaves =** (N/2) to (N-1)
**Range of Internal Nodes** = 0 to (N/2) - 1

### Required Property
Value of a node must be greater or equal to (>=) or lesser or equal to (<=) than the value of its childre.

## Types of Heaps
Based on the property, there are two types of Heaps.
1. Max Heap
2. Min Heap

### Max Heap
Value of a node is greater or equal to (>=) the value of its children.

### Min Heap
Value of a node is lesser or equal to (<=) the value of its children.

`Notes:`
- If we have a sorted array in descending order, then it is a **Max Heap**.
- If we have a sorted array in ascending order, then it is a **Min Heap**.

## Applications of Heap
Heap is used to implement Priority Queue. Applications for Priority queue are following:
- Data Compression : Huffman Coding Algorithm
- Shortest Path algorithm: Dijkstra's Algorithm
- Minimum Spanning Tree algorithms: Prim's algorithm
- Event-driven simulation: Customers in a line
- Selection Problem: Finding kth - smallest element

## When to use Heap?
Heap can be used to find minimum or maximum item among list of items. 

In this case, Heap would be the best choice as it's time complexity for finiding min and max, inserting and deleting is fat better than other linear data structures.

![[TimeComplexity_Heap_Analysis.png]](https://github.com/pkumar2991/DSA/blob/main/images/TimeComplexity_Heap_Analysis.png)

## What is Binary Heap?
Binary heap may have up to two children.

### Representing Heaps
Heap can be represented as array. It would be level traversal of a binary heap. 

| Node               | Index         |
|:------------------:|:-------------:|
| Parent Node | (i - 1) / 2 |
| Left Node  | 2*i + 1|
| Right Node     |  2*i + 2     |

### What is Heapify?
The process of rearranging the heap by comparing each parent with its children **recursively** is know as Heapify. 

Heapify down is also know as **Percolate Down**.

#### Percolate Down (Heapify Down)
```java
public void heapifyDown(int[] heap, int i) {  
    int l, r, max = i, temp;  
    int size = heap.length;  
    l = (2 * i) + 1;  
    r = (2 * i) + 2;  
    if (l < size && heap[l] > heap[max]) {  
        max = l;  
    }  
  
    if (r < size && heap[r] > heap[max]) {  
        max = r;  
    }  
    if (max != i) { // swap the values  
        temp = heap[i];  
        heap[i] = heap[max];  
        heap[max] = temp;  
        heapifyDown(heap, max);  
    }  
}
```

`Input:` int A[] = {9, 8, 5, 6, 3, 2, 1, 0}; -> level order traversal of a complete binary tree\
`Output`: 
`Time Complexity:` O(log n)\
`Space Complexity:`  O(log n)

#### Percolate Up (Heapify Up)
```java
public void heapifyUp(int[] heap, int i) {  
    if (heap.length == 0) return;  
  
    if (i == 0 || heap[i] < heap[(i - 1) / 2]) return;  
    // swap values with parent  
    int temp = heap[(i - 1) / 2];  
    heap[(i - 1) / 2] = heap[i];  
    heap[i] = temp;  
  
    i = (i - 1) / 2;  
    heapifyUp(heap, i);  
}
```

`Input:` In order traversal of a Complete Binary Tree as an array
`Time Complexity:` O(log n)\
`Space Complexity:`  O(log n)

### Build a Heap from an Inorder Traversal of a Tree as an array

```java
void buildHeapFromArray(int[] heap, int n) {  
    if (n == 0) return;  
    if (n > heap.length) {  
        resizeHeap(heap, n - heap.length);  
    }  
    int lastInternalNode = (n / 2) - 1;  
    for (int i = lastInternalNode; i >= 0; i--) {  
        heapifyDown(heap, i);  
    }  
}
```

`Time Complexity:` O(n)\
`Space Complexity:`  O(log n)

### Resize a Heap
```java
int[] resizeHeap(int[] heap, int capacityIncreaseBy) {  
    int currentCapacity = heap.length;  
    int[] array_old = new int[currentCapacity];  
    System.arraycopy(heap, 0, array_old, 0, currentCapacity);  
    int newCapacity = this.capacity + capacityIncreaseBy;  
    heap = new int[newCapacity];  
    if (heap == null) {  
        System.out.println("Memory Error");  
        return null;  
    }  
    for (int i = 0; i < currentCapacity; i++) {  
        heap[i] = array_old[i];  
    }  
    return heap;  
}
```

### Heap Algorithms
1. Extract Max (Heap Pop)
2. Increase Key
3. Decrease Key
4. Insert Key


#### Extract Max 
Returns the maximum value of the heap after removing it from the Max_Heap. After extraction, heap should remain Max_Heap.

```java
int extractMax(int[] heap) {  
    if (heap.length == 0) return Integer.MIN_VALUE;  
    // Save the Max Value  
    int maxValue = heap[0];  
    // Replace the Max value with the last element of Max Heap  
    heap[0] = heap[heap.length - 1];  
    // Heapify the Max heap  
    heapifyDown(heap, 0);  
    return maxValue;  
}
```

`Time Complexity:` O(log n)\
`Space Complexity:`  O(log n)

#### Increasing Key
On increasing a node value in a Max Heap, a node may move up to maintain the Max Heap Property.

```java
public void increaseKey(int[] heap, int i, int newValue) throws Exception {  
    if (heap.length == 0) {  
        heap = new int[1];  
        heap[0] = newValue;  
        return;  
    }  
    if (i < 0 || i > heap.length) {  
        throw new ArrayIndexOutOfBoundsException("Invalid Index");  
    }  
    if (newValue < heap[i]) {  
        throw new Exception("Invalid Operation. Provide greater value.");  
    }  
    heap[i] = newValue;  
    heapifyUp(heap, i);  
}
```

`Time Complexity:` O(log n)\
`Space Complexity:`  O(log n)

#### Decreasing Key
On decreasing a node value in a Max Heap, a node may move down to maintain Heap Property.

```java
public void decreaseKey(int[] heap, int i, int newValue) throws Exception {  
    if (heap.length == 0) {  
        heap = new int[1];  
        heap[0] = newValue;  
        return;  
    }  
    if (i < 0 || i > heap.length) {  
        throw new ArrayIndexOutOfBoundsException("Invalid Index");  
    }  
    if (newValue > heap[i]) {  
        throw new Exception("Invalid Operation. Provide lesser value.");  
    }  
    heap[i] = newValue;  
    heapifyDown(heap, i);  
}
```

`Time Complexity:` O(log n)\
`Space Complexity:`  O(log n)

#### Insert Key
A new value would be inserted next to the last node of the tree. On Inserting new key in a Max Heap, a node may move up to maintain the Heap Property.

```java
int[] insertKey(int[] heap, int newValue) {  
    if (heap.length == 0) {  
        heap = new int[1];  
        heap[0] = newValue;  
        return heap;  
    }  
    heap = resizeHeap(heap, 1);  
    heap[heap.length - 1] = newValue;  
    heapifyUp(heap, heap.length - 1);  
    return heap;  
}
```

`Time Complexity:` O(log n)\
`Space Complexity:`  O(log n)

### Time and Space Complexity Summary for Max Heap

| Algorithm             | Time Complexity | Space Complexity                       |
| --------------------- | --------------- | -------------------------------------- |
| Find Max              | O(1)            | O(1)                                   |
| Delete Max            | O(log N)        | Recursion - O(log N), Iterative - O(1) |
| Insert                | O(log N)        | Recursion - O(log N), Iterative - O(1) |
| Increase Key          | O(log N)        | Recursion - O(log N), Iterative - O(1) |
| Decrease key          | O(log N)        | Recursion - O(log N), Iterative - O(1) |
| Find Min              | O(N)            | O(1)                                   |
| Delete Random Element | O(N)            | O(1)                                   |
| Search Random Element | O(N)            | O(1)                                   | 

