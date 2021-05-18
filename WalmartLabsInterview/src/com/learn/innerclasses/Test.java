package com.learn.innerclasses;


class Outer{
	 class Inner{
		public void m1() {
			System.out.println("Inner Class");
		}
	}
	public void m1() {
		System.out.println("Outer Class");
	}
}

public class Test {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.m1();
		Outer.Inner inner = outer.new Inner();
		inner.m1();

	}

}
