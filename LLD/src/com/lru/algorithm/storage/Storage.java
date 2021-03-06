package com.lru.algorithm.storage;

import com.lru.cache.exception.NotFoundException;
import com.lru.cache.exception.StorageFullException;

public interface Storage<Key, Value> {

	public void add(Key key, Value value) throws StorageFullException;

	public void remove(Key key) throws NotFoundException;

	public Value get(Key key) throws NotFoundException;

}
