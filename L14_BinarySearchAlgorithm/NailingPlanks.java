/**
 *  Tasks Details:
 *  2. NailingPlanks (Medium)
 *  Count the minimum number of nails that allow a series of planks to
 *  be nailed.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O((N + M) * log(M))
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


class Solution {
    int N;
    int M;
    int[][] nails;
    
    public int solution(int[] A, int[] B, int[] C) {
        // write your code in Java SE 8
        N = A.length;
        M = C.length;
        genSortedNails(C);
        
        int minNail = 0;
        for(int i=0; i<N; i++) {
            // pitfall: speed up!
            //minNail = Math.max(minNail, search(A[i], B[i]));
            minNail = search(A[i], B[i], minNail); 
            if(minNail==M) return -1;
        }
        return minNail+1;
    }
    
    
    private int search(int start, int end, int minNail) {
        int left = 0;
        int right = M;
        while(left<right) {
            int mid = left+(right-left)/2;
            if(nails[mid][0] >= start) right = mid;
            else left = mid+1;
        }
        
        int index = M;
        for(int i=left; i<M && nails[i][0]<=end; i++) {
            index = Math.min(index, nails[i][1]);
            // pitfall: speed up!
            if(index<=minNail) return minNail;
        }
        return index;
    }
    
    
     private void genSortedNails(int[] C) {
        nails = new int[M][2];
        for(int i=0; i<M; i++) {
            nails[i][0] = C[i];
            nails[i][1] = i;
        }
        Arrays.sort(nails, (a, b) -> a[0] - b[0]);
    }
}


// Pitfall: a timeout-error solution:
/*
class Solution {
    int N;
    int count;
    boolean[] nailed;
    int[][] planks;
    
    public int solution(int[] A, int[] B, int[] C) {
        // write your code in Java SE 8
        preprocess(A, B);
        
        for(int i=0; i<C.length; i++) {
            int index = search(C[i]);
            nail(C[i], index);
            if(count==0) return i+1;
        }
        return -1;
    }
    
    
    private int search(int n) {
        int left = 0;
        int right = N-1;
        while(left<right) {
            int mid = left+(right-left)/2;
            if(planks[mid][1] >= n) right = mid;
            else left = mid+1;
        }
        return left;
    }
    
    
    private void nail(int n, int i) {
        while(i<N && planks[i][1] >= n) {
            if(planks[i][0] <= n && !nailed[i]) {
                count--;
                nailed[i] = true;
            }
            i++;
        }
    }
    
    
    private void preprocess(int[] A, int[] B) {
        N = A.length;
        count = N;
        nailed = new boolean[N];
        planks = new int[N][2];
        for(int i=0; i<N; i++) {
            planks[i][0] = A[i];
            planks[i][1] = B[i];
        }
        Arrays.sort(planks, (a, b) -> a[1] - b[1]);
    }
}
*/

