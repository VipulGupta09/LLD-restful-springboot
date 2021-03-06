package com.learn.generics;

import java.util.ArrayList;

class Gen<T> {
	T obj;

	Gen(T obj) {
		this.obj = obj;
	}

	public void show() {
		System.out.println("The type of obj :" + obj.getClass().getName());
	}

	public T getObject() {
		return obj;
	}

}

public class Generics {

	public static void main(String[] args) {

		Gen<String> g1 = new Gen<String>("Vipul");
		g1.show();
		System.out.println(g1.getObject());

		Gen<Integer> g2 = new Gen<Integer>(1);
		g2.show();
		System.out.println(g2.getObject());

		Gen<Double> g3 = new Gen<Double>(1.5);
		g3.show();
		System.out.println(g3.getObject());

	}

}
