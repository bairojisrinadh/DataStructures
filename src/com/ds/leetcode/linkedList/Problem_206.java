package com.ds.leetcode.linkedList;

import com.ds.list.ref.ListNode;
import com.ds.list.ref.libraries.ListUtil;

/*Problem 206: Reverse Linked List*/
public class Problem_206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListUtil.traverse(head);
        head = reverseList(head);
        ListUtil.traverse(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return head = prev;
    }
}
