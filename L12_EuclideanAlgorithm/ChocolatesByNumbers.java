/**
 *  Tasks Details:
 *  1. ChocolatesByNumbers (Easy)
 *  There are N chocolates in a circle. Count the number of chocolates
 *  you will eat.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(log(N + M))
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N, int M) {
        // write your code in Java SE 8

        // finds g.c.d.
        int a = N;
        int b = M;
        while(b>0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return N/a;
    }
}

