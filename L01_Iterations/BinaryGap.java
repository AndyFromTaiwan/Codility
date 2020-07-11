/**
 *  Tasks Details:
 *  1. BinaryGap (Easy)
 *  Find longest sequence of zeros in binary representation of an integer.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: Not assessed
 *  Analysis summary: The solution obtained perfect score.
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int longestBinGap = 0;

        String binRep = Integer.toBinaryString(N);
        int lastOne = 0; // only 0's binary representation doesn't contain
                         // a leading zero, but this solution still works.
        for(int i=1; i<binRep.length(); i++) {
            if(binRep.charAt(i)=='1') {
                // compares the length of binary gap
                longestBinGap = Math.max(longestBinGap, i-lastOne-1);
                lastOne = i;
            }
        }
        return longestBinGap;
    }
}

