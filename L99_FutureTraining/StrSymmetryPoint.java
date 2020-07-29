/**
 *  Tasks Details:
 *  4. StrSymmetryPoint (Easy)
 *  Find a symmetry point of a string, if any.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(length(S))
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        if(S.length()%2==0) return -1;
        
        int center = S.length()/2;
        int left = center - 1;
        int right = center + 1;
        
        while(left>=0) {
            if(S.charAt(left) != S.charAt(right)) return -1;
            left--;
            right++;
        }
        return center;
    }
}

