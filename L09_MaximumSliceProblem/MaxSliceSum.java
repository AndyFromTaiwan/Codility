/**
 *  Tasks Details:
 *  3. MaxSliceSum (Easy)
 *  Find a maximum sum of a compact subsequence of array elements.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N)
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length==0) return 0;
        
        int maxSum = A[0]; // pitfall: not 0!
        int maxLocalSum = A[0];
        
        for(int i=1; i<A.length; i++) {
            if(maxLocalSum<0) maxLocalSum = 0;
            maxLocalSum += A[i];
            maxSum = Math.max(maxSum, maxLocalSum);
        }
        return maxSum;
    }
}

