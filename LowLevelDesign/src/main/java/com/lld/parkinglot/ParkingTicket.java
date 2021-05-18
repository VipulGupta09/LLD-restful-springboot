package com.lld.parkinglot;

import java.util.Date;

// all the data in this class will be filled as the vehicel enter the parkinglot except the vehiceExitDateTime and totalCost
//So for them we will be exposing 2 api's updateVehicelexitTime api and update total cost api
public class ParkingTicket {

	int ticketId;
	int levelId;
	int spaceId;
	Date vehicleEntryDateTime;
	Date vehicleExitDateTime;
	ParkingSpaceType parkingSpaceType;
	double totalCost;
	ParkingTicketStatus parkingTicketStatus;

	public void updateTotalCost() {
	}
	public void updateVehicleExitTime(Date vehicleExitDateTime) {
	}
}
