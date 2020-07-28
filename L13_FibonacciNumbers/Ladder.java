/**
 *  Tasks Details:
 *  2. Ladder (Medium)
 *  Count the number of different ways of climbing to the top of a ladder.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(L)
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int maxL = 0;
        for(int i=0; i<A.length; i++) {
            maxL = Math.max(maxL, A[i]);
        }
        int maxP = 1<<30;
        
        int[] ways = new int[1+maxL];
        ways[0] = 1;
        ways[1] = 1;
        for(int i=2; i<ways.length; i++) {
            ways[i] = (ways[i-1] + ways[i-2]) % maxP;
        }
        
        int[] nums = new int[A.length];
        for(int i=0; i<A.length; i++) {
            nums[i] = ways[A[i]] % (1<<B[i]);
        }
        return nums;
    }
}

