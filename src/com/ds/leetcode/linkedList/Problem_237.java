package com.ds.leetcode.linkedList;

import com.ds.list.ref.ListNode;

/*Problem 237: Delete Node in a Linked List*/
public class Problem_237 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode node = head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        traverse(head);
        deleteNode(node);
        traverse(head);
    }

    private static void traverse(ListNode head) {
        ListNode tmp = head;
        StringBuilder stringBuilder = new StringBuilder();
        while(tmp != null) {
            if (tmp.next != null) {
                stringBuilder.append(tmp.val).append("->");
            } else {
                stringBuilder.append(tmp.val);
            }
            tmp = tmp.next;
        }
        System.out.println(stringBuilder.toString());
    }

    public static void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }

}
