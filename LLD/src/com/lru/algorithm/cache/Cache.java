package com.lru.algorithm.cache;

import com.lru.algorithm.storage.Storage;
import com.lru.cache.exception.NotFoundException;
import com.lru.cache.exception.StorageFullException;
import com.lru.cache.policies.EvictionPolicy;

public class Cache<Key, Value> {

	private final EvictionPolicy<Key> evictionPolicy;
	private final Storage<Key, Value> storage;

	public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
		this.evictionPolicy = evictionPolicy;
		this.storage = storage;
	}

	public void put(Key key, Value value) {
		try {
			this.storage.add(key, value);
			this.evictionPolicy.keyAccessed(key);
		} catch (StorageFullException exception) {
			System.out.println("Got Storage full will try to evict..");
			Key keyToRemove = evictionPolicy.evict();
			if (keyToRemove == null) {
				throw new RuntimeException("Unexpected state,Storage full and no key to evict");
			}
			this.storage.remove(keyToRemove);
			System.out.println("Created space by evicting the key " + keyToRemove);
			put(key, value);
		}
	}

	public Value get(Key key) {
		try {
			Value value = this.storage.get(key);
			this.evictionPolicy.keyAccessed(key);
			return value;
		} catch (NotFoundException notFoundException) {
			System.out.println("Try to access non-existing key");
			return null;
		}
	}

}
