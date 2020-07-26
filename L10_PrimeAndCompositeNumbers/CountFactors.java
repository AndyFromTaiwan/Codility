/**
 *  Tasks Details:
 *  1. CountFactors (Easy)
 *  Count factors of given number n.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(sqrt(N))
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int num = 0;
        
        int sqrt = (int) Math.sqrt(N);
        for(int i=1; i<=sqrt; i++) {
            if(N%i == 0) num += 2;
        }
        if(sqrt*sqrt == N) num--;
        
        return num;
    }
}

