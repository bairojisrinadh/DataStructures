package com.ds.list.clients;

import com.ds.list.CLinkedList;

public class CLinkedListClient {

	public static void main(String[] args) {
		CLinkedList<Integer> list = new CLinkedList<>();
		list.head = list.push(list.head, 12);
		list.push(list.head, 13);
		list.push(list.head, 15);
		list.push(list.head, 16);
		list.sortedPush(list.head, 14);
		list.traverse();
		System.out.println(list.checkLoopExists(list.head));
	}
}
