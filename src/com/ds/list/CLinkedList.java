package com.ds.list;

import com.ds.list.ref.Node;

public class CLinkedList<E extends Number> {

	public Node<E> head;

	public void traverse() {
		System.out.println(traverse(this.head));
	}

	public String traverse(Node<E> node) {
		Node<E> tmp = node;
		StringBuilder sb = new StringBuilder();

		do {
			if (tmp.next != node) {
				sb.append(tmp.data).append(" -> ");
			} else {
				sb.append(tmp.data);
			}
			tmp = tmp.next;
		} while (tmp != node);

		return sb.toString();
	}

	// push element to front of circular list
	public Node<E> push(Node<E> head_ref, E data) {
		Node<E> ptr1 = new Node<>(data);
		ptr1.next = head_ref;
		Node<E> tmp = head_ref;

		// if linked list is not null
		if (head_ref != null) {
			while (tmp.next != head_ref) {
				tmp = tmp.next;
			}
			tmp.next = ptr1;
		} else {
			ptr1.next = ptr1;
		}
		head_ref = ptr1;
		return head_ref;
	}
}
