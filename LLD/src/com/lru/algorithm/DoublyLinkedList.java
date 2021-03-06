package com.lru.algorithm;

import com.lru.algorithm.exception.InvalidElementException;

public class DoublyLinkedList<E> {
	DoublyLinkedListNode<E> dummyHead;
	DoublyLinkedListNode<E> dummyTail;

	public DoublyLinkedList() {
		this.dummyHead = new DoublyLinkedListNode<>(null);
		this.dummyTail = new DoublyLinkedListNode<>(null);

		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
	}

	public void detachNode(DoublyLinkedListNode<E> node) {
		if (node.prev != null)
			node.prev.next = node.next;
		else
			dummyHead = node.next;

		if (node.next != null)
			node.next.prev = node.prev;
		else
			dummyTail = node.prev;
	}

	public void addNodeAtLast(DoublyLinkedListNode<E> node) {
		DoublyLinkedListNode<E> tailPrev = dummyTail.prev;
		tailPrev.next = node;
		node.next = dummyTail;
		dummyTail.prev = node;
		node.prev = tailPrev;
	}

	public DoublyLinkedListNode<E> addElementAtLast(E element) {
		if (element == null)
			throw new InvalidElementException();
		DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
		addNodeAtLast(newNode);
		return newNode;
	}

	public boolean isItemAvailable() {
		return dummyHead.next != dummyTail;
	}

	public DoublyLinkedListNode<E> getFirstNode() {
		if (!isItemAvailable())
			return null;
		return dummyHead.next;
	}

	public DoublyLinkedListNode<E> getLastNode() {
		if (!isItemAvailable())
			return null;
		return dummyTail.prev;
	}

}
