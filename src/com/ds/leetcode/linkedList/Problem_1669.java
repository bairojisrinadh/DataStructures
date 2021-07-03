package com.ds.leetcode.linkedList;

import com.ds.list.ref.ListNode;
import com.ds.list.ref.libraries.ListUtil;

import java.util.List;

/*Problem 1669: Merge in between linked lists*/
public class Problem_1669 {

    public static void main(String[] args) {
        ListNode list1 = ListUtil.buildListFrmArray(new int[]{0, 1, 2, 3, 4, 5, 6});
        ListUtil.traverse(list1);
        ListNode list2 = ListUtil.buildListFrmArray(new int[]{100, 101, 102});
        ListUtil.traverse(list2);
        ListNode result = mergeInBetween(list1, 2, 5, list2);
        ListUtil.traverse(result);
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null || list2 == null) return null;

        // Below will get references for head & tail nodes of list2
        ListNode head2 = list2;
        ListNode tail2 = null;
        while(list2 != null) {
            tail2 = list2;
            list2 = list2.next;
        }

        ListNode head1 = list1;
        int index_a = 0;
        int index_b = 0;
        // Append list2 at the beginning & attach remaining nodes after index 'b'
        if(index_a == a) {
            while(index_b++ != b) {
                head1 = head1.next;
            }
            tail2.next = head1.next;
            return head2;
        } else {
            head1 = list1;
            ListNode prev1 = head1;
            while(index_a++ != a) {
                prev1 = head1;
                head1 = head1.next;
            }
            prev1.next = head2;
            index_b = index_a - 1;
            while(index_b++ != b) {
                head1 = head1.next;
            }
            tail2.next = head1.next;
            return list1;
        }
    }
}
