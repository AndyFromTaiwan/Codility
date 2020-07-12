/**
 *  Tasks Details:
 *  3. MinAvgTwoSlice (Medium)
 *  Find the minimal average of any slice containing at least two elements.
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
        int minStart = 0;
        double minAvg = (A[0]+A[1])/2.0;

        /* 
           Explanation:
                Every slice must be of size 2 or 3. Slices of bigger sizes are
           created from such smaller slices. Therefore should any bigger slice
           have an optimal value, all sub-slices must be the same, for this 
           case to hold true. Should this not be true, one of the sub-slices 
           must be the optimal slice. The others being bigger. 
           Therefore we check all possible slices of size 2/3 and return the 
           smallest one. 
        */
        for(int i=2; i<A.length; i++) {
            double avgPreTwo = (A[i-1]+A[i])/2.0;
            if(avgPreTwo<minAvg) {
                minAvg = avgPreTwo;
                minStart = i-1;
            }
            double avgPreThree = (A[i-2]+A[i-1]+A[i])/3.0;
            if(avgPreThree<minAvg) {
                minAvg = avgPreThree;
                minStart = i-2;
            }
        }
        return minStart;
    }
}

