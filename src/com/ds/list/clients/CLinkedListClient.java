package com.ds.list.clients;

import com.ds.list.CLinkedList;

public class CLinkedListClient {

	public static void main(String[] args) {
		CLinkedList<Integer> list = new CLinkedList<>();
		list.head = list.push(list.head, 12);
		list.push(list.head, 56);
		list.push(list.head, 2);
		list.push(list.head, 11);
		list.traverse();
	}
}
