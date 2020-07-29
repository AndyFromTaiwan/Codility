/**
 *  Tasks Details:
 *  1. MaxNonoverlappingSegments (Easy)
 *  Find a maximal set of non-overlapping segments.
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
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        if(A.length<=1) return A.length;
        
        int num = 1;
        int minStart = B[0];
        
        for(int i=1; i<A.length; i++) {
            if(A[i]>minStart) {
                num++;
                minStart = B[i];
            }
        }
        return num;
    }
}

