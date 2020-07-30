/**
 *  Tasks Details:
 *  3. PolygonConcavityIndex (Hard)
 *  Check whether a given polygon in a 2D plane is convex;
 *  if not, return the index of a vertex that doesn't belong to the
 *  convex hull.
 *  
 *  Task Score: 100% 
 *  Correctness: 100%
 *  Performance: 100%
 *  Analysis summary: The solution obtained perfect score.
 *  Detected time complexity: O(N)
 */

// you can also use imports, for example:
// import java.util.*;
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    class Line {
        int index;
        double slope;
        Line(int i, double s) {
            index = i;
            slope = s;
        }
    }
    
    Point2D[] A;
    int N;
    
    public int solution(Point2D[] A) {
        // write your code in Java SE 8
        this.A = A;
        this.N = A.length;
       
        // Step 1: Find the reference point (the leftmost one here).
        // This point musr belong to the convex hull!
        int refIndex = 0;
        int refX = A[0].x;
        int refY = A[0].y;
        for(int i=1; i<N; i++) {
            if(A[i].x<refX || (A[i].x==refX && A[i].y>refY)) {
                refIndex = i;
                refX = A[i].x;
                refY = A[i].y;
            }
        }
        
        // Step 2: Sort all other points by the slopes from 
        // the reference point.
        PriorityQueue<Line> pq = new PriorityQueue<Line>(
            (a,b) -> 
                (a.slope == b.slope)? (
                    (A[b.index].y == A[a.index].y)? 
                        A[a.index].x - A[b.index].x 
                        : A[b.index].y - A[a.index].y
                    )
                    : (a.slope-b.slope)>0? 1:-1 
        );
        
        for(int i=0; i<N; i++) {
            if(i!=refIndex) {
                // maps slopes to [-PI/2, PI/2]  
                double slope = Math.atan((double) (A[i].y-refY) 
                    / (double) (A[i].x-refX));
                pq.add(new Line(i, slope));
            }
        }
       
        // Step 3: Find directions for every arc A -> B -> C.
        // If a point is in the opposite, then we find a concavity index.
        int a = refIndex;
        int b = pq.poll().index;
        int c = pq.poll().index;
        int lastDir = getDirection(a, b, c);

        while(!pq.isEmpty()) {
            int temp = pq.poll().index;
            int dir = getDirection(b, c, temp);
            if(dir*lastDir < 0) return c;

            // pitfall: critical cases containing stright arcs 
            if(lastDir==0) lastDir = dir; 
            a = b;
            b = c;
            c = temp;
        }

        return -1;
    }
    

    private int getDirection(int a, int b, int c) {
        // prevents overflow
        long ax = (long) A[a].x;
        long ay = (long) A[a].y;
        long bx = (long) A[b].x;
        long by = (long) A[b].y;
        long cx = (long) A[c].x;
        long cy = (long) A[c].y;
        
        long result = (bx-ax)*(cy-ay) - (by-ay)*(cx-ax);
        if(result==0) return 0; // stright line
        return (result>0)? 1 : -1; // clockwise : counterclockwise
    }
}

// Reference I -  Graham's scan Algorithm:
// Graham's scan is a method of finding the convex hull of a finite set
// of points in the plane with time complexity O(n log n).
// https://www.youtube.com/watch?v=Ps1idzOx6LA

// Reference II - An alternative O(N) solution:
// https://davidjalon.com/index/polygonconcavityindex/

