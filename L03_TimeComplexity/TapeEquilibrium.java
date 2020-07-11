/**
 *  Tasks Details:
 *  3. TapeEquilibrium (Easy)
 *  Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
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
        int minDifference = Integer.MAX_VALUE;
        
        int sum = 0;
        for(int i=0; i<A.length; i++) {
            sum += A[i];
        }
        
        for(int i=0; i<A.length-1; i++) {
            sum -= 2*A[i];
            minDifference = Math.min(minDifference, Math.abs(sum));
        }
        return minDifference;
    }
}

