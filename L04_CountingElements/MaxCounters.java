/**
 *  Tasks Details:
 *  2. MaxCounters (Medium)
 *  Calculate the values of counters after applying all alternating operations:
 *  increase counter by 1; set value of all counters to current maximum.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N+M)
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] counters = new int[N];
        int maxValue = 0;
        int offset = 0;
        boolean isLastMaxCounter = true; // reduces redundant opertions
        
        for(int i=0; i<A.length; i++) {
            //if(A[i]>N) maxCounter(counters, maxValue); // timeout errors!
            if(A[i] <= N) {
                maxValue = increaseX(A[i], counters, maxValue);
                isLastMaxCounter = false;
            }
            else if(!isLastMaxCounter) {
                counters = new int[N];
                offset += maxValue;
                maxValue = 0;
                isLastMaxCounter = true;
            }
        }

        //sets max counter by adding offset only once to prevent timeout errors
        maxCounter(counters, offset);
        return counters;
    }
    
    
    private void maxCounter(int[] counters/*, int maxValue*/, int offset) {
        for(int i=0; i<counters.length; i++) {
            //counters[i] = maxValue;
            counters[i] += offset;
        }
    }
    
    
    private int increaseX(int X, int[] counters, int maxValue) {
        counters[X-1]++;
        return Math.max(maxValue, counters[X-1]);
    }
}

