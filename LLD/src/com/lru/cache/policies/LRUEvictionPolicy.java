package com.lru.cache.policies;

import java.util.HashMap;
import java.util.Map;

import com.lru.algorithm.DoublyLinkedList;
import com.lru.algorithm.DoublyLinkedListNode;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

	private DoublyLinkedList<Key> dll;
	private Map<Key, DoublyLinkedListNode<Key>> mapper;

	LRUEvictionPolicy() {
		this.dll = new DoublyLinkedList<>();
		this.mapper = new HashMap<>();

	}

	@Override
	public void keyAccessed(Key key) {
		if (mapper.containsKey(key)) {
			dll.detachNode(mapper.get(key));
			dll.addNodeAtLast(mapper.get(key));
		} else {
			DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
			mapper.put(key, newNode);
		}
	}

	@Override
	public Key evict() {
		DoublyLinkedListNode<Key> first = dll.getFirstNode();
		if(first == null)
			return null;
		dll.detachNode(first);
		return first.getElement();
	}

}
