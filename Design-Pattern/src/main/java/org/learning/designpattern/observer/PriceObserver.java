package org.learning.designpattern.observer;

public class PriceObserver implements OrderObserver {

	@Override
	public void updated(Order order) {
		double total = order.getCost();
		if(total>100) {
			order.setDiscount(10);
		}

	}

}
