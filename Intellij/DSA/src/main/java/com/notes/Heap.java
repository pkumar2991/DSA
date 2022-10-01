package com.notes;

import java.util.*;

public class Heap {


    int[] resizeHeap(int[] heap, int capacityIncreaseBy) {
        int currentCapacity = heap.length;
        int[] array_old = new int[currentCapacity];
        System.arraycopy(heap, 0, array_old, 0, currentCapacity);
        int newCapacity = currentCapacity + capacityIncreaseBy;
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

    void buildMaxHeapFromArray(int[] heap, int n) {
        if (n == 0) return;
        if (n > heap.length) {
            resizeHeap(heap, n - heap.length);
        }
        int lastInternalNode = (n / 2) - 1;
        for (int i = lastInternalNode; i >= 0; i--) {
            heapifyDown(heap, i, n);
        }
    }


    void buildMinHeapFromArray(int[] arr, int n) {
        if (n == 0) return;
        if (n > arr.length) {
            resizeHeap(arr, n - arr.length);
        }
        int lastInternalNode = (n / 2) - 1;
        for (int i = lastInternalNode; i >= 0; i--) {
            heapifyDownMinHeap(arr, i, arr.length);
        }
    }

    void heapifyDownMinHeap(int[] minHeap, int i, int heapSize) {
        if (heapSize == 0) return;
        int min = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        if (left < heapSize && minHeap[left] < minHeap[min]) {
            min = left;
        }
        if (right < heapSize && minHeap[right] < minHeap[min]) {
            min = right;
        }
        if (min != i) {
            int temp = minHeap[i];
            minHeap[i] = minHeap[min];
            minHeap[min] = temp;
            heapifyDownMinHeap(minHeap, min, heapSize);
        }
    }

    int extractMax(int[] heap, int heapSize) {
        if (heapSize == 0) return Integer.MIN_VALUE;
        // Save the Max Value
        int maxValue = heap[0];
        // Replace the Max value with the last element of Max com.notes.Heap
        heap[0] = heap[heapSize - 1];
        heap[heapSize - 1] = -1;
        // Heapify the Max heap
        heapifyDown(heap, 0, heapSize);
        return maxValue;
    }

    public void heapifyDown(int[] heap, int i, int heapSize) {
        int l, r, max = i, temp;

        l = (2 * i) + 1;
        r = (2 * i) + 2;
        if (l < heapSize && heap[l] > heap[max]) {
            max = l;
        }

        if (r < heapSize && heap[r] > heap[max]) {
            max = r;
        }
        if (max != i) { // swap the values
            temp = heap[i];
            heap[i] = heap[max];
            heap[max] = temp;
            heapifyDown(heap, max, heapSize);
        }
    }

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
        heapifyDown(heap, i, heap.length);
    }

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

    void heapSortAsc(int[] heap) {
        buildMaxHeapFromArray(heap, heap.length);
        System.out.println(Arrays.toString(heap));
        int heapSize = heap.length;
        for (int i = heapSize - 1; i > 0; i--) {
            int max = extractMax(heap, heapSize);
            heap[heapSize - 1] = max;
            heapSize--;
        }
    }

    int[] heapPush(int[] heap, int heapSize, int maxHeapSize, int newValue) {
        if (heapSize == maxHeapSize) {
            throw new StackOverflowError("com.notes.Heap Stack is Full");
        }
        return insertKey(heap, newValue);
    }

    int heapPop(int[] heap, int heapSize) throws Exception {
        if (heapSize == 0) {
            throw new Exception("com.notes.Heap Stack is empty");
        }
        return extractMax(heap, heapSize);
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
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

    int findKthLargestElt(int[] arr, int k) throws Exception {
        if (k < 1) return -1;
        buildMaxHeapFromArray(arr, arr.length); // (logN)
        for (int i = 1; i < k; i++) {
            heapPop(arr, arr.length);
        }
        return heapPop(arr, arr.length);
    }

    void topKfrequents(int[] arr, int k){
        int len = arr.length;
        if(len == 0) return;
        // Count frequency using HashMap
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){ // O(N)
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }
        Heap.Node[] nodes = new Node[map.size()];
        int i = 0;
        for(Map.Entry<Integer,Integer> key : map.entrySet()){ // O(N)
            nodes[i] = new Node(map.get(key.getKey()),key.getKey());
            i++;
        }

        // build a Max com.notes.Heap  O(N)
        int  lastInternalNode = (nodes.length/2) - 1;
        for (int j = lastInternalNode; j >=0; j--) {
            // Heapify down each node
            heapifyDownNodes(nodes,j,nodes.length);
        }
        // Pick top K frequents O(K log N)
        int size = nodes.length;
        int output[] = new int[k];
        for (int count = 1; count <= k; count++) { // O(K)

            Node node = extractMaxNodes(nodes, size);// O(log N)
            output[count - 1] = node.key;
            size--;
        }
        System.out.println(Arrays.toString(output));
    }
    Node extractMaxNodes(Node[] nodes,int size){
        // Root node would be the max node in the Max com.notes.Heap tree
        if(nodes.length == 0) return null;
        Node maxNode = nodes[0];
        nodes[0] = nodes[size -1];
        nodes[nodes.length -1] = null;
        heapifyDownNodes(nodes,0,size);
        return maxNode;
    }

    void heapifyDownNodes(Node[] nodes,int i,int size){
        if(nodes.length == 0) return;
        int max = i;
        int left = (i * 2) + 1;
        int right = (i * 2) + 2;
        if(left < size  && nodes[left] != null && nodes[left].frquency > nodes[max].frquency){
            max = left;
        }
        if(right < size && nodes[right] != null && nodes[right].frquency > nodes[max].frquency){
            max = right;
        }
        if(max != i){
            Heap.Node temp = nodes[i];
            nodes[i] = nodes[max];
            nodes[max] = temp;
            heapifyDownNodes(nodes,max, size);
        }
    }
    public static void main(String[] args) throws Exception {

//        int A[] = {3, 6, 5, 0, 8, 2, 1, 9};
//        int A[] = {2, 8, 5, 6, 3, 9, 1, 0};
//        int A[] = {2, 8, 5, 9, 11, 3, 7, 1};
        int A[] = {9,2,5,6,8};
        Heap maxHeap = new Heap();
        maxHeap.heapSortAsc(A);
        System.out.println(Arrays.toString(A));
    }
    static class Node{
        int frquency;
        int key;

        public Node(int frquency, int key) {
            this.frquency = frquency;
            this.key = key;
        }

        @Override
        public String toString() {
            return "com.notes.Node{" +
                    "frquency=" + frquency +
                    ", key=" + key +
                    '}';
        }
    }
}
