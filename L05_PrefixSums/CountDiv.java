/**
 *  Tasks Details:
 *  1. CountDiv (Medium)
 *  Compute number of integers divisible by k in range [a..b].
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(1)
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        return B/K - A/K + ((A%K==0)? 1:0);
    }
}

