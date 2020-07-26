/**
 *  Tasks Details:
 *  4. Peaks (Medium)
 *  Divide an array into the maximum number of same-sized blocks,
 *  each of which should contain an index P such that A[P - 1] < A[P]
 *  > A[P + 1].
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N * log(log(N)))
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] peaks = new int[A.length];
        int count = 0;
        
        for(int i=1; i<peaks.length-1; i++) {
            if(A[i]>A[i-1] && A[i]>A[i+1]) {
                count++;
            }
            peaks[i] = count;
        }
        peaks[peaks.length-1] = count; // pitfall!
        if(count<=1) return count;
        
        // note that A.length/2 is impossible!
        for(int i=A.length/3; i>=2; i--) {
            if(isValidPartition(peaks, i)) return i;
        }
        return 1;
    }
    
    
    private boolean isValidPartition(int[] peaks, int blockCount) {
        if(peaks.length%blockCount != 0) return false;        
        int n = peaks.length/blockCount;

        // checks every block contains at least one peak
        if(peaks[n-1]==0) return false;
        for(int i=peaks.length-1; i>n-1; i-=n) {
            if(peaks[i]<=peaks[i-n]) return false;
        }
        return true;
    }
}

