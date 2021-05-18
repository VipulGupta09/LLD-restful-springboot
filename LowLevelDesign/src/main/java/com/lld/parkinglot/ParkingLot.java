package com.lld.parkinglot;

import java.util.List;

//Base class
public class ParkingLot {

	List<ParkingFloor> parkingFloors; // ParkingLot consists of multiple levels of parking floor
	List<Entrance> entrances; // Consists of multiple Entry gate
	List<Exit> exits;			// Consists of multiple Exit gate
	
	
	//Note:
	// As we know that entry and exit gates are having the same data (gateId and parkingAttendant)
	// So we take a base class as Gate and extends both from this Entrance and Exit 
	
	
	//meta data to parkinglot
	Address address;
	String parkingLotName; 
	
	
	//Two api's we are exposing from the base parkinglot class, use at parkinglot level so we are defining at parkinglot level
	
	//Take input as vehicle object and return boolean based on evaluation of if space is available for a particular vehicle or not
	public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle) {
		return false;
	}
	
	// Take parkingattd and gateid and update parkingattnd with either entry or exit gate, we are taking input as gateid which is inheritance(is-a) between
	//2 subclass entry and exit from Gate class as parent
	public boolean updateParkingAttendant(ParkingAttendant parkingAttendant, int gateId) {
		return false;
	}
	
	
}
