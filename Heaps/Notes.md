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

![[TimeComplexity_Heap_Analysis.png]]

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

`Input:` In order traversal of a Complete Binary Tree as an array
`Time Complexity:` O(log n)\
`Space Complexity:`  O(log n)

### Create a Heap

```java
public class Heap {  
    public int[] array;  
    public int count;  
    public int capacity;  
    public int heap_type;  
  
    // Time complexity to create Heap = O(1)  
    public Heap(int capacity, int heap_type) {  
        this.heap_type = heap_type;  
        this.count = 0;  
        this.capacity = capacity;  
        this.array = new int[capacity];  
    }  
  
    // Time complexity to create Heap = O(1)  
    public int parent(int i) {  
        if (i <= 0 || i >= this.count) return -1;  
        return (i - 1) / 2;  
    }  
  
    // Time complexity to create Heap = O(1)  
    public int leftChild(int i) {  
        int left = (2 * i) + 1;  
        if (left >= this.count) return -1;  
        return left;  
    }  
  
    // Time complexity to create Heap = O(1)  
    public int rightChild(int i) {  
        int right = (2 * i) + 2;  
        if (right >= this.count) return -1;  
        return right;  
    }  
  
    // Time complexity to create Heap = O(1)  
    public int findMax() {  
        if (this.count == 0) return -1;  
        return this.array[0];  
    }  
  
    
}
```