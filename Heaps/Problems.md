#Heaps 
## Sort a K Sorted Array | Sort a nearly sorted array
Given an array of **N** elements, where each element is at most K away from its target position, devise an algorithm that sorts in O(N log K) time
`Code:`
```java
int arr[]={6,5,3,2,8,10};  
int k = 3;  
int len = arr.length;  
ArrayList<Integer> list = new ArrayList<>();  
PriorityQueue<Integer> pq = new PriorityQueue<>();  
 for (int i = 0; i < len; i++) {  
     pq.add(arr[i]);  
     if(pq.size() > k){  
         list.add(pq.remove()); // after remove heapify works  
     }  
 }  
 while (pq.size() > 0){  
     list.add(pq.remove());  
 }  
 System.out.println(list);
```

`Output:` [2, 3, 5, 6, 8, 10]

## Kth Smallest element
Given an array of N elements, find the kth smallest element from the array.

`Code:`

```java
int arr[]={6,5,3,2,8,10};  
int k = 3;  
int len = arr.length;  
PriorityQueue<Integer> pq = new PriorityQueue<>();  // MIN HEAP
 for (int i = 0; i < len; i++) {  
     pq.add(arr[i]);  
 }  
 while (pq.size() > 0 && k - 1> 0){  
     k--;  
     pq.remove();  
 }  
 System.out.println(pq.peek());
```

`Output:` 5

## Kth Largest element
Given an array of N elements, find the kth largest element from the array.

`Code:`

```java
int arr[]={6,5,3,2,8,10};  
int k = 3;  
int len = arr.length;  
PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);  // MAX HEAP
 for (int i = 0; i < len; i++) {  
     pq.add(arr[i]);  
 }  
 while (pq.size() > 0 && k - 1> 0){  
     k--;  
     pq.remove();  
 }  
 System.out.println(pq.peek());
```

`Output:` 6