/**
 *  Tasks Details:
 *  2. Fish (Easy)
 *  N voracious fish are moving along a river. Calculate how many fish 
 *  are alive.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.Stack;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int aliveUpCount = 0;
        Stack<Integer> aliveDown = new Stack<Integer>();
        
        for(int i=0; i<A.length; i++) {
            if(B[i]==1) aliveDown.push(A[i]);
            else {
                while(!aliveDown.isEmpty() && A[i]>aliveDown.peek()) {
                    aliveDown.pop();
                }
                if(aliveDown.isEmpty()) aliveUpCount++;
            }
        }
        return aliveUpCount + aliveDown.size();
    }
}

