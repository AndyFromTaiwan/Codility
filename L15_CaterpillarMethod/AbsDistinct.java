/**
 *  Tasks Details:
 *  1. AbsDistinct (Easy)
 *  Compute number of distinct absolute values of sorted array elements.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N) or O(N*log(N))
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int lastAdded = Integer.MIN_VALUE; // dummy
        int num = (A[0]==Integer.MIN_VALUE)? 1:0;
        
        int left = 0;
        int right = A.length-1;
        while(left<=right) {
            // pitfall: uses true abs values will encounter 
            // overflow when A[i] == Integer.MIN_VALUE
            int leftValue = A[left]<=0? A[left] : -A[left];
            int rightValue = A[right]<=0? A[right] : -A[right];

            if(leftValue<rightValue) {
                if(leftValue!=lastAdded) {
                    lastAdded = leftValue;
                    num++;
                }
                left++;
            }
            else if(leftValue>rightValue) {
                if(rightValue!=lastAdded) {
                    lastAdded = rightValue;
                    num++;
                }
                right--;
            }
            else {
                if(leftValue!=lastAdded) {
                    lastAdded = leftValue;
                    num++;
                };
                left++;
                right--;
            }
        }
        return num;
    }
}

