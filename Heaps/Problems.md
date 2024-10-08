#Heaps 

### Identification of Heap problems
Question must have given k(th largest or smallest) and ask for smallest/largest.

K + smallest -> Max Heap  
K + largest ->  Min Heap  
nlogn -> n log k  

### How to write/use heap in Java?
Priority queue is the implementation of Heap data structure. This is not thread safe implementation of Heap. We can use PriorityBlockingQueue in multi threaded environment.

#### Time complexity
log(n) - add, offer, poll, remove  
O(n) - cotains, remove  
O(1) - peek, element, size  


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

## K Closet Points to Origin
Given a list of points on the 2-D plane and an integer K. The task is to find K closest points to the origin and print them.  
**Note**: The distance between two points on a plane is the [Euclidean distance](https://en.wikipedia.org/wiki/Euclidean_distance).

Create a Pair class to hold the X and Y axis details

```java
private static class Pair{  
    int x;  
    int y;  
  
    public Pair(int x, int y) {  
        this.x = x;  
        this.y = y;  
    }  
  
    public int getX() {  
        return x;  
    }  
  
    public void setX(int x) {  
        this.x = x;  
    }  
  
    public int getY() {  
        return y;  
    }  
  
    public void setY(int y) {  
        this.y = y;  
    }  
  
    @Override  
    public String toString() {  
        return "Pair{" +  
                "x=" + x +  
                ", y=" + y +  
                '}';  
    }  
}
```

`Input:` {{3, 3}, {5, -1}, {-2, 4}};

```java
int arr[][] = {{3, 3}, {5, -1}, {-2, 4}};  
int k = 2;  
int len = arr.length;  
/**  
 * Formula used to calculate distance between two points * sqrt (x2-x1)^2 + (y2-y1)2 */Map<Integer,Pair> map = new HashMap<>();  
for (int i = 0; i < len; i++) {  
    int sqrX = (int)Math.pow(arr[i][0],2);  
    int sqrY = (int)Math.pow(arr[i][1],2);  
    map.put(sqrX+sqrY,new Pair(arr[i][0],arr[i][1]));  
}  
  
Comparator<Map.Entry<Integer,Pair>> comparator = Comparator.comparing(Map.Entry::getKey);  
  
PriorityQueue<Map.Entry<Integer,Pair>> pq = new PriorityQueue<>(comparator);  
map.entrySet().forEach(entry -> pq.add(entry));  
while (pq.size() > 0 && k > 0){  
    System.out.println(pq.poll().getValue());  
    k--;  
}
```

`Output:` Pair{x=3, y=3} Pair{x=-2, y=4}

## Minimum Cost of ropes
There are given **N** ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths.  
The task is to connect the ropes with minimum cost. Given **N** size array **arr[]** contains the lengths of the ropes.

`Input:` {4, 3, 2, 6}

```java
int arr[]={4,2, 7, 6, 9};  
PriorityQueue<Integer> pq = new PriorityQueue<>();  
for (int num :  
        arr) {  
    pq.add(num);  
}  
int cost = 0;  
while (pq.size() >= 2){  
    int sum = pq.remove() + pq.remove();  
    cost += sum;  
    pq.add(sum);  
}  
System.out.println(cost);
```

`Output:` 29

## Sum of elements between k1th smallest and k2th smallest
Given an array of n elements, find the sum of elements greater than k1th smallest element and less than k2th smallest element of the array

`Input:` {1,3,12,5,15,11}

```java
private static int kthSmallest(int[] arr, int k){  
    PriorityQueue<Integer> pq = new PriorityQueue<>();  
    for (int num :  
            arr) {  
        pq.offer(num);  
    }  
    while (k > 1){  
        pq.poll();  
        k--;  
    }  
    return pq.poll();  
}


public static void main(String[] args) {  
        int arr[] = {1,3,12,5,15,11};  
        int k1 = 2; // kth smallest  
        int k2 = 6; // kth smallest  
        int res1,res2,sum=0;  
    // Find sum of elements greater than k1th and less than k2th  
    res1 = kthSmallest(arr,k1);  
    // Find k1th smallest element  
    res2 = kthSmallest(arr,k2);  
    for (int i = 0; i < arr.length; i++) {  
        if(arr[i] > res1 && arr[i]<res2){  
            sum += arr[i];  
        }  
    }  
    System.out.println(sum);  
}
```

`Output:` 28
