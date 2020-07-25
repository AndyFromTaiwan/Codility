/**
 *  Tasks Details:
 *  4. StoneWall (Easy)
 *  Cover "Manhattan skyline" using the minimum number of rectangles.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.Stack;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] H) {
        // write your code in Java SE 8
        int num = 0;
        Stack<Integer> s = new Stack<Integer>();
        s.push(0); // dummy element to save stack emptiness check 
        
        for(int i=0; i<H.length; i++) {
            if(H[i]>s.peek()) s.push(H[i]);
            else {
                while(H[i]<s.peek()) {
                    s.pop();
                    num++;
                }
                if(H[i]!=s.peek()) s.push(H[i]);
            }
        }
        return num + s.size()-1; // dummy element
    }
}

