/**
 *  Tasks Details:
 *  1. FibFrog (Medium)
 *  Count the minimum number of jumps required for a frog to get to the
 *  other side of a river.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N * log(N))
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    int[] A;
    int N;
    Set<Integer> Fibs;
    List<Integer> FibsSeq;
    
    public int solution(int[] A) {
        // write your code in Java SE 8
        this.A = A;
        N = A.length;

        genFibSequence();
        if(Fibs.contains(N+1)) return 1;
        
        for(int i=0; i<A.length; i++) {
            if(A[i]==1) {
                if(!Fibs.contains(i+1)) {
                    int minSteps = getStepsFromLeaves(i);
                    if(minSteps<N) {
                        A[i] = minSteps;
                    }
                    else A[i] = 0;
                }
            }
        }
        
        int result = getStepsFromLeaves(N);
        return (result<N)? result : -1;
    }
   
   
    private int getStepsFromLeaves(int i) {
        int min = N;
        for(Integer fib : FibsSeq) {
            if(fib>i) break;
            
            if(A[i-fib]>0) {
                min = Math.min(min, A[i-fib]+1);  
            }
        }
        return min;
    }
    
    
    private void genFibSequence() {
        Fibs = new HashSet<Integer>();
        FibsSeq = new ArrayList<Integer>();
        Fibs.add(1);
        FibsSeq.add(1);
        
        int a = 1;
        int b = 1;
        while(b <= N+1) {
            int temp = a+b;
            Fibs.add(temp);
            FibsSeq.add(temp);
            a = b;
            b = temp;
        }
    }
}

// Piftall: A O(N**2) solution:
/*
class Solution {
    int[] A;
    int N;
    Set<Integer> Fibs;
    Set<Integer> reachables;
    
    public int solution(int[] A) {
        // write your code in Java SE 8
        this.A = A;
        N = A.length;

        genFibSequence();
        if(Fibs.contains(N+1)) return 1;
        
        reachables = new HashSet<Integer>();
        for(int i=0; i<A.length; i++) {
            if(A[i]==1) {
                if(Fibs.contains(i+1)) {
                    reachables.add(i);
                }
                else {
                    int minSteps = getStepsFromLeaves(i);
                    if(minSteps<N) {
                        A[i] = minSteps;
                        reachables.add(i);
                    }
                    else A[i] = 0;
                }
            }
        }
        
        int result = getStepsFromLeaves(N);
        return (result<N)? result : -1;
    }
    
    
    private int getStepsFromLeaves(int i) {
        int min = N;
        for(Integer leaf : reachables) {
            if(Fibs.contains(i-leaf)) {
                min = Math.min(min, A[leaf]+1);      
            }
        }
        return min;
    }
    
    
    private void genFibSequence() {
        Fibs = new HashSet<Integer>();
        Fibs.add(1);
        
        int a = 1;
        int b = 1;
        while(b <= N+1) {
            int temp = a+b;
            Fibs.add(temp);
            a = b;
            b = temp;
        }
    }
}
*/

