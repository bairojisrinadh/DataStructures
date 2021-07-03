package com.ds.leetcode.linkedList;

import com.ds.list.ref.ListNode;
import com.ds.list.ref.libraries.ListUtil;

/*Problem 21: Merge two sorted (increasing orders) lists*/
public class Problem_21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        ListNode head = mergeTwoLists(l1, l2);
        ListUtil.traverse(head);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //Base Conditions
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode newNode = new ListNode();
        ListNode tmp = newNode;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }

        if(l1 != null) tmp.next = l1;
        if(l2 != null) tmp.next = l2;
        return newNode.next;
    }
}
