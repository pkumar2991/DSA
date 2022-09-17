# Priority Queues and Heaps

## What is a Heap?
Heap is a special data structure. It is a tree with special properties and can also be classified as Complete Binary Tree. 

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

## Applications of Heap
Heap is used to implement Priority Queue. Applications for Priority queue are following:
- Data Compression : Huffman Coding Algorithm
- Shortest Path algorithm: Dijkstra's Algorithm
- Minimum Spanning Tree algorithms: Prim's algorithm
- Event-driven simulation: Customers in a line
- Selection Problem: Finding kth - smallest element

## When to use Heap?
Heap can be used to find minimum or maximum item among list of items. 

## What is Binary Heap?
Binary heap may have up to two children.

### Representing Heaps
Heap can be represented as array. It would be level traversal of a binary heap.

| Node               | Index         |
|:------------------:|:-------------:|
| Parent Node | (i - 1) / 2 |
| Left Node  | 2*i + 1|
| Right Node     |  2*i + 2     |


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
  
    // Time Complexity : O(log n), Space Complexity : O(1)  
    public void heapifyDown(int i) {  
        int l, r, max, temp;  
        l = leftChild(i);  
        r = rightChild(i);  
        if (l != -1 && this.array[l] > this.array[i]) {  
            max = l;  
        } else {  
            max = i;  
        }  
  
        if (r != -1 && this.array[r] > this.array[i]) {  
            max = r;  
        } else {  
            max = i;  
        }  
  
        if (max != i) { // swap the values  
            temp = this.array[i];  
            this.array[i] = this.array[max];  
            this.array[max] = temp;  
        }  
        heapifyDown(max);  
  
    }  
}
```