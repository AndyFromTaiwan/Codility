/**
 *  Tasks Details:
 *  2. CountDistinctSlices (Easy)
 *  Count the number of distinct slices (containing only unique numbers).
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N)
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int M, int[] A) {
        // write your code in Java SE 8
        int num = 0;
        boolean[] sliceMembers = new boolean[1+M];
        
        int left = 0;
        int right = 0;
        while(right<A.length) {
            while(sliceMembers[A[right]]) {
                sliceMembers[A[left]] = false;
                left++;
            }

            sliceMembers[A[right]] = true;
            right++;
            num += right-left;
            if(num>1000000000) return 1000000000;
        }
        return num;
    }
}

