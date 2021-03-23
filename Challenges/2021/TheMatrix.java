/**
 *  2021 The Matrix Challenge
 *  Tasks Details:
 *  1. MaxSquareOnMatrix (Medium)
 *  Find the side length of the biggest black square in a matrix. In each 
 *  column, black cells start at the bottom of the matrix and count up.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N * log(N)) or O(N)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Deque<Integer> q = new LinkedList<Integer>();
        int maxSide = 0;
        int left = 0;

        for(int right = 0; right<A.length; right++) {
            if(A[right]<=maxSide) {
                left = right+1;
                q.clear();
                continue;
            }
            
            while(!q.isEmpty() && A[q.peekFirst()]<=maxSide) {
                left = q.pollFirst()+1;
            }
            while(!q.isEmpty() && A[q.peekLast()]>A[right]) {
                q.pollLast();
            }
            q.addLast(right);
            maxSide = Math.max(maxSide, right-left+1);
        }
        return maxSide;
    }
}
