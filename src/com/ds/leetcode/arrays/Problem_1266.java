package com.ds.leetcode.arrays;

/* Problem Statement: Minimum time visiting all points */

/**
 * Input: points = [[1,1],[3,4],[-1,0]]
 * Output: 7
 * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 */
public class Problem_1266 {
    public static int minTimeToVisitAllPoints(int[][] points) {
        if (points == null || points.length < 2) return 0;
        int num_of_points = points.length;
        int minTime = 0;
        for (int i = 0; i < num_of_points - 1; i++) {
            int[] p1 = points[i];
            int[] p2 = points[i + 1];
            if(p1[0] < p2[0]) {
                if(p1[1] == p2[1])
                    minTime += moveHorizontalRight(p1, p2);
                else
                    minTime += moveUp(p1, p2);
            } else {
                if(p1[1] == p2[1])
                    minTime += moveHorizontalLeft(p1, p2);
                else
                    minTime += moveDown(p1, p2);
            }
        }
        return minTime;
    }

    private static int moveHorizontalLeft(int[] p1, int[] p2) {
        int minTime = 0;
        int x_start_idx = p1[0];
        int x_end_idx = p2[0];
        while(x_start_idx > x_end_idx) {
            x_start_idx--;
            minTime++;
        }
        return minTime;
    }

    private static int moveHorizontalRight(int[] p1, int[] p2) {
        int minTime = 0;
        int x_start_idx = p1[0];
        int x_end_idx = p2[0];
        while(x_start_idx < x_end_idx) {
            x_start_idx++;
            minTime++;
        }
        return minTime;
    }

    private static int moveDown(int[] p1, int[] p2) {
        int minTime = 0;
        int x_start_idx = p1[0];
        int x_end_idx = p2[0];
        int y_start_idx = p1[1];
        int y_end_idx = p2[1];
        while(y_start_idx != y_end_idx) {
            // Move diagonal
            if(x_start_idx > x_end_idx) {
                x_start_idx--;
                y_start_idx--;
                minTime++;
            } else if(x_start_idx == x_end_idx) {
                // Move Vertical Up
                if(y_start_idx < y_end_idx) {
                    y_start_idx--;
                    minTime++;
                }
            }
        }
        return minTime;
    }

    private static int moveUp(int[] p1, int[] p2) {
        int minTime = 0;
        int x_start_idx = p1[0];
        int x_end_idx = p2[0];
        int y_start_idx = p1[1];
        int y_end_idx = p2[1];
        while(y_start_idx != y_end_idx) {
            // Move diagonal
            if(x_start_idx < x_end_idx) {
                x_start_idx++;
                y_start_idx++;
                minTime++;
            } else if(x_start_idx == x_end_idx) {
                // Move Vertical Up
                if(y_start_idx < y_end_idx) {
                    y_start_idx++;
                    minTime++;
                }
            }
        }
        return minTime;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(points));
    }
}
