/**
 *  Tasks Details:
 *  1. MinAbsSum (Hard)
 *  Given array of integers, find the lowest absolute sum of elements.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N * max(abs(A))**2)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length==0) return 0;
        
        int sum = 0;
        int max = 0;
        for(int i=0; i<A.length; i++) {
            A[i] = Math.abs(A[i]);
            sum += A[i];
            max = Math.max(max, A[i]);
        }

        int[] possibleSums = new int[1+sum];
        Arrays.fill(possibleSums, -1);
        possibleSums[0] = 0;
        
        int[] counter = new int[1+max];
        for(int i=0; i<A.length; i++) {
            counter[A[i]]++;
        }
        
        for(int i=1; i<counter.length; i++) {
            if(counter[i]>0) {
                for(int j=0; j<possibleSums.length; j++) {
                    if(possibleSums[j]>=0) {
                        possibleSums[j] = counter[i];
                    }
                    else if (j>=i && possibleSums[j-i]>0) {
                        possibleSums[j] = possibleSums[j-i] - 1;
                    }
                }
            }
        }

        for(int i=sum/2; i>0; i--) {
            if(possibleSums[i]>=0) return sum - 2*i;
        }
        return sum;
    }
}

/*
   Explanation:
        Assume the sum of absolute values of all the numbers is S. We want
   to choose some of the numbers (absolute values) to make their sum P as 
   large as possible without exceeding S/2.
   Let P + Q = S, the answer is Q - P = S - 2P
*/

// Pitfall I: a timeout error solution:
// O(N**2 * max(abs(A)))
/*
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length==0) return 0;
        
        int sum = 0;
        for(int i=0; i<A.length; i++) {
            A[i] = Math.abs(A[i]);
            sum += A[i];
        }

        boolean[] possibleSums = new boolean[1+sum];
        possibleSums[0] = true;
        
        for(int i=0; i<A.length; i++) {
            for(int j=possibleSums.length-1; j>=0; j--) {
                if(possibleSums[j]) possibleSums[j+A[i]] = true;
            }
        }

        for(int i=sum/2; i>0; i--) {
            if(possibleSums[i]) return sum - 2*i;
        }
        return sum;
    }
}
*/

// Pitfall II: a wrong algorithm:
// For example, for the input [3, 3, 3, 4, 5] the solution returned a 
// wrong answer (got 2 expected 0).

/*
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length==0) return 0;
        if(A.length==1) return Math.abs(A[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        for(int i=0; i<A.length; i++) {
            pq.add(Math.abs(A[i]));
        }
        
        while(pq.size()>1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a-b);
        }
        return pq.poll();
    }
}
*/

