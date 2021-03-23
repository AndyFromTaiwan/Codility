/**
 *  2020 Palladium Challenge
 *  Tasks Details:
 *  1. CoverBuildings (Medium)
 *  Given N rectangular buildings of width 1, find the minimum total area of
 *  two rectangular banners that cover all of the buildings.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N) or O(N + max(H))
 */

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] H) {
        // write your code in Java SE 8
        if(H.length==1) return H[0];
        
        int[] maxHieghtAtLeft = new int[H.length];
        int[] maxHieghtAtRight = new int[H.length];
        
        maxHieghtAtLeft[0] = H[0];
        for(int i=1; i<H.length; i++) {
            maxHieghtAtLeft[i] = Math.max(H[i], maxHieghtAtLeft[i-1]);           
        }
      
        maxHieghtAtRight[H.length-1] = H[H.length-1];
        for(int i=H.length-2; i>=0; i--) {
            maxHieghtAtRight[i] = Math.max(H[i], maxHieghtAtRight[i+1]);
        }
        
        int minArea = maxHieghtAtRight[0]*H.length;
        for(int i=1; i<H.length; i++) {
            minArea = Math.min(minArea, 
                maxHieghtAtLeft[i-1]*i + maxHieghtAtRight[i]*(H.length-i);
        }
        return minArea;
    }
}
