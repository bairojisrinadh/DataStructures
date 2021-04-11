package com.ds.list;

import com.ds.list.ref.Node;

public class LinkedList<E> {

	Node<E> head;

	public void pushToStart(E element) {
		Node<E> new_node = new Node<>(element);
		new_node.next = this.head;
		this.head = new_node;
	}

	public void insertAfter(E prev_key, E element) {
		if (prev_key == null) {
			System.out.println("given previous key cannot be null");
			return;
		}
		Node<E> tmp = this.head;
		while (tmp != null && tmp.data != prev_key) {
			tmp = tmp.next;
		}
		if (tmp == null) {
			System.out.println("given previous key: " + prev_key + " not available in the list");
			return;
		}
		Node<E> new_node = new Node<>(element);
		new_node.next = tmp.next;
		tmp.next = new_node;
	}

	public void appendLast(E element) {
		Node<E> new_node = new Node<>(element);
		if (this.head == null) {
			this.head = new_node;
			return;
		}
		Node<E> tmp = this.head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = new_node;
	}

	public boolean delete(E del_key) {
		if (this.head == null) {
			System.out.println("given linked list is empty");
			return false;
		}

		if (this.head.data == del_key) {
			this.head = this.head.next;
			return true;
		}
		Node<E> p1 = this.head;
		Node<E> p2 = p1.next;
		while (p2 != null && p2.data != del_key) {
			p1 = p1.next;
			p2 = p2.next;
		}
		if (p2 == null) {
			System.out.println("provided key: " + del_key + " not available in the list");
			return false;
		}
		p1.next = p2.next;
		p2.next = null;
		return true;
	}

	public void traverse() {
		if (this.head == null) {
			System.out.println("given linked list is empty");
		}
		Node<E> tmp = this.head;
		StringBuilder sb = new StringBuilder();
		final String arrow_sym = " -> ";
		while (tmp != null) {
			if (tmp.next != null)
				sb.append(tmp.data).append(arrow_sym);
			else
				sb.append(tmp.data);
			tmp = tmp.next;
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.head = new Node<>(1);
		list.head.next = new Node<>(2);
		list.head.next.next = new Node<>(3);
		list.traverse();
		list.pushToStart(4);
		list.insertAfter(2, 5);
		list.insertAfter(6, 9);
		list.appendLast(6);
		list.traverse();
		list.delete(1);
		list.delete(7);
		list.traverse();
	}
}
