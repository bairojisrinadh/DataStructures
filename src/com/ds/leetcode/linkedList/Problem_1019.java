package com.ds.leetcode.linkedList;

import com.ds.list.ref.ListNode;
import com.ds.list.ref.libraries.ListUtil;

/*Problem 1019: Next Greater Node in Linked List*/
public class Problem_1019 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildListFrmArray(new int[]{});
        ListUtil.traverse(head);
        int[] result = nextLargerNodes(head);
        System.out.println(ListUtil.toString(result));
    }

    public static int[] nextLargerNodes(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new int[]{0};

        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }

        // final result array
        int[] result = new int[size];
        ListNode currNode = head;
        ListNode sliderNode = currNode.next;
        int index = 0;

        while (true) {
            while (sliderNode != null) {
                if (currNode.val < sliderNode.val) {
                    result[index++] = sliderNode.val;
                    break;
                } else if (sliderNode.next == null) {
                    result[index++] = 0;
                }
                sliderNode = sliderNode.next;
            }
            currNode = currNode.next;
            if (currNode.next == null) break;
            sliderNode = currNode.next;
        }

        return result;
    }

    public static int[] nextLargerNodes1(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new int[]{0};

        return null;
    }
}
