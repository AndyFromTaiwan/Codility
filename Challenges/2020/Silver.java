/**
 *  2020 Silver Challenge
 *  Tasks Details:
 *  1. RectanglesStrip (Medium)
 *  From a given set choose as many rectangles with a common side as
 *  possible.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N*log(N)) or O(N)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8    
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for(int i=0; i<A.length; i++) {
            counter.put(A[i], counter.getOrDefault(A[i], 0)+1);
            if(B[i]!=A[i]) {
                counter.put(B[i], counter.getOrDefault(B[i], 0)+1);
            }
        }

        int max = 0;
        for(Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}
