package org.learning.designpattern.singleton;

// Lazy initialization Singleton
// Double Checked Locking or classic singleton
//when multiple thead are refer to a variable then this thread cache value in cpu register,
//so java has a keyword volatile, So that the other thead not use the cache version

public class SingletonLazy {
	
	private SingletonLazy() {
		
	}
	private static volatile SingletonLazy instance;

	public static SingletonLazy getInstance() {
		if (instance == null) {
			synchronized (SingletonLazy.class) {
				if (instance == null) {
					instance = new SingletonLazy();
				}
			}
		}
		return instance;
	}
}
