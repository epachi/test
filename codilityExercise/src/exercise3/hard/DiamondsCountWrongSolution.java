package exercise3.hard;

import java.util.*;

//A diamond is a quadrilateral whose four sides all have the same length and whose diagonals are parallel to the coordinate axes.
//
//        You are given N distinct points on a plane. Count the number of different diamonds that can be constructed using these points as vertices (two diamonds are different if their sets of vertices are different). Do not count diamonds whose area is empty.
//
//        Write a function:
//
//class Solution { public int solution(int[] X, int[] Y); }
//
//that, given two arrays X and Y, each containing N integers, representing N points (where X[K], Y[K] are the coordinates of the K-th point), returns the number of diamonds on the plane.
//
//        For example, for N = 7 points whose coordinates are specified in arrays X = [1, 1, 2, 2, 2, 3, 3] and Y = [3, 4, 1, 3, 5, 3, 4], the function should return 2, since we can find two diamonds as shown in the picture below:
//
//
//
//        Given arrays: X = [1, 2, 3, 3, 2, 1], Y = [1, 1, 1, 2, 2, 2], the function should return 0, since there are no diamonds on the plane:
//
//
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [4..1,500];
//        each element of arrays X and Y is an integer within the range [0..N-1];
//        given N points are pairwise distinct.

//To solve this problem, we can iterate through all pairs of points and check for each pair if it forms the endpoints of a diagonal of a diamond.
//        Two points (x1, y1) and (x2, y2) form the endpoints of a diagonal if and only if there exist two other points (x3, y3) and (x4, y4) such that:
//        (x1, y1), (x2, y2), (x3, y3), and (x4, y4) are all distinct.
//        (x1, y1) and (x2, y2) are diagonally opposite vertices of the diamond.
//        (x3, y3) and (x4, y4) are diagonally opposite vertices of the diamond.
//        The slopes of the lines connecting (x1, y1) and (x3, y3), as well as (x2, y2) and (x4, y4), are perpendicular.
//        Here's the Java implementation:
public class DiamondsCountWrongSolution {
    public int solution(int[] X, int[] Y) {
        int n = X.length;
        if (n < 4) return 0;

        // Store all points in a set for O(1) lookup
        Set<String> pointSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            pointSet.add(X[i] + "," + Y[i]);
        }

        int count = 0;

        // Try each pair of points as potential diagonal endpoints
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = X[i], y1 = Y[i];
                int x2 = X[j], y2 = Y[j];

                // For a diamond with axis-parallel diagonals, if (x1,y1) and (x2,y2)
                // are opposite vertices, then the center is at:
                // Center coordinates must allow integer arithmetic
                if ((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0) {
                    continue;
                }

                int cx = (x1 + x2) / 2;
                int cy = (y1 + y2) / 2;

                // Calculate distances from center to the given vertices
                int dx = Math.abs(x1 - cx);  // horizontal distance from center
                int dy = Math.abs(y1 - cy);  // vertical distance from center

                // For a non-degenerate diamond, both distances must be > 0
                if (dx == 0 || dy == 0) continue;

                // If (x1,y1) and (x2,y2) are on the same horizontal or vertical line,
                // they cannot be diagonal vertices of a diamond with axis-parallel diagonals
                if (x1 == x2 || y1 == y2) continue;

                // The other two vertices are at (cx-dy, cy) and (cx+dy, cy)
                int x3 = cx - dy, y3 = cy;
                int x4 = cx + dy, y4 = cy;

                if (pointSet.contains(x3 + "," + y3) && pointSet.contains(x4 + "," + y4)) {
                    count++;
                }
            }
        }

        // Each diamond is counted twice (once for each diagonal)
        return count / 2;
    }

    public static void main(String[] args) {
        DiamondsCountWrongSolution solution = new DiamondsCountWrongSolution();

        // Example 1
        int[] X1 = {1, 1, 2, 2, 2, 3, 3};
        int[] Y1 = {3, 4, 1, 3, 5, 3, 4};
        System.out.println(solution.solution(X1, Y1)); // Output: 2

        // Example 2
        int[] X2 = {1, 2, 3, 3, 2, 1};
        int[] Y2 = {1, 1, 1, 2, 2, 2};
        System.out.println(solution.solution(X2, Y2)); // Output: 0
    }
}
