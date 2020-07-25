/**
 *  Tasks Details:
 *  3. Nesting (Easy)
 *  Determine whether a given string of parentheses (single type) 
 *  is properly nested.
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
    public int solution(String S) {
        // write your code in Java SE 8
        int stack = 0;
        
        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i)=='(') stack++;
            else if(stack<=0) return 0;
            else stack--;
        }
        return (stack==0)? 1:0;
    }
}

