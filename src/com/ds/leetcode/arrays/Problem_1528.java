package com.ds.leetcode.arrays;

/* Shuffle String */
public class Problem_1528 {
    //Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
    public static String restoreString(String s, int[] indices) {
        if(s == null || s.length() == 0)
            return s;
        if(s.length() != indices.length)
            return null;

        char[] res = new char[indices.length];

        for (int i = 0; i < res.length; i++) {
            res[indices[i]] = s.charAt(i);
        }

        return new String(res);
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(restoreString(s, indices));
    }
}
