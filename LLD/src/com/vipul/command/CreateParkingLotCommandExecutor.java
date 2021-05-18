package com.vipul.command;

import java.util.List;

import com.vipul.OutputPrinter;
import com.vipul.model.Command;
import com.vipul.model.ParkingLot;
import com.vipul.model.parking.strategy.NaturalOrderingParkingStrategy;
import com.vipul.service.ParkingLotService;
import com.vipul.validator.IntegerValidator;

public class CreateParkingLotCommandExecutor extends CommandExecutor {
	public static String COMMAND_NAME = "create_parking_lot";

	public CreateParkingLotCommandExecutor(final ParkingLotService parkingLotService,
			final OutputPrinter outputPrinter) {
		super(parkingLotService, outputPrinter);
	}

	@Override
	public boolean validate(Command command) {
		final List<String> params = command.getParams();
		if (params.size() != 1) {
			return false;
		}
		return IntegerValidator.isInteger(params.get(0));
	}

	@Override
	public void execute(Command command) {
		final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
		final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
		parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
		outputPrinter.printWithNewLine("Created a parking lot with " + parkingLot.getCapacity() + " slots");
	}
}
