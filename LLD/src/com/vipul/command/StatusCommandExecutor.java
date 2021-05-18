package com.vipul.command;

import java.util.List;

import com.vipul.OutputPrinter;
import com.vipul.model.Car;
import com.vipul.model.Command;
import com.vipul.model.Slot;
import com.vipul.service.ParkingLotService;

public class StatusCommandExecutor extends CommandExecutor {
	public static String COMMAND_NAME = "status";

	public StatusCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
		super(parkingLotService, outputPrinter);
	}

	@Override
	public boolean validate(Command command) {
		return command.getParams().isEmpty();
	}

	@Override
	public void execute(Command command) {
		final List<Slot> occupiedSlots = parkingLotService.getOccupiedSlot();

		if (occupiedSlots.isEmpty()) {
			outputPrinter.parkingLotEmpty();
			return;
		}

		outputPrinter.statusHeader();

		for (Slot slot : occupiedSlots) {
			final Car parkedCar = slot.getParkedCar();
			final String slotNumber = slot.getSlotNumber().toString();
			outputPrinter.printWithNewLine(padString(slotNumber, 12) + padString(parkedCar.getRegistrationNumber(), 19)
					+ parkedCar.getColor());
		}

	}

	private static String padString(final String word, final int length) {
		String newWord = word;
		for (int count = word.length(); count < length; count++) {
			newWord = newWord + " ";
		}
		return newWord;
	}

}
