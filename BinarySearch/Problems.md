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

## Find count of an element in a sorted array
`Input:` {1,2,3,10,10,10,10,10,12,13};

```java
public static void main(String[] args) {  
    int arr[] = {1, 2, 3, 10, 10, 10,  10, 12, 13};  
    int firstIndex = findFirstOccurrenceOfNumber(arr, 0, arr.length - 1, 10, -1);  
    int lastIndex = findLastOccurrenceOfNumber(arr, 0, arr.length - 1, 10, -1);  
    if (firstIndex == -1 && lastIndex == -1)  
    System.out.println(0);  
else  
    System.out.println(lastIndex - firstIndex + 1);  
}
```

`Output:` 4

## Find minimum element in a sorted array / Find number of rotation in sorted array

### Thought process:
An index of a minimum element in the array defines the number of rotations in an array.

**Cases:**
1. When the leftmost value is less than the rightmost value of a sorted array, the minimum element will be present at the leftmost index. In other words is not rotated at all and we return the leftmost value.
2. When the value at the mid index is greater than the rightmost value, the minimum element would be  present on the right half.
3. When the value at mid index is lesser than the rightmost value, the minimum element would be present on the left half.

```java
private static int findNumRotation(int[] arr,int low,int high) {  
  
    if (low > high) return -1;  
    int mid = (low + high) / 2;  
    if (arr[low] < arr[high]) {  
        return low;  
    }  
  
    else if (arr[mid] > arr[high]) {  
        return findNumRotation(arr, mid + 1, high);  
    } else {  
        return findNumRotation(arr, low, mid);  
    }  
}
```

`Input:` 1,2,3,4,5,6,7,8,9,10 `Output:` 0 (index of the minimum element) - CASE 1
`Input:` 6,7,8,9,10,1,2,3,4,5 `Output:` 0 (index of the minimum element) - CASE 2
`Input:` 9,10,1,2,3,4,5,6,7,8 `Output:` 2 (index of the minimum element) - CASE 3

## Find an element in a rotated sorted array
Use the previous method to find out the index of the min element in the rotated sorted array.

```java
public static void main(String[] args) {  
    int arr[] = {10,11,12,1, 2, 3, 4, 5, 6,7,8,9};  
    int num = findNumRotation(arr,0,arr.length-1);  
    int res = findAnEltInRotatedArray(arr,0,num-1,11); // Search in unsorted array  
    int res1 = findAnEltInRotatedArray(arr,num+1,arr.length-1,11);//Search in sorted array  
    if((res > 0 || res1 > 0)){  
        System.out.println("Number found");  
    }else {  
        System.out.println("Number not found");  
    }  
}

private static int findAnEltInRotatedArray(int arr[],int start, int end,int num){  
    if(start > end) return -1;  
  
    int mid = (start + (end - start)/2);  
    if(arr[mid] ==  num)  
        return arr[mid];  
    if(arr[mid] > num)  
        return findAnEltInRotatedArray(arr,start,mid-1,num);  
    else        return findAnEltInRotatedArray(arr,mid+1,end,num);  
}
```

`Output:` Number found.

## Find a number in a nearly sorted array
Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array. Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].

```java
private static int findEltInNearlySortedArray(int arr[], int start, int end, int num){  
    if(start > end) return -1;  
    int mid = start + (end - start)/2;  
  
    if(arr[mid] == num) return  num;  
    if(mid-1 >= start && arr[mid-1] == num) return num;  
    if(mid+1 <= end && arr[mid+1] == num) return num;  
  
    if(arr[mid] > num)  
        return findEltInNearlySortedArray(arr,start,mid-2,num);  
    else        return findEltInNearlySortedArray(arr,mid+2,end,num);  
}
```

## Find floor of an element in a sorted array

```java
private static int floorOfElt(int arr[],int start,int end, int num,int res){  
    if(res < num && start > end) return res;  
    if(start > end) return -1;  
    int mid = start + (end - start)/2;  
    if(arr[mid] == num) return num;  
  
    if(arr[mid] > num) {  
        return floorOfElt(arr,start,mid -1,num,res);  
    }  
    else {  
        res = arr[mid];  
        return floorOfElt(arr,mid+1,end,num,res);  
    }  
}
```

`Input`: {1,2,3,4,8,11,15,17}  , 14
`Output`: 11

## Find ceil of an element in a sorted array

```java
private static int ceilOfElt(int arr[],int start,int end, int num,int res){  
    if ( res > num && start > end) return res;  
    if(start > end) return -1;  
    int mid = start + (end - start)/2;  
    if(arr[mid] == num) return num;  
  
    if(arr[mid] < num) {  
        return ceilOfElt(arr,mid+1,end,num,res);  
    }  
    else {  
        res = arr[mid];  
        return ceilOfElt(arr,start,mid -1,num,res);  
    }  
}
```

`Input`: {1,2,3,4,8,11,15,17}  , 14
`Output`: 15

## Find next char in a sorted array of characters
If next char is not available, return '#'.

```java
private static char findNextChar(char carr[],int start,int end, char key, char res){  
    if(res > key && start > end) return res;  
    if(start > end) return '#';  
    int mid = start + (end - start)/2;  
  
    if(carr[mid] <= key){  
        return findNextChar(carr,mid + 1,end,key,res);  
    }  
    else{  
        res = carr[mid];  
        return findNextChar(carr,start,mid -1,key,res);  
    }  
}
```

`Input:` {'a','d','e','f','j'} 'f'
`Output:` 'j'

## Find index of an element in a infinite sorted array
find the block in the infinite array in which your the key element exist.

```java
private static int findIndexOfElt(int[] arr, int key){  
    if(arr.length == 1 && key != arr[0]) return -1;  
    int start = 0;  
    int end = 1;  
    while (end < arr.length && arr[end] < key){  
        start = end;  
        end = end * 2;  
    }  
    // Found the section of array in which key exist  
    while (start <= end){  
        int mid = start + (end - start)/2;  
        if(mid > arr.length-1) return -1;  
        if(arr[mid] == key) return mid;  
        if(arr[mid] > key){  
            end = mid-1;  
        }else {  
            start = mid + 1;  
        }  
    }  
    return -1;  
}
```


## Find index of first occurrence of 1 in an infinite sorted array

- Find the block wherein 1 exist from an infinite array
- Find the first occurrence of 1

```java
private static int findFirstOccurrenceInfiniteSortedArray(int[] arr, int key){  
    if(arr.length == 1 && key != arr[0]) return -1;  
    int start = 0;  
    int end = 1;  
    while (end < arr.length && arr[end] < key){  
        start = end;  
        end = end * 2;  
    }  
    return findFirstOccurrenceOfNumber(arr,start,end,1,-1);  
  
}
```

## Find Min difference element in a sorted array
`Input:` arr = {1,2,3,4,8,11,15,17}, key = 5
If key is present, return the key as the min diff would be zero when key is present in the array, else find the neighbouring of the key element and return the neighbour which results abs min diff.

```java
private static int findMinDiffEltSortedArray(int[] arr, int key){  
  
    int start = 0;  
    int end = arr.length-1;  
  
    while (start <= end){  
        int mid = start + (end - start) / 2;  
        if(arr[mid] == key) return key;  
        if(arr[mid] < key){  
            start = mid + 1;  
        }else {  
            end = mid - 1;  
        }  
    }  
    if(Math.abs(arr[start] - key) < Math.abs(arr[end] - key)){  
        return arr[start];  
    }else{  
        return arr[end];  
    }  
}
```

`Output:` 4 