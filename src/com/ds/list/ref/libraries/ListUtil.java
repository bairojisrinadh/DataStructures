package com.ds.list.ref.libraries;

import com.ds.list.ref.ListNode;

public final class ListUtil {
    public static void traverse(ListNode head) {
        if (head == null) {
            System.out.println("Provided List is empty!");
            return;
        }
        ListNode tmp = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (tmp != null) {
            if (tmp.next != null) {
                stringBuilder.append(tmp.val).append("->");
            } else {
                stringBuilder.append(tmp.val);
            }
            tmp = tmp.next;
        }
        System.out.println(stringBuilder.toString());
    }

    public static ListNode buildListFrmArray(int[] input) {
        if (input.length == 0) return null;
        ListNode head = null;
        ListNode tail_pointer = null;
        for (int val : input) {
            if (head == null) {
                head = new ListNode(val);
                tail_pointer = head;
            } else {
                tail_pointer.next = new ListNode(val);
                tail_pointer = tail_pointer.next;
            }
        }
        return head;
    }

    public static ListNode getLastNode(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static String toString(int[] arr) {
        if (arr == null || arr.length <= 0) return "Empty Array!";

        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0, len = arr.length; i < len; i++) {
            if (i == len - 1) stringBuilder.append(arr[i]).append("]");
            else stringBuilder.append(arr[i]).append(",");
        }
        return stringBuilder.toString();
    }
}
