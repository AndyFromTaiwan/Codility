/**
 *  Tasks Details:
 *  1. Distinct (Easy)
 *  Compute number of distinct values in an array.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N*log(N)) or O(N)
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int distinctCount = 0;
        
        boolean[] seenValues = new boolean[2000001];
        for(int i=0; i<A.length; i++) {
            if(!seenValues[A[i]+1000000]) {
                seenValues[A[i]+1000000] = true;
                distinctCount++;
            }
        }
        return distinctCount;
    }
}

