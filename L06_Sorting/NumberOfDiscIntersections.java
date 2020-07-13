/**
 *  Tasks Details:
 *  3. NumberOfDiscIntersections (Medium)
 *  Compute the number of intersections in a sequence of discs.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N*log(N)) or O(N)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        long N = A.length;
        long count = N*(N-1)/2; // upper-bound of intersections
        
        long[] leftBounds = new long[A.length];
        long[] rightBounds = new long[A.length];
        
        for(int i=0; i<A.length; i++) {
            leftBounds[i] = (long) i - A[i];
        }
        Arrays.sort(leftBounds);
        
        for(int i=0; i<A.length; i++) {
            rightBounds[i] = (long) i + A[i];
        }
        Arrays.sort(rightBounds);
        
        int i=0;
        int j=0;
        while(i<A.length && j<A.length) {
            if(leftBounds[i]>rightBounds[j]) {
                // cannot intersect with this one and all following disks
                count -= N;
                j++;
            }
            else {
                N--;
                i++;
            }
        }
        
        return (count>10000000)? -1 : (int) count;
    }
}

