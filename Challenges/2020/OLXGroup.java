/**
 *  2020 The OLX Group Challenge
 *  Tasks Details:
 *  1. Multivitamin (Medium)
 *  There are N glasses of different capacities, each of them containing 
 *  a different amount of a unique kind of juice. Calculate the maximum
 *  number of kinds of juice that can be mixed in a single glass.
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N * log(N))
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    class Cup {
        int juice;
        int capacity;
        Cup(int j, int c) {
            juice = j;
            capacity = c;
        }
    }

    public int solution(int[] juice, int[] capacity) {
        // write your code in Java SE 8
        final int N = juice.length;
        Cup[] cups = new Cup[N];
        for(int i=0; i<N; i++) {
            cups[i] = new Cup(juice[i], capacity[i]);
        }
        Arrays.sort(cups, 
            (a,b)-> a.juice==b.juice? 
                b.capacity-a.capacity : a.juice-b.juice);

        int[] maxFreeCapAtRight = new int[N];
        for(int i=N-2; i>=0; i--) {
            maxFreeCapAtRight[i] = Math.max(maxFreeCapAtRight[i+1]
                , cups[i+1].capacity-cups[i+1].juice);
        }

        int sum = 0;
        int maxCapacity = 0;
        int flavours = 0;
        for(int i=0; i<N; i++) {
            sum += cups[i].juice;
            if(sum > 1_000_000_000) break; // prevents overflow
            maxCapacity = Math.max(maxCapacity, cups[i].capacity);
            if(maxCapacity>=sum) flavours = i+1;
            if(maxFreeCapAtRight[i]>=sum) flavours = i+2;
        }
        return flavours;
    }
}
