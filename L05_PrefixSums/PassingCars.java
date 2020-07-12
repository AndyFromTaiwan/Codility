/**
 *  Tasks Details:
 *  4. PassingCars (Easy)
 *  Count the number of passing cars on the road.
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
        int countPairs = 0;
        int incrPairs = 0;
        
        for(int i=0; i<A.length; i++) {
            if(A[i]==0) incrPairs++;
            else countPairs += incrPairs;
            
            if(countPairs > 1000000000) return -1;
        }
        return countPairs;
    }
}

