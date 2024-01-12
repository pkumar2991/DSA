## Given a sorted array of n elements, write a function to search a given element x in the array

`Input:` {1,3,5,10,11,12}, 12

```java
private static int findNumber(int[] arr, int start, int end, int key){  
    if(start > end) return -1;  
    //int mid =  (start+end/2);  
    int mid =  (start+(end-start)/2); // To avoid int overflow 
    if(arr[mid] == key) return arr[mid]; 
    
    if(arr[mid] < key){  
        return findNumber(arr,mid+1,end,key);  
    }else{  
        return findNumber(arr,start,mid-1,key);  
    }  
}
```

`Output:` 12
`Time Complexity:` log2n

## Binary Search on Reverse Sorted Array
`Input:` {12,11,9,8,4,3}, 8

```java
private static int findNumber(int[] arr, int start, int end, int key){  
    if(start > end) return -1;  
    //int mid =  (start+end/2);  
    int mid =  (start+(end-start)/2); // To avoid int overflow 
    if(arr[mid] == key) return arr[mid]; 
    
    if(arr[mid] > key){  
        return findNumber(arr,mid+1,end,key);  
    }else{  
        return findNumber(arr,start,mid-1,key);  
    }  
}
```

`Output:` 8

## Find Index of First Occurrence of a number
`Input:` {1,2,3,10,10,10,10,10,12,13};

```java
private static int findFirstOccurrenceOfNumber(int[] arr, int start, int end, int key,int res){  
    if(start > end) return res;  
    int mid =  (start+(end-start)/2);  
    if(arr[mid] == key) {  
        res = mid;  
    }  
    if(arr[mid] < key){  
        return findFirstOccurrenceOfNumber(arr,mid+1,end,key,res);  
    }else{  
        return findFirstOccurrenceOfNumber(arr,start,mid-1,key,res);  
    }  
}

public static void main(String[] args) {  
        int arr[] = {1,2,3,10,10,10,10,10,12,13};  
        int index = findFirstOccurrenceOfNumber(arr,0,arr.length-1,10,-1);  
    System.out.println(index);  
}
```

`Output:` 3

## Find Index of Last Occurrence of a number
`Input:` {1,2,3,10,10,10,10,10,12,13};

```java
private static int findLastOccurrenceOfNumber(int[] arr, int start, int end, int key,int res){  
    if(start > end) return res;  
    int mid =  (start+(end-start)/2);  
    if(arr[mid] == key) {  
        res = mid;  
    }  
    if(arr[mid] <= key){  
        return findLastOccurrenceOfNumber(arr,mid+1,end,key,res);  
    }else{  
        return findLastOccurrenceOfNumber(arr,start,mid-1,key,res);  
    }  
}

public static void main(String[] args) {  
    int arr[] = {1, 2, 3, 10, 10, 10, 10, 10, 12, 13};  
    int index = findLastOccurrenceOfNumber(arr, 0, arr.length - 1, 10, -1);  
    System.out.println(index);  
}
```

`Output:` 7