package org.learning.designpattern.observer;

public class Client {

	public static void main(String[] args) {
		Order order = new Order("10");
		PriceObserver price = new PriceObserver();
		
		order.attach(price);
		
		order.addItem(9);
		order.addItem(100);
		
		System.out.println(order);

	}

}
