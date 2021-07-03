package com.ds.leetcode.linkedList;

import com.ds.list.ref.ListNode;
import com.ds.list.ref.libraries.ListUtil;

/*Problem 160: Intersection of two linked lists*/
public class Problem_160 {

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);
        headA.next.next = intersect;
        ListUtil.traverse(headA);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;
        ListUtil.traverse(headB);
        ListNode intersectionNode = getIntersectionNode1(headA, headB);
        ListUtil.traverse(intersectionNode);
        ListUtil.traverse(headA);
        ListUtil.traverse(headB);
    }

    /*Dry Run:
    headA: 4->1->8->4->5
    headB: 5->6->1->8->4->5*/
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode lastNode = ListUtil.getLastNode(headA);
        lastNode.next = headA;
        ListNode fast = headB;
        ListNode slow = headB;
        boolean firstTime = true;
        while (fast != null && fast.next != null && slow != null && (fast != slow || firstTime)) {
            fast = fast.next.next;
            slow = slow.next;
            firstTime = false;
        }
        // there is no intersection
        if (fast == null || fast.next == null) {
            lastNode.next = null;
            return null;
        }
        ListNode slow2 = headB;
        while (slow != null && slow2 != null && slow != slow2) {
            slow = slow.next;
            slow2 = slow2.next;
        }
        // revert the lastNode to headA pointer
        lastNode.next = null;
        return slow2;
    }

    //Implementation 2: Using length of both lists & then finding the intersection node
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        int len1 = 0;
        int len2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }
        p1 = headA;
        p2 = headB;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                p2 = p2.next;
            }
        }
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}
