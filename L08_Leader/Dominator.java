/**
 *  Tasks Details:
 *  1. Dominator (Easy)
 *  Find an index of an array such that its value occurs at more than
 *  half of indices in the array.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N*log(N)) or O(N)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.Map;
import java.util.HashMap;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int threshold = A.length/2;
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        
        for(int i=0; i<A.length; i++) {
            int count = counter.getOrDefault(A[i], 0) + 1;
            if(count > threshold) return i;
            else counter.put(A[i], count);
        }
        return -1;
    }
}

