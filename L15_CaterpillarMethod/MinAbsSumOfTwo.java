/**
 *  Tasks Details:
 *  4. MinAbsSumOfTwo (Medium)
 *  Find the minimal absolute value of a sum of two elements.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N * log(N))
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        if(A[0]>=0) return 2*A[0];
        if(A[A.length-1]<0) return -2*A[A.length-1];
        
        int left = 0;
        int right = A.length-1;
        int minAbsSum = Integer.MAX_VALUE;

        while(left<right) {
            int sum = A[left]+A[right];
            minAbsSum = Math.min(minAbsSum, Math.abs(sum));

            if(sum<0) left++;
            else if(sum>0) right--;
            else return 0;
        }
        return minAbsSum;
    }
}

