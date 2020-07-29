/**
 *  Tasks Details:
 *  2. TieRopes (Easy)
 *  Tie adjacent ropes to achieve the maximum number of ropes 
 *  of length >= K.
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
    public int solution(int K, int[] A) {
        // write your code in Java SE 8
        int num = 0;
        int length = 0;
        
        for(int i=0; i<A.length; i++) {
            length += A[i];
            if(length>=K) {
                num++;
                length = 0;
            }
        }
        return num;
    }
}

