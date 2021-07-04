package com.ds.leetcode.arrays;

/* Problem Statement: Sum of all odd length sub-arrays */
/* Constraints:
*   1 <= arr.length <= 100
*   1 <= arr[i] <= 1000
* */
public class Problem_1588 {
    public static int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length < 1)
            return 0;
        if (arr.length < 2)
            return arr[0];

        int n = arr.length;
        int res = 0;

        int single_ele_sum = 0;
        //All single element is a sub array of the actual array
        for (int ele : arr) {
            single_ele_sum += ele;
        }

        res += single_ele_sum;

        for (int i = 3; i <= n; i += 2) {
            int sub_array_sum = 0;
            int start = 0;
            int end = i;
            while(start < end) {
                sub_array_sum += arr[start++];
            }
            res += sub_array_sum;
            start = 0;
            while(end < n) {
                sub_array_sum = sub_array_sum + arr[end] - arr[start];
                res += sub_array_sum;
                start++;
                end++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10,11,12};
        System.out.println(sumOddLengthSubarrays(arr));
    }
}
