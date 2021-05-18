package org.learning.designpattern.singleton;

//Eager Approach
public class SingletonEager {
	private static final SingletonEager Instance = new SingletonEager();

	private SingletonEager() {

	}

	public static SingletonEager getInstance() {
		return Instance;
	}

}
