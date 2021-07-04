package com.ds.leetcode.arrays;

/* Problem Statement: Count the number of consistent strings */

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * Output: 2
 * Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 */
public class Problem_1684 {

    public static int countConsistentStrings(String allowed, String[] words) {
        if (allowed.isEmpty() || words == null || words.length == 0) {
            return 0;
        }

        Map<Character, Integer> allowedMap = new HashMap<>();
        for (char ch : allowed.toCharArray()) {
            if (!allowedMap.containsKey(ch)) {
                allowedMap.put(ch, 1);
            } else {
                allowedMap.put(ch, allowedMap.get(ch) + 1);
            }
        }

        int count = 0;

        for (String word : words) {
            char[] arr = word.toCharArray();
            boolean foundAll = true;
            for (int i = 0; i < arr.length; i++) {
                char ch = arr[i];
                if (!allowedMap.containsKey(ch)) {
                    foundAll = false;
                    break;
                }
            }
            if (foundAll) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String allowed = "cad";
        String[] words = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        System.out.println(countConsistentStrings(allowed, words));
    }
}
