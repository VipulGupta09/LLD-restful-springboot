package com.lru.cache.exception;

public class StorageFullException extends RuntimeException {

	public StorageFullException(String str) {
		super(str);
	}

}
