/**
 *  Tasks Details:
 *  4. PermCheck (Easy)
 *  Check whether array A is a permutation.
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
        boolean[] seen = new boolean[A.length];
        
        for(int i=0; i<A.length; i++) {
            if(A[i]>=1 && A[i]<=A.length && !seen[A[i]-1]) seen[A[i]-1] = true;
            else return 0;
        }
        return 1;
    }
}

