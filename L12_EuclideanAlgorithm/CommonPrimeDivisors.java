/**
 *  Tasks Details:
 *  2. CommonPrimeDivisors (Medium)
 *  Check whether two numbers have the same prime divisors.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(Z * log(max(A) + max(B))**2)
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int num = 0;
        for(int i=0; i<A.length; i++) {
            if(isSamePrimeDivisors(A[i], B[i])) num++;
        }
        return num;
    }
    
    
    private int getGCD(int a, int b) {
        if(a%b==0) return b;
        else return getGCD(b, a%b);
    }
    
    
    private boolean isSamePrimeDivisors(int a, int b) {
        if(a==b) return true;
        
        int gcd = getGCD(a, b);
        if(gcd==1) return false;
        
        return isSubsetPrimeDivisors(a/gcd, gcd) && isSubsetPrimeDivisors(b/gcd, gcd);
    }
    
    
    private boolean isSubsetPrimeDivisors(int fraction, int primeSet) {
        int gcd = getGCD(fraction, primeSet);
        while(gcd!=1 && fraction!=1) {
            while(fraction%gcd==0) fraction /= gcd;
            gcd = getGCD(fraction, primeSet);
        }
        return fraction==1;
    }
}

