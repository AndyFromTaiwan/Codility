/**
 *  Tasks Details:
 *  3. MinPerimeterRectangle (Easy)
 *  Find the minimal perimeter of any rectangle whose area equals N.
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
        int sqrt = (int) Math.sqrt(N);
 
        for(int i=sqrt; i>=1; i--) {
            if(N%i==0) return 2 * (i+N/i);
        }
        return 0;
    }
}

