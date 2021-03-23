/**
 *  2021 The Doge Challenge
 *  Tasks Details:
 *  1. PetsAndToys (Hard)
 *  Each of N people has either a dog or a cat, and owns a toy for dog or for
 *  cat. Is it possible to exchange toys between acquaintances so that every 
 *  animal gets an appropriate toy?
 *  
 *  Task Score: 100%
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N+M)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    int[] P;
    int[] T;
    int[] A;
    int[] B;
    List<List<Integer>> graph = new ArrayList<List<Integer>>();
    boolean[] visited;

    public boolean solution(int[] P, int[] T, int[] A, int[] B) {
        // write your code in Java SE 8
        this.P = P;
        this.T = T;
        this.A = A;
        this.B = B;

        constructGraph();
        visited = new boolean[P.length];

        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                int balenceCount = dfs(i);
                if(balenceCount!=0) return false;
            }
        }
        return true;
    }

    void constructGraph() {
        for(int i=0; i<P.length; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<A.length; i++) {
            graph.get(A[i]).add(B[i]);
            graph.get(B[i]).add(A[i]);
        }
    }

    int dfs(int index) {
        if(visited[index]) return 0;
        visited[index] = true;
        int count = (P[index]-T[index]);
        List<Integer> neighbours = graph.get(index);
        for(int i=0; i<neighbours.size(); i++) {
            count += dfs(neighbours.get(i)); 
        }
        return count;
    }
}
