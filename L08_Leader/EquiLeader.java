/**
 *  Tasks Details:
 *  2. EquiLeader (Easy)
 *  Find the index S such that the leaders of the sequences A[0], A[1],
 *  ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1] are the same.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.Map;
import java.util.HashMap;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        // finds the global leader
        // if a equi leader exist, is must be the global leader
        int threshold = A.length/2;
        int globalLeader = -1;
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        
        for(int i=0; i<A.length; i++) {
            int count = counter.getOrDefault(A[i], 0) + 1;
            if(count > threshold) globalLeader = i;
            counter.put(A[i], count);
        }
        if(globalLeader == -1) return 0;
        
        // searches for equi leaders
        int countLeaderLeft = counter.get(A[globalLeader]);
        int countLeaderCurrent = 0;
        
        int num = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i]==A[globalLeader]) {
                countLeaderCurrent++;
                countLeaderLeft--;
            }
            if(countLeaderCurrent>(i+1)/2 && countLeaderLeft>(A.length-i-1)/2) {
                num++;
            }
        }
        return num;
    }
}

