#BinarySearch #leetCode 

[Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

```java
int[] twoSum(int[] numbers, int target) {  
    int low = 0;  
    int high = numbers.length - 1;  
    while (low <= high) {  
        int value = numbers[low] + numbers[high];  
        if (value == target) {  
            return new int[]{low + 1, high + 1};  
        }  
        if (value < target) {  
            low++;  
        } else {  
            high--;  
        }  
    }  
    return new int[]{};  
}
```

`Input:` -1, 0  target= -1\
`Output:` [1,2]

`Time Complexity:` O(log n)\
`Space Complexity:` O(1)

[Count Negative Numbers in a Sorted Matrix](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/)

```java
int countNegatives(int[][] grid) {  
    int count = 0;  
    for (int[] nums : grid) {  
        int left = 0;  
        int right = nums.length - 1;  
        while (left < right) {  
            int mid = left + (right - left) / 2;  
            if (nums[mid] >= 0) {  
                left = mid + 1;  
            } else {  
                right = mid - 1;  
            }  
        }
        count = count + (nums.length - left) - 1;  
        if (nums[left] < 0) count++;  
    }  
    return count;  
}
```

**Key points**
- Elemets are sorted in descending order
- If an element is negative, any number after that would be negative
- Binary search returns the first Negative number index placed at **left** index.
- *(nums.length - left)* would return the count of numbers lies between **left** and **right**
- At first we are excluding the **left** element count and adding in the total only if the left value is negative.

`Time Complexity:` O(m log n)\
`Space Complexity:` O(1)
