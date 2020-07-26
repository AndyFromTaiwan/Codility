/**
 *  Tasks Details:
 *  2. Flags (Medium)
 *  Find the maximum number of flags that can be set on mountain peaks.
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
        int peakCount = countPeaks(A);
        if(peakCount<=1) return peakCount; //includes all A.length<5 cases
    
        // A natural upper-bound of flags count n is:
        // A.length-3 >= n*(n-1)
        // Uses the quadratic equation formula solution to obtain n
        int minDist = (int) (1+Math.sqrt(1+4*(A.length-3)))/2;
        minDist = Math.min(minDist, peakCount);

        // Binary Search
        int left = 3;
        int right = minDist+1;
        while(left<right) {
            int mid = left+(right-left)/2;
            if(mid > countValidFlags(A, mid)) right = mid;
            else left = mid+1;
        }
        return left-1;
    }
    
    
    private int countValidFlags(int[] A, int dist) {
        int count = 0;
        int i = 1;
        while(i<A.length-1) {
            if(A[i]>A[i-1] && A[i]>A[i+1]) {
                count++;
                if(count==dist) return count;
                i += dist;
            }
            else i++;
        }
        return count;    
    }
    
    
    private int countPeaks(int[] A) {
        int count = 0;
        for(int i=1; i<A.length-1; i++) {
            if(A[i]>A[i-1] && A[i]>A[i+1]) count++;
        }
        return count;
    }
}

