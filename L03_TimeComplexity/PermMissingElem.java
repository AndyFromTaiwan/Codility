/**
 *  Tasks Details:
 *  2. PermMissingElem (Easy)
 *  Find the missing element in a given permutation.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N) or O(N * log(N))
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        long N = A.length;// pitfall: sum overflow
        long sum = (N+2)*(N+1)/2;
        
        for(int i=0; i<A.length; i++){
            sum -= A[i];
        }
        return (int) sum;
    }
}

