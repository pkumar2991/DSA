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

## TOP K frequent Numbers

Given an array of ****N**** numbers and a positive integer ****K****. The problem is to find ****K**** numbers with the most occurrences, i.e., the top ****K**** numbers having the maximum frequency. If two numbers have the same frequency then the number with a larger value should be given preference. The numbers should be displayed in decreasing order of their frequencies. It is assumed that the array consists of at least K numbers.

`Input:`  arr[]={7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9}, K= 4

```java
int arr[]={7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};  
int k = 4;  
int len = arr.length;  
  
Map<Integer,Integer> map = new HashMap<>();  
for(int num : arr){  
    map.put(num,map.getOrDefault(num,0)+1);  
}  
Comparator<Map.Entry<Integer,Integer>> comparator = (a,b) -> {  
    return b.getValue().equals(a.getValue()) ? b.getKey().compareTo(a.getKey()) : Integer.compare(b.getValue(),a.getValue());  
};  
  
PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(2,comparator);  
map.entrySet().forEach(entry -> pq.add(entry));  
while (k > 0){  
    k--;  
    System.out.print(pq.poll().getKey()+" ");  
}
```

`Output:` 5 11 7 10

## Frequency Sort

Print the elements of an array in the decreasing frequency if 2 numbers have the same frequency then print the one which came first.

`Input:` arr[] = {2, 5, 2, 8, 5, 6, 8, 8}

```java
int arr[]={2, 5, 2, 8, 5, 6, 8, 8};  
int len = arr.length;  
  
Map<Integer,Integer> map = new HashMap<>();  
for(int num : arr){  
    map.put(num,map.getOrDefault(num,0)+1);  
}  
Comparator<Map.Entry<Integer,Integer>> comparator = (a,b) -> {  
    return b.getValue().compareTo(a.getValue()) == 0 ? a.getKey().compareTo(b.getKey()) : b.getValue().compareTo(a.getValue());  
};  
  
PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(2,comparator);  
map.entrySet().forEach(entry -> pq.add(entry));  
while (pq.size() > 0){  
    Map.Entry<Integer,Integer> entry = pq.poll();  
    for(int i = 0; i < entry.getValue(); i++){  
        System.out.print(entry.getKey() + " ");  
    }  
}
```

`Output:` 8 8 8 2 2 5 5 6