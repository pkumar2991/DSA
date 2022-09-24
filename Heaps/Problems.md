#Heaps 

1. #leetCode [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)

```java
public int lastStoneWeight(int[] stones) {  
    if (stones.length == 1) return stones[0];  
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});  
    for (int i = 0; i < stones.length; i++) { // NLogN  
        pq.add(stones[i]);  
    }  
    while (!pq.isEmpty() && pq.size() > 1) {  
        int x = pq.poll();  
        int y = pq.poll();  
        if (x != y) {  
            if (x > y) pq.add(x - y);  
            else  
                pq.add(y - x);  
        }  
    }  
    if (pq.isEmpty()) return 0;  
    else  
        return pq.poll();  
}
```

`Input:` [2,7,4,1,8,1]\
`Output:` 1

`Time Complexity:` O(n log n)\
`Space Complexity:`  O(log n) -- considering the recursion

2. Find Kth largest element in Max Heap.

```java
int findKthLargestElt(int[] arr, int k) throws Exception {  
    if (k < 1) return -1;  
    buildMaxHeapFromArray(arr, arr.length); // (log N)  
    for (int i = 1; i < k; i++) {  
        heapPop(arr, arr.length);  
    }  
    return heapPop(arr, arr.length);  
}
```

*In case of Min Heap, to get the Kth largest element, need to heapPop  (N-k) times and the largest element would be at position N-K+1*

`Input:` [2, 8, 5, 9, 11, 3, 7, 1], 7\
`Output:` 2

`Time Complexity:` O(n log n)\
`Space Complexity:`  O(log n) -- considering the recursion

2. #leetCode [Top K frequent elements](https://leetcode.com/problems/top-k-frequent-elements/)

```java
void topKfrequents(int[] arr, int k) {  
    int len = arr.length;  
    if (len == 0) return;  
    // Count frequency using HashMap  
    Map<Integer, Integer> map = new HashMap<>();  
    for (int num : arr) { // O(N)  
        if (map.containsKey(num)) {  
            map.put(num, map.get(num) + 1);  
        } else {  
            map.put(num, 1);  
        }  
    }  
    Heap.Node[] nodes = new Node[map.size()];  
    int i = 0;  
    for (Map.Entry<Integer, Integer> key : map.entrySet()) { // O(N)  
        nodes[i] = new Node(map.get(key.getKey()), key.getKey());  
        i++;  
    }  
  
    // build a Max Heap  O(N)  
    int lastInternalNode = (nodes.length / 2) - 1;  
    for (int j = lastInternalNode; j >= 0; j--) {  
        // Heapify down each node  
        heapifyDownNodes(nodes, j, nodes.length);  
    }  
    // Pick top K frequents O(K log N)  
	int output[] = new int[k];  
	for (int count = 1; count <= k; count++) { // O(K)  
	    Node node = extractMaxNodes(nodes, size);// O(log N)  
	    output[count - 1] = node.key;  
	    size--;  
	}  
}  
  
Node extractMaxNodes(Node[] nodes, int size) {  
    // Root node would be the max node in the Max Heap tree  
    if (nodes.length == 0) return null;  
    Node maxNode = nodes[0];  
    nodes[0] = nodes[size - 1];  
    nodes[nodes.length - 1] = null;  
    heapifyDownNodes(nodes, 0, size);  
    return maxNode;  
}  
  
void heapifyDownNodes(Node[] nodes, int i, int size) {  
    if (nodes.length == 0) return;  
    int max = i;  
    int left = (i * 2) + 1;  
    int right = (i * 2) + 2;  
    if (left < size && nodes[left] != null && nodes[left].frquency > nodes[max].frquency) {  
        max = left;  
    }  
    if (right < size && nodes[right] != null && nodes[right].frquency > nodes[max].frquency) {  
        max = right;  
    }  
    if (max != i) {  
        Heap.Node temp = nodes[i];  
        nodes[i] = nodes[max];  
        nodes[max] = temp;  
        heapifyDownNodes(nodes, max, size);  
    }  
}
```

`Input:` [1,1,1,2,2,3], k = 2\
`Output:` [1, 2]

`Time Complexity:` O(K log N)\
`Space Complexity:`  O(log n) -- considering the recursion