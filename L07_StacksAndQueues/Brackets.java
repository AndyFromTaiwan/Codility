/**
 *  Tasks Details:
 *  1. Brackets (Easy)
 *  Determine whether a given string of parentheses (multiple types)
 *  is properly nested.
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
    public int solution(String S) {
        // write your code in Java SE 8
        Stack<Character> stack = new Stack<Character>();
        
        
        for(int i=0; i<S.length(); i++) {
            switch(S.charAt(i)) {
                case ')':
                    if(stack.isEmpty() || stack.peek()!='(') return 0;
                    else stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek()!='[') return 0;
                    else stack.pop();
                    break;
                case '}':
                    if(stack.isEmpty() || stack.peek()!='{') return 0;
                    else stack.pop();
                    break;
                default:
                   stack.push(S.charAt(i));
                   break;
            }
        }
        return stack.isEmpty()? 1:0;
    }
}

