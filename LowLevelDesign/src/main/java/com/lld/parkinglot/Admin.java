package com.lld.parkinglot;

// This is responsible for adding new parkingfloor, spaces, dispalyboard per parkingfloor
// admin is also type of account so their is-a kind relationship between admin and account
public class Admin extends Account{
	
	//define api pakingfloor at which parking lot
	public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor) {
		return false;
	}
	
	// define parkingspaces at that parkingfloor
	public boolean addParkingSpace(ParkingFloor parkingFloor, ParkingSpace parkingSpace) {
		return false;
		
	}
	
	public boolean addParkingDisplayBoard(ParkingFloor parkingFloor, ParkingDisplayBoard parkingDisplayBoard) {
		return false;
		
	}

}
