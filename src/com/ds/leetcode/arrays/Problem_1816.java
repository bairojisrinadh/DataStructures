package com.ds.leetcode.arrays;

/* Truncate Sentence */
public class Problem_1816 {
    public static String truncateSentence(String s, int k) {
        int count_spaces = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                continue;
            count_spaces++;
            if (count_spaces == k)
                break;
        }
        return s.substring(0, i);
    }

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s, k));
    }
}

