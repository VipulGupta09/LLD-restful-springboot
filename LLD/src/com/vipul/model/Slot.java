package com.vipul.model;

public class Slot {
	private Car parkedCar;
	private Integer slotNumber;
	
	public Slot(Integer slotNumber) {
		this.slotNumber = slotNumber;
	}
	public Car getParkedCar() {
		return parkedCar;
	}
	public Integer getSlotNumber() {
		return slotNumber;
	}
	
	public void assignCar(Car car) {
		this.parkedCar = car;
	}
	
	public void unassignCar() {
		this.parkedCar = null;
	}
	
	public boolean isSlotFree() {
		return parkedCar == null;
	}
	
	
}
