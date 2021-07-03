package com.ds.leetcode.linkedList;


import com.ds.list.ref.ListNode;

/*Problem 876: Middle of the Linked List*/
public class Problem_876 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(middleNode(head).val);
    }

    public static ListNode middleNode(ListNode head) {
        if(head == null)
            throw new NullPointerException();

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode middleNode = slow;
        return middleNode;
    }

}
