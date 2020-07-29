/**
 *  Tasks Details:
 *  3. CountTriangles (Easy)
 *  Count the number of triangles that can be built from a given set of edges.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N**2)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length<3) return 0;
        
        int num = 0;
        Arrays.sort(A);
        
        for(int i=0; i<A.length-2; i++) {
            int left = i+1;
            int right = i+2;
            while(right<A.length) {
                while(right>left && A[right]-A[left]>=A[i]) {
                    left++;
                }
                
                if(right>left) num += right - left;
                right++;
            }
        }
        return num;
    }
}

