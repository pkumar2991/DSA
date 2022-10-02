#leetCode  #BitManipulation 

1. [Counting Bits](https://leetcode.com/problems/counting-bits/)

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

2. Reverse bits of a given 32 bits unsigned integer.
[Reverse Bits](https://leetcode.com/problems/reverse-bits/)

```java
int reverseBits(int n) {  
    int res = 0;  
    for (int i = 31; i >= 0; i--) {  
        if ((n & 1) != 0)  
            res = res | (n & 1) << i;  
        n = n >> 1;  
    }  
    return res;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)

3. No of 1 bits in the given number (**Hamming Weight**)
[Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)

```java
int noOfOneBits(int n) {  
    int count = 0;  
    while (n != 0) {  
        n = n & n - 1;  
        count++;  
    }  
    return count;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)

4. Find the total number of set bits.(**Hamming Distance**)
[Hamming Distance](https://leetcode.com/problems/hamming-distance/)

```java
int findHammingDistance(int x, int y) {  
    int xor = x ^ y;  
    int count = 0;  
    while (xor != 0) {  
        xor = xor & xor - 1;  
        count++;  
    }  
    return count;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)

5. Find Bitwise AND of Numbers Range
[Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/)

```java
int rangeBitwiseAnd(int left, int right) {  
    int shiftCount = 0;  
    while (left != right) {  
        left = left >> 1;  
        right = right >> 1;  
        shiftCount++;  
    }  
    return left << shiftCount;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)

6. Find if the number is power of 2.
[Power of Two](https://leetcode.com/problems/power-of-two/)

```java
public boolean isPowerOfTwo(int n) {
      if (n <= 0) return false;
        return (n & (n-1)) == 0;
}
```

`Time Complexity:` O(1)\
`Space Complexity:` O(1)

7. [Single Number - II ](https://leetcode.com/problems/single-number-ii/submissions/)

**Best Solution**

```java
int singleNumber2(int nums[]) {  
    int one = 0;  
    int two = 0;  
  
    for (int num : nums) {  
        one = (one ^ num) & (~two);  
        two = (two ^ num) & (~one);  
    }  
    return one;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)

**Alternate approach**
```java
int singleNumber2Alt(int[] nums) {  
    int len = nums.length;  
    if (len == 0) return -1;  
    if (len == 1) return nums[0];  
    Arrays.sort(nums);  
    if (nums[0] != nums[1]) {  
        return nums[0];  
    } else if (nums[len - 1] != nums[len - 2]) {  
        return nums[len - 1];  
    } else {  
        for (int i = 1; i < len; i += 3) {  
            if (nums[i] != nums[i - 1]) {  
                return nums[i - 1];  
            }  
        }  
    }  
    return -1;  
}
```

`Time Complexity:` O(n logn) + O(n)\
`Space Complexity:` O(1)

8. [Sum Of 2 Integers](https://leetcode.com/problems/sum-of-two-integers/)

```java
int sumOfTwoIntegers(int a, int b) {  
    while (b != 0) {  
        int temp = (a & b) << 1;  
        a = a ^ b;  
        b = temp;  
    }  
    return a;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)

9. [Single Number III](https://leetcode.com/problems/single-number-iii/)

```java
public int[] singleNumber(int[] nums) {  
    int xor = 0;  
    int x = 0;  
    int y = 0;  
    for (int num : nums) {  
        xor ^= num;  
    }  
    int rmsb = xor & (-xor);  
    for (int num : nums) {  
        if ((num & rmsb) == 0) {  
            x ^= num;  
        } else {  
            y ^= num;  
        }  
    }  
    return new int[]{x, y};  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)

10. [Power of Four](https://leetcode.com/problems/power-of-four/description/)

```java
public boolean isPowerOfFour(int n) {  
    int temp = Integer.parseInt("1010101010101010101010101010101",2);  
    return (n > 0 && (n & (n-1)) == 0 && (n & temp) != 0);  
}
```

`Time Complexity:` O(1)\
`Space Complexity:` O(1)

11. [Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)

```java

```