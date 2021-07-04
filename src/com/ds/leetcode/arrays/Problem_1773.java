package com.ds.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Count items matching a Rule */
public class Problem_1773 {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        if (items == null) {
            return 0;
        }

        int count = 0;
        int idx = -1;
        switch (ruleKey) {
            case "type": idx = 0; break;
            case "color": idx = 1; break;
            case "name": idx = 2; break;
        }
        for (List<String> item : items) {
            if(idx != -1 && ruleValue.equalsIgnoreCase(item.get(idx))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> item1 = Arrays.asList("phone", "blue", "pixel");
        List<String> item2 = Arrays.asList("computer","silver","phone");
        List<String> item3 = Arrays.asList("phone","gold","iphone");
        List<List<String>> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        System.out.println(countMatches(items, "color", "silver"));
    }
}
