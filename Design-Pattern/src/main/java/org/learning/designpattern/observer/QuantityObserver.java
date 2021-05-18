package org.learning.designpattern.observer;

public class QuantityObserver implements OrderObserver {

	@Override
	public void updated(Order order) {
		int count = order.getCount();
		if(count > 10) {
			order.setShippingCost(10);
		}

	}

}
