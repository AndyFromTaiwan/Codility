/**
 *  Tasks Details:
 *  1. CountNonDivisible (Medium)
 *  Calculate the number of elements of an array that are not divisors 
 *  of each element.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N * log(N))
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.Map;
import java.util.HashMap;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int[] nums = new int[N];

        // uses counter to reduce computation on duplicate elements;
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for(int i=0; i<N; i++) {
            counter.put(A[i], counter.getOrDefault(A[i], 0)+1);
        }
        
        int[] table = new int[2*N+1];
        boolean[] seen = new boolean[2*N+1];
        
        for(int i=0; i<N; i++) {
            // skips 1 for speeding up
            if(!seen[A[i]] && A[i]>1) {
                int count = counter.get(A[i]);
                for(int j=A[i]; j<table.length; j+=A[i]) {
                    table[j] += count;
                }
                seen[A[i]] = true;
            }
        }
        
        int countOne = counter.getOrDefault(1, 0);
        for(int i=0; i<N; i++) {
            nums[i] = N-table[A[i]] - countOne;
        }
        return nums;
    }
}

