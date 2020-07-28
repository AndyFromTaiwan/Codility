/**
 *  Tasks Details:
 *  1. MinMaxDivision (Medium)
 *  Divide array A into K blocks and minimize the largest sum of any block.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N*log(N+M))
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int K, int M, int[] A) {
        // write your code in Java SE 8
        int max = 0;
        int sum = 0;
        for(int i=0; i<A.length; i++) {
            sum += A[i];
            max = Math.max(max, A[i]);
        }
        
        int left = max;
        int right = sum;
        while(left<right) {
            int mid = left + (right-left)/2;
            if(isPossibleDivision(K, mid, A)) right = mid;
            else left = mid+1;
        }
        return left;
    }
    
    
    private boolean isPossibleDivision(int K, int largeSum, int[] A){
        K--;
        int divisionSum = largeSum;
        
        for(int i=0; i<A.length; i++) {
            if(A[i]<=divisionSum) {
                divisionSum -= A[i];
            }
            else {
                divisionSum = largeSum - A[i];
                K--;
                if(K<0) return false;
            }
        }
        return true; 
    }
}

