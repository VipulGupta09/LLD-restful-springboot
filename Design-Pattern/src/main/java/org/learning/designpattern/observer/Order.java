package org.learning.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private String id;
	private double cost;
	private int count;
	
	private double discount;
	private double shippingCost;
	
	
	
	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	private List<OrderObserver> observers = new ArrayList<OrderObserver>();
	
	public Order(String id) {
		this.id = id;
	}
	
	public void addItem(double price) {
		cost+=price;
		count++;
		observers.forEach(o->o.updated(this));
	}
	
	public void attach(OrderObserver observer) {
		observers.add(observer);
	}
	
	public void detach(OrderObserver observer) {
		observers.remove(observer);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getCost() {
		cost = cost-discount+shippingCost;
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", cost=" + cost + ", count=" + count + ", discount=" + discount + ", shippingCost="
				+ shippingCost + "]";
	}
	
	
}
