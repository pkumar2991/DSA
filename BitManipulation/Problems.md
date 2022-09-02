1. Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2  
Output: [0,1,1]  
Explanation:  
0 --> 0  
1 --> 1  
2 --> 10  

Example 2:

Input: n = 5  
Output: [0,1,1,2,1,2]  
Explanation:  
0 --> 0  
1 --> 1  
2 --> 10  
3 --> 11  
4 --> 100  
5 --> 101

[Counting Bits](https://leetcode.com/problems/counting-bits/)

```java
int[] countingBits1(int n) {  
    int output[] = new int[n + 1];  
    for (int i = 0; i <= n; i++) {  
        int num = i;  
        int count = 0;  
        while (num != 0) {  
            num = num & num - 1;  
            count++;  
        }  
        output[i] = count;  
    }  
    return output;  
}
```

`Time Complexity:` O(n^2)\
`Space Complexity:` O(n)

*Better approach*

```java
int[] countingBits2(int n) {  
    int output[] = new int[n + 1];  
    for (int i = 1; i <= n; i++) {  
       output[i] = output[i>>1] + (i & 1);  
    }  
    return output;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(n)