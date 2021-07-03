package com.ds.leetcode.linkedList;

import com.ds.list.ref.ListNode;
import com.ds.list.ref.libraries.ListUtil;

/*Problem 83: Remove Duplicates from Sorted List*/
public class Problem_83 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        ListUtil.traverse(head);
        deleteDuplicates(head);
        ListUtil.traverse(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        //Dry Run: 1 -> 1 -> 2 -> 3 -> 3 -> 4 -> null
        while (p2 != null) {
            if (p1.val == p2.val) {
                p2 = p2.next;
                continue;
            }
            p1.next = p2;
            p1 = p2;
            p2 = p2.next;
        }

        //condition if last 2 elements are equal, discard last element
        if (p1 != p2) p1.next = null;
        return head;
    }

}
