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

## K Closest Numbers
Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].

Closest : Numbers having less diff from the given number would be the closest number.
For example: 3,4,5,6 . Absolute diff would be (5-3,5-4,5-6) = 2,1,1. So, 4 and 6 are closest number to 5.

`Input:` K = 4, X = 35  arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}

```java
private static class Pair implements Comparable{  
    int key;  
    int value;  
  
    public Pair(int key, int value) {  
        this.key = key;  
        this.value = value;  
    }  
  
    @Override  
    public int compareTo(Object o) {  
        if (this == o) return -1;  
        Pair pair = (Pair) o;  
        return this.key - pair.key;  
    }  
}

public static void main(String[] args) {  
   int arr[]={12, 16, 22, 30, 35, 39, 42,45, 48, 50, 53, 55, 56};  
   int k = 4;  
   int x = 35;  
   int len = arr.length;  
   PriorityQueue<Pair> pq = new PriorityQueue<>();  
   ArrayList<Pair> output = new ArrayList<>();  
    for (int i = 0; i < len; i++) {  
        pq.add(new Pair(Math.abs(arr[i]-x),arr[i]));  
    }  
    pq.remove(); // remove the first element  
    while (pq.size() > 0 && k > 0){  
        k--;  
        output.add(pq.remove());  
    }  
    System.out.println(output.stream().map(pair->pair.value).sorted().toList());  
}
```

`Output:`[30, 39, 42, 45]
