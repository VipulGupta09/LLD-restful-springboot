package com.lld.parkinglot;

import java.util.List;

//Contains all the information help us identify a unique parkingfloor inside parkinglot
public class ParkingFloor {

	int levelId; // levelId
	boolean isFull; 
	List<ParkingSpace> parkingSpaces; // desined for seperate kind of vehicles
	ParkingDisplayBoard parkingDisplayBoard; // dispay board for avaibility of different kind of parking space and their quantity
	
}
