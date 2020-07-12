/**
 *  Tasks Details:
 *  3. MissingInteger (Medium)
 *  Find the smallest positive integer that does not occur in a given sequence.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N) or O(N * log(N))
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        boolean[] seen = new boolean[A.length+1];
        
        for(int i=0; i<A.length; i++) {
            if(A[i]>0 && A[i]<=A.length) seen[A[i]] = true;
        }
        int missing = 1;
        while(missing<seen.length) {
            if(!seen[missing]) return missing;
            missing++;
        }
        return missing;
    }
}

