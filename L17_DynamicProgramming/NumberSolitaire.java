/**
 *  Tasks Details:
 *  2. NumberSolitaire (Medium)
 *  In a given array, find the subset of maximal sum in which the
 *  distance between consecutive elements is at most 6.
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
        for(int i=1; i<A.length; i++) {
            int max = A[i-1];
            for(int j=2; j<=6 && j<=i; j++) {
                max = Math.max(max, A[i-j]);
            }
            A[i] = max + A[i];
        }
        return A[A.length-1];
    }
}

