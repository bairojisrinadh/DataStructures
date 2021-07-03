package com.ds.leetcode.linkedList;

import com.ds.list.ref.ListNode;
import com.ds.list.ref.libraries.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*Problem 1721: Swapping Nodes in the linked list*/
public class Problem_1721 {

    public static void main(String[] args) {
        ListNode head = ListUtil.buildListFrmArray(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5});
        ListUtil.traverse(head);
        ListUtil.traverse(swapNodes2(head, 5));
    }

    public static ListNode swapNodes(ListNode head, int k) {
        // Base cases
        if (head == null) return null;
        if (head.next == null) return head;

        int n = 0;
        ListNode p1 = head;
        int kth_node_val = -1;
        ListNode kth_node = null;

        while (p1 != null) {
            n++;
            if (n == k) {
                kth_node = p1;
                kth_node_val = p1.val;
            }
            p1 = p1.next;
        }

        // if n is odd, then k == (n + 1) / 2, return function
        if (n % 2 != 0 && (k == (n + 1) / 2)) {
            return head;
        }

        p1 = head;
        int idx = 0;
        int kth_lastNode_val = -1;
        while (p1 != null) {
            idx++;
            if (n - idx + 1 == k) {
                kth_lastNode_val = p1.val;
                p1.val = kth_node_val;
                break;
            }
            p1 = p1.next;
        }
        kth_node.val = kth_lastNode_val;
        return head;
    }

    public static ListNode swapNodes1(ListNode head, int k) {
        // Base cases
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode p1 = head;
        List<Integer> arrayList = new ArrayList<>();

        while (p1 != null) {
            arrayList.add(p1.val);
            p1 = p1.next;
        }

        System.out.println(arrayList.toString());
        int n = arrayList.size();

        // if n is odd, then k == (n + 1) / 2, return function
        if (n % 2 != 0 && (k == (n + 1) / 2)) {
            return head;
        }

        //Swap
        int tmp = arrayList.get(k - 1);
        arrayList.set(k - 1, arrayList.get(n - k));
        arrayList.set(n - k, tmp);
        System.out.println(arrayList.toString());

        return buildFromArrayList(arrayList);
    }

    private static ListNode buildFromArrayList(List<Integer> arrayList) {
        ListNode head = null;
        ListNode tmp = head;
        for (int i = 0; i < arrayList.size(); i++) {
            if (head == null) {
                head = new ListNode(arrayList.get(i));
                tmp = head;
            } else {
                tmp.next = new ListNode(arrayList.get(i));
                tmp = tmp.next;
            }
        }
        return head;
    }

    // Best Solution: O(n) = 2ms
    public static ListNode swapNodes2(ListNode head, int k) {
        ListNode KthFromStart = head, out = head, KthFromLast = head;
        for (int i = 1; i < k; i++) {
            KthFromStart = KthFromStart.next;
        }
        ListNode temp_Node = KthFromStart;
        while (temp_Node.next != null) {
            temp_Node = temp_Node.next;
            KthFromLast = KthFromLast.next;
        }
        int temp = KthFromLast.val;
        KthFromLast.val = KthFromStart.val;
        KthFromStart.val = temp;
        return out;
    }
}
