/**
 *  Tasks Details:
 *  4. Triangle (Easy)
 *  Determine whether a triangle can be built from a given set of edges.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N*log(N))
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length<3) return 0;
        
        Arrays.sort(A);
        for(int i=A.length-1; i>=2; i--) {
            //if(A[i-2]+A[i-1]>A[i]) return 1; // ptifall: overflow!
            if(A[i-1]>A[i]-A[i-2]) return 1;
        }
        return 0;
    }
}

