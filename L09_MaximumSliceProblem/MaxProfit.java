/**
 *  Tasks Details:
 *  2. MaxProfit (Easy)
 *  Given a log of stock prices compute the maximum possible earning.
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
        if(A.length<=1) return 0;
        
        int maxProfit = 0;
        int vally = A[0];
        
        for(int i=1; i<A.length; i++) {
            maxProfit = Math.max(maxProfit, A[i]-vally);
            vally = Math.min(vally, A[i]);
        }
        return maxProfit;
    }
}

