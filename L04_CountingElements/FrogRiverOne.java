/**
 *  Tasks Details:
 *  1. FrogRiverOne (Easy)
 *  Find the earliest time when a frog can jump to the other side of a river.
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
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        boolean [] leaves = new boolean[X];
        
        for(int i=0; i<A.length; i++) {
            if(!leaves[A[i]-1]) {
                if(X==1) return i;
                else {
                    leaves[A[i]-1] = true;
                    X--;
                }
            }
        }
        return -1;
    }
}

