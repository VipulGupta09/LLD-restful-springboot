package com.vipul.command;

import com.vipul.OutputPrinter;
import com.vipul.exception.NoFreeSlotAvailableException;
import com.vipul.model.Car;
import com.vipul.model.Command;
import com.vipul.service.ParkingLotService;

/**
 * Executor to handle command of parking a car into the parking lot. This outputs the alloted slot
 * in which the car is parked.
 */
public class ParkCommandExecutor extends CommandExecutor {
	
	public static String COMMAND_NAME = "park";

	public ParkCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
		super(parkingLotService, outputPrinter);
	}

	@Override
	public boolean validate(Command command) {

		return command.getParams().size() == 2;
	}

	@Override
	public void execute(Command command) {
		final Car car = new Car(command.getParams().get(0), command.getParams().get(1));
		try {
			final Integer slotNumber = parkingLotService.park(car);
			outputPrinter.printWithNewLine("Allocated Slot number: " + slotNumber);
		} catch (NoFreeSlotAvailableException e) {
			outputPrinter.parkingLotFull();
		}

	}

}
