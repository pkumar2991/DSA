#DSA #Sorting

### Bubble Sort
```java
void bubbleSort(int[] arr) {  
    boolean sorted;  
    for (int i = 0; i < arr.length; i++) {  
        sorted = true;  
        for (int j = 0; j < arr.length - i - 1; j++) {  
            if (arr[j] > arr[j + 1]) {  
                int temp = arr[j + 1];  
                arr[j + 1] = arr[j];  
                arr[j] = temp;  
                sorted = false;  
            }  
        }  
        if (sorted) return;  
    }  
}
```

_If there is no swapping in a particular pass, it means the array has become sorted, so we should not perform the further passes._

`Input:` 1, 4, 9, 6, 3\
`Output:` 1, 3, 4, 6 ,9

`Time Complexity:` O(n)\
`Space Complexity:` O(1)

### Selection Sort
```java
void selectionSort(int[] arr) {  
    for (int i = 0; i < arr.length - 1; i++) {  
        int min = i;  
        for (int j = i + 1; j < arr.length; j++) {  
            if (arr[j] < arr[i]) {  
                min = j;  
            }  
        }  
        if (min != i) {  
            int temp = arr[i];  
            arr[i] = arr[min];  
            arr[min] = temp;  
        }  
    }  
}
```

`Input:` 1, 4, 9, 6, 3\
`Output:` 1, 3, 4, 6 ,9

`Time Complexity:` O(n^2)\
`Space Complexity:` O(1)

### Insertion Sort
```java
void insertionSort(int[] arr) {  
    for (int i = 0; i < arr.length; i++) {  
        int value = arr[i];  
        int hole = i;  
        while (hole > 0 && arr[hole - 1] > value) {  
            arr[hole] = arr[hole - 1];  
            hole = hole - 1;  
        }  
        arr[hole] = value;  
    }  
}
```

`Input:` 1, 4, 9, 6, 3\
`Output:` 1, 3, 4, 6 ,9

`Time Complexity:` O(n^2)\
`Space Complexity:` O(1)

### Merge Sort
```java
void merge(int[] left, int[] right, int[] arr) {  
    int i = 0;  
    int j = 0;  
    int k = 0;  
  
    //Left Array  
    while (i < left.length && j < right.length) {  
        if (left[i] <= right[j]) {  
            arr[k] = left[i];  
            i++;  
            k++;  
        } else {  
            arr[k] = right[j];  
            j++;  
            k++;  
        }  
    }  
    while (i < left.length) {  
        arr[k] = left[i];  
        i++;  
        k++;  
    }  
    while (j < right.length) {  
        arr[k] = right[j];  
        j++;  
        k++;  
    }  
}  
  
void mergeSort(int[] arr) {  
    int n = arr.length;  
    if (n < 2) return;  
    int mid = (n / 2);  
    int left[] = new int[mid];  
    int right[] = new int[n - mid];  
    for (int i = 0; i < mid; i++) {  
        left[i] = arr[i];  
    }  
    int k = mid;  
    for (int i = 0; i < (n - mid); i++) {  
        right[i] = arr[k];  
        k++;  
    }  
    mergeSort(left);  
    mergeSort(right);  
    merge(left, right, arr);  
}
```

`Input:` 1, 4, 9, 6, 3\
`Output:` 1, 3, 4, 6 ,9

`Time Complexity:` O(n log n)\
`Space Complexity:` O(n)

### Heap Sort
```java
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
```

`Input:` 1, 4, 9, 6, 3\
`Output:` 1, 3, 4, 6 ,9

`Time Complexity:` O(n log n)\
`Space Complexity:` O(1)

### Quick Sort
```java
int partition(int[] arr, int start, int end) {  
    if (arr.length == 0) return -1;  
    int pivot = arr[end];  
    int pIndex = start;  
    for (int i = start; i < end; i++) {  
        if (arr[i] <= pivot) {  
            int temp = arr[i];  
            arr[i] = arr[pIndex];  
            arr[pIndex] = temp;  
            pIndex++;  
        }  
    }  
    int temp = arr[pIndex];  
    arr[pIndex] = pivot;  
    arr[end] = temp;  
    return pIndex;  
}  
  
void quickSort(int[] arr, int start, int end) {  
    if (start < end) {  
        int pIndex = partition(arr, start, end);  
        quickSort(arr, start, pIndex - 1);  
        quickSort(arr, pIndex + 1, end);  
    }  
}
```


`Input:` 1, 4, 9, 6, 3\
`Output:` 1, 3, 4, 6 ,9

`Time Complexity:` O(n^2)\
`Space Complexity:` O(n logn)

