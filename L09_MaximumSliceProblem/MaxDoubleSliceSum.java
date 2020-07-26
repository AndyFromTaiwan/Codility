/**
 *  Tasks Details:
 *  1. MaxDoubleSliceSum (Medium)
 *  Find the maximal sum of any double slice.
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
        
        // finds max slice values center at all Y
        int[] maxSlices = new int[A.length-2];
        
        // prefix fraction of the double slice
        int slice = 0;
        for(int i=1; i<maxSlices.length; i++) {
            slice = Math.max(slice+A[i], 0);
            maxSlices[i] = slice;
        }
        
        // postfix fraction of the double slice
        slice = 0;
        for(int i=maxSlices.length-2; i>=0; i--) {
            slice = Math.max(slice+A[i+2], 0);
            maxSlices[i] += slice;
        }
        
        int maximalSum = 0;
        for(int i=0; i<maxSlices.length; i++) {
            maximalSum = Math.max(maximalSum, maxSlices[i]);
        }
        return maximalSum;
    }
}

