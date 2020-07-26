/**
 *  Tasks Details:
 *  2. CountSemiprimes (Medium)
 *  Count the semiprime numbers in the given range [a..b].
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N * log(log(N)) + M)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.List;
import java.util.ArrayList;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        boolean[] notPrimes = new boolean[N+1];
        int[] nums = new int[P.length];

        for(int jump=2; jump<=N; jump++) {
            if(!notPrimes[jump]) {
                for(int i=2*jump; i<notPrimes.length; i+=jump) {
                    notPrimes[i] = true;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<Integer>(); 
        for(int i=2; i<=N; i++) {
            if(!notPrimes[i])  primes.add(i);
        }
        
        int[] table = new int[N+1];
        for(int i=0; i<primes.size(); i++) {
            for(int j=i; j<=primes.size(); j++) {
                int semiPrime = primes.get(i)*primes.get(j);
                // pitfall: overflow
                if(semiPrime>N || semiPrime<0) break;
                table[semiPrime]++;
            }
        }
        
        int count = 0;
        for(int i=4; i<=N; i++) {
            count += table[i];
            table[i] = count;
        }
        
        for(int i=0; i<nums.length; i++) {
            nums[i] = table[Q[i]] - table[P[i]-1];
        }
        return nums;
    }
}

