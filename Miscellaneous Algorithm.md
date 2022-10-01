### Moore Voting Algorithm
The **Boyer–Moore majority vote algorithm** is an [algorithm](https://en.wikipedia.org/wiki/Algorithm "Algorithm") for finding the [majority](https://en.wikipedia.org/wiki/Majority "Majority") of a sequence of elements using [linear time](https://en.wikipedia.org/wiki/Linear_time "Linear time") and constant space. It is named after [Robert S. Boyer](https://en.wikipedia.org/wiki/Robert_S._Boyer "Robert S. Boyer") and [J Strother Moore](https://en.wikipedia.org/wiki/J_Strother_Moore "J Strother Moore"), who published it in 1981,[[1]](https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm#cite_note-bm-1) and is a prototypical example of a [streaming algorithm](https://en.wikipedia.org/wiki/Streaming_algorithm "Streaming algorithm").

In its simplest form, the algorithm finds a majority element, if there is one: that is, an element that occurs repeatedly for more than half of the elements of the input.

**Provided** : Majority Candidate must be greater or equal than N/2 where N > 2.

```java
int findMajorityCandidate(int[] arr) {  
    if (arr.length == 0) return -1;  
    else if (arr.length == 1) {  
        return arr[0];  
    } else {  
        /*Find the eligible majority Candidate*/  
        int count = 1;  
        int candidate = arr[0];  
        for (int i = 1; i < arr.length; i++) {  
            if (candidate == arr[i]) {  
                count++;  
            } else {  
                count--;  
            }  
            if (count == 0) {  
                candidate = arr[i];  
                count++;  
            }  
        }  
        /*Check if it has majority*/  
        count = 0;  
        for (int i = 0; i < arr.length; i++) {  
            if (candidate == arr[i]) {  
                count++;  
            }  
        }  
        if (count >= (arr.length / 2)) {  
            return candidate;  
        }  
    }  
    return -1;  
}
```

`Time Complexity:` O(n)\
`Space Complexity:` O(1)


