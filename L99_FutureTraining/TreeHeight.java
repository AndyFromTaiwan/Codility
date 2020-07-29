/**
 *  Tasks Details:
 *  5. TreeHeight (Easy)
 *  Compute the height of a binary tree.
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
    public int solution(Tree T) {
        // write your code in Java SE 8
        if(T==null) return -1;
        return 1 + Math.max(solution(T.l), solution(T.r));
    }
}

