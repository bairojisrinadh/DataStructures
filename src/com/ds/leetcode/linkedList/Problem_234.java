package com.ds.leetcode.linkedList;

import com.ds.list.ref.ListNode;
import com.ds.list.ref.libraries.ListUtil;

/*Problem 234: Palindrome Linked List*/
public class Problem_234 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildListFrmArray(new int[]{1, 2, 3, 2, 1});
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;

        ListNode next = null;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            next = slow.next;
            slow.next = prev;
            prev = slow;

            slow = next;
        }

        if (fast == null) {
            fast = slow;
        } else {
            fast = slow.next;
        }

        // as prev is head of first half i.e. reversed linked list
        slow = prev;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
