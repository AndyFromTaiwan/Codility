/**
 *  Tasks Details:
 *  1. CyclicRotation (Easy)
 *  Rotate an array to the right by a given number of steps.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: Not assessed
 *  Analysis summary: The solution obtained perfect score.
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] R = new int[A.length];
        if(A.length==0) return R;
        
        K %= A.length;
        for(int i=0; i<A.length-K; i++) {
            R[i+K] = A[i];
        }
        
        for(int i=0; i<K; i++) {
            R[K-1-i] = A[A.length-1-i];
        }   
        return R;
    }
}

