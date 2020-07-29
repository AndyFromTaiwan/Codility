/**
 *  Tasks Details:
 *  1. ArrayInversionCount (Medium)
 *  Compute number of inversion in an array.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N*log(N))
 */

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    final int MAX = 1000000000;

    public int solution(int[] A) {
        // write your code in Java SE 8
        return mergeSort(A, 0, A.length-1);
    }
    
    
    private int mergeSort(int[] A, int start, int end) {
        if(start>=end) return 0;
        
        int mid = start + (end-start)/2;
        int sumLeft = mergeSort(A, start, mid);
        if(sumLeft<0) return -1;
        int sumRight = mergeSort(A, mid+1, end);
        if(sumRight<0) return -1;

        int sum = sumLeft + sumRight;
        if(sum>MAX) return -1;
        
        int fromMerge = merge(A, start, mid, end);
        if(fromMerge<0) return -1;
        sum += fromMerge;
        return (sum>MAX)? -1 : sum;
    }
    
    
    private int merge(int[] A, int start, int mid, int end) {
        int num = 0;
        int[] B = Arrays.copyOfRange(A, start, mid+1);
        int index = start;
        int i = 0;
        int j = mid+1;
        
        while(i<B.length && j<=end) {
            if(B[i]<=A[j]) {
                A[index++] = B[i++];
            }
            else {
                A[index++] = A[j++];
                num += B.length-i;
            }
        }
        
        while(i<B.length) {
            A[index++] = B[i++];
        }
        while(j<=end) {
            A[index++] = A[j++];
            //num++; // pitfall!
        }
        return num;
    }
}

