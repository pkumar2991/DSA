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