package com.ds.list.ref;

public class Node<E> {
	public E data;
	public Node<E> next;

	public Node(E data) {
		super();
		this.data = data;
		this.next = null;
	}

	public Node(E data, Node<E> next) {
		super();
		this.data = data;
		this.next = next;
	}

}
