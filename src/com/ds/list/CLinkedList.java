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

	public void sortedPush(Node<E> head_ref, E data) {
		Node<E> new_node = new Node<>(data);
		Node<E> current = head_ref;

		//Case 1: If list is empty
		if(current == null) {
			new_node.next = new_node;
			head_ref = new_node;
			this.head = head_ref;
		}
		//Case 2: If new_node is less than head node alias first node
		else if ((current.data).intValue() >= (new_node.data).intValue()) {
			while(current.next != head_ref)
				current = current.next;

			current.next = new_node;
			new_node.next = head_ref;
			this.head = new_node;
		}
		//Case 3: Get the correct position of new_node and insert it
		else {
			while(current.next != head_ref && (current.next.data).intValue() < (new_node.data).intValue()) {
				current = current.next;
			}
			new_node.next = current.next;
			current.next = new_node;
		}
	}

	public boolean checkLoopExists(Node<E> head_ref) {
		if(head_ref == null) return true;
		Node<E> tmp = head_ref.next;

		while(tmp != null && tmp != head_ref) {
			tmp = tmp.next;
		}

		return tmp == head_ref;
	}
}
