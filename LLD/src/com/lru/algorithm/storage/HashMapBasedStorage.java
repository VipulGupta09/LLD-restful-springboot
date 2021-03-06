package com.lru.algorithm.storage;

import java.util.HashMap;
import java.util.Map;

import com.lru.cache.exception.NotFoundException;
import com.lru.cache.exception.StorageFullException;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

	Map<Key, Value> storage;
	private final Integer capacity;

	public HashMapBasedStorage(Integer capacity) {
		this.capacity = capacity;
		storage = new HashMap<>();
	}

	public boolean isStorageFull() {
		return capacity == storage.size();
	}

	@Override
	public void add(Key key, Value value) throws StorageFullException {
		if (isStorageFull())
			throw new StorageFullException("Storage is full..");
		storage.put(key, value);
	}

	@Override
	public void remove(Key key) throws NotFoundException {
		if (!storage.containsKey(key))
			throw new NotFoundException(key + " doesn't exist in storage..");
		storage.remove(key);
	}

	@Override
	public Value get(Key key) throws NotFoundException {
		if (!storage.containsKey(key))
			throw new NotFoundException(key + " doesn't exist in storage..");
		return storage.get(key);
	}

}
