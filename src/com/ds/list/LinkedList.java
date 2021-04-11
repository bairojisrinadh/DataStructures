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

	public boolean deleteAtPos(int pos) {
		if (this.head == null) {
			System.out.println("given linked list is empty");
			return false;
		}

		if (pos == 0) {
			this.head = this.head.next;
			return true;
		}
		Node<E> p1 = this.head;
		Node<E> p2 = p1.next;
		int curr_pos = 1;
		while (p2 != null && curr_pos != pos) {
			p1 = p1.next;
			p2 = p2.next;
			curr_pos++;
		}
		if (p2 == null) {
			System.out.println("provided pos: " + pos + " is greater than list size");
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

	public int size() {
		Node<E> tmp = this.head;
		int size = 0;
		while (tmp != null) {
			size++;
			tmp = tmp.next;
		}
		return size;
	}

	public int size_via_recursive(Node<E> node) {
		if (node == null)
			return 0;
		return 1 + size_via_recursive(node.next);
	}

	public boolean search(E key) {
		if (key == null) {
			System.out.println("Search key cannot be null");
			return false;
		}
		if (head.data == key) {
			return true;
		}
		Node<E> tmp = head.next;
		while (tmp != null) {
			if (tmp.data == key)
				return true;
			tmp = tmp.next;
		}
		return false;
	}

	public boolean search_via_recursion(E key) {
		return search_via_recursion(key, this.head);
	}

	private boolean search_via_recursion(E key, Node<E> node) {
		if (node == null)
			return false;
		if (node.data == key)
			return true;
		return search_via_recursion(key, node.next);
	}

	public E getNthNode(int pos) throws IndexOutOfBoundsException {
		if (pos - 1 < 0) {
			throw new IndexOutOfBoundsException(pos - 1);
		}
		if (pos - 1 == 0)
			return head.data;

		Node<E> tmp = this.head.next;
		int curr = 1;
		while (tmp != null && curr != pos - 1) {
			curr++;
			tmp = tmp.next;
		}
		if (tmp == null)
			throw new IndexOutOfBoundsException(pos);
		return tmp.data;
	}

	public E getNthNodeFrmLast(int pos) throws IndexOutOfBoundsException { // O(n + pos)
		int size = size(); // O(n)
		if (size < pos)
			throw new IndexOutOfBoundsException(pos);
		return getNthNode(size - pos + 1); // O(pos)
	}

	private E getNthNodeFrmLast2PtrApproach(int n) throws IndexOutOfBoundsException {
		if (this.head == null) {
			System.out.println("List is empty");
			return null;
		}
		Node<E> main_ptr = this.head;
		Node<E> ref_ptr = this.head;

		int curr = 0;
		while (curr < n) {
			if (ref_ptr == null)
				throw new IndexOutOfBoundsException(n);
			curr++;
			ref_ptr = ref_ptr.next;
		}
		// if ref_ptr == null, then we are pointing to head node from last
		if (ref_ptr == null) {
			return head.data;
		} else {
			while (ref_ptr != null) {
				main_ptr = main_ptr.next;
				ref_ptr = ref_ptr.next;
			}
			return main_ptr.data;
		}
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
		list.deleteAtPos(2);
		list.deleteAtPos(9);
		list.traverse();
		System.out.println(list.size());
		System.out.println(list.size_via_recursive(list.head));
		System.out.println(list.search(2));
		System.out.println(list.search(8));
		System.out.println(list.search_via_recursion(8));
		System.out.println(list.search_via_recursion(2));
		list.traverse();
		System.out.println(list.getNthNode(1));
		System.out.println(list.getNthNodeFrmLast(2));
		System.out.println(list.getNthNodeFrmLast2PtrApproach(4));
	}
}
