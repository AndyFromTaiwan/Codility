/**
 *  Tasks Details:
 *  2. GenomicRangeQuery (Medium)
 *  Find the minimal nucleotide from a range of sequence DNA.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N+M)
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] minNucleotides = new int[P.length];
        
        int[] A = new int[S.length()+1];
        int[] C = new int[S.length()+1];
        int[] G = new int[S.length()+1];
        int countA = 0;
        int countC = 0;
        int countG = 0;
        
        // constructs cumulative counts of each nucleotide at every position 
        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i)=='A') countA++;
            else if(S.charAt(i)=='C') countC++;
            else if(S.charAt(i)=='G') countG++;
            A[i+1] = countA;
            C[i+1] = countC;
            G[i+1] = countG;
        }
        
        // queries
        for(int i=0; i<minNucleotides.length; i++) {
            if(A[P[i]]<A[Q[i]+1]) minNucleotides[i] = 1;
            else if(C[P[i]]<C[Q[i]+1]) minNucleotides[i] = 2;
            else if(G[P[i]]<G[Q[i]+1]) minNucleotides[i] = 3;
            else minNucleotides[i] = 4;
        }
        return minNucleotides;
    }
}
