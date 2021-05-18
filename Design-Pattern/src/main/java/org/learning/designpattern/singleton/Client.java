package org.learning.designpattern.singleton;

public class Client {
	public static void main(String[] args) {
		SingletonEager singleton = SingletonEager.getInstance();
		SingletonEager singleton2 = SingletonEager.getInstance();
		if(singleton == singleton2)
			System.out.println(true);
		
		SingletonLazy singletonLazy = SingletonLazy.getInstance();
		SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
		if(singletonLazy == singletonLazy2)
			System.out.println(true);
	}
}
