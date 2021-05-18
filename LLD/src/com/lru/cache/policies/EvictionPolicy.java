package com.lru.cache.policies;

public interface EvictionPolicy<Key> {

	void keyAccessed(Key key);

	Key evict();
}
