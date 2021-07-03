package com.ds.leetcode.linkedList;

import com.ds.list.ref.ListNode;
import com.ds.list.ref.libraries.ListUtil;

/*Problem 203: Remove Linked List Elements*/
public class Problem_203 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildListFrmArray(new int[]{1, 2, 3, 4, 5});
        ListUtil.traverse(head);
        ListUtil.traverse(removeElements(head, 1));
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode prev = new ListNode(-1);
        prev.next = p1;
        ListNode result = prev;

        // Dry Run:
        // [7, 7, 7, 7, null], 7
        // [1, 2, 3, 5, 6, null], 3
        while(p1 != null) {
            if (p1.val == val) {
                prev.next = p1.next;
            } else {
                prev = prev.next;
            }
            p1 = p1.next;
        }

        return result.next;
    }
}
