/**
 *  Tasks Details:
 *  2. MaxProductOfThree (Easy)
 *  Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N*log(N))
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
        
        //seraches for index of the first postive number
        int left = 0;
        int right = A.length-1;
        while(left<right) {
            int mid = left+(right-left)/2;
            if(A[mid]>0) right = mid;
            else left = mid+1;
        }
        // 0 or 1 positive number
        if(left==A.length-1) {
            if(A[left]<=0) return A[left]*A[left-1]*A[left-2];
            else return A[left]*A[0]*A[1];
        }
        // 2 or more positive numbers
        else return A[A.length-1] 
                    * Math.max(A[A.length-2]*A[A.length-3], A[0]*A[1]);
    }
}

