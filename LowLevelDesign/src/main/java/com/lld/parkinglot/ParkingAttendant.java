package com.lld.parkinglot;

public class ParkingAttendant extends Account{

	Payment paymentService;
	
	// try to process the vehicle and return true or false whether it is able to process vehicle entry or not
	public boolean processVehicleEntry(Vehicle vehicle) {
		return false;
	}
	
	public PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType) {
		return null;	
	}
}
