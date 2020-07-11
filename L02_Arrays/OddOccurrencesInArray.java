/**
 *  Tasks Details:
 *  2. OddOccurrencesInArray (Easy)
 *  Find value that occurs in odd number of elements.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N) or O(N*log(N))
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int unpaired = 0;
        
        for(int i=0; i<A.length; i++) {
            unpaired ^= A[i];
        }
        return unpaired;
    }
}

