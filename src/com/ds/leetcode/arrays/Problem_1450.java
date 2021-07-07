package com.ds.leetcode.arrays;

/* Problem Statement: No. of students doing homework at a given time */
public class Problem_1450 {
    /**
     * Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
     * Output: 1
     * Explanation: We have 3 students where:
     * The first student started doing homework at time 1 and finished at time 3 and wasn't doing anything at time 4.
     * The second student started doing homework at time 2 and finished at time 2 and also wasn't doing anything at time 4.
     * The third student started doing homework at time 3 and finished at time 7 and was the only student doing homework at time 4.
     */

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int length = startTime.length;
        if (length == 1) {
            if (endTime[0] >= queryTime && startTime[0] <= queryTime) return 1;
            else return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (endTime[i] >= queryTime && startTime[i] <= queryTime) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] startTime = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] endTime = {10, 10, 10, 10, 10, 10, 10, 10, 10};
        int queryTime = 5;
        System.out.println(busyStudent(startTime, endTime, queryTime));
    }
}
