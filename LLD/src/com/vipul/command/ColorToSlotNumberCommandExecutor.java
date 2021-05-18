package com.vipul.command;

import java.util.List;
import java.util.stream.Collectors;

import com.vipul.OutputPrinter;
import com.vipul.model.Command;
import com.vipul.model.Slot;
import com.vipul.service.ParkingLotService;

public class ColorToSlotNumberCommandExecutor extends CommandExecutor {
	public static String COMMAND_NAME = "slot_numbers_for_cars_with_colour";

	public ColorToSlotNumberCommandExecutor(final ParkingLotService parkingLotService,
			final OutputPrinter outputPrinter) {
		super(parkingLotService, outputPrinter);
	}

	@Override
	public boolean validate(Command command) {
		return command.getParams().size() == 1;
	}

	@Override
	public void execute(Command command) {
		final List<Slot> slotsForColor = parkingLotService.getSlotsForColor(command.getParams().get(0));
		if (slotsForColor.isEmpty()) {
			outputPrinter.notFound();
		} else {
			final String result = slotsForColor.stream().map(slot -> slot.getSlotNumber().toString())
					.collect(Collectors.joining(", "));
			outputPrinter.printWithNewLine(result);
		}

	}
}
