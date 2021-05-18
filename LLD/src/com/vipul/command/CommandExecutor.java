package com.vipul.command;

import com.vipul.OutputPrinter;
import com.vipul.model.Command;
import com.vipul.service.ParkingLotService;

/**
 * Command executor interface.
 */
public abstract class CommandExecutor {

	protected ParkingLotService parkingLotService;
	protected OutputPrinter outputPrinter;

	public CommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
		this.parkingLotService = parkingLotService;
		this.outputPrinter = outputPrinter;
	}

	/**
	 * Validates that whether a command is valid to be executed or not.
	 *
	 * @param command Command to be validated.
	 * @return Boolean indicating whether command is valid or not.
	 */
	public abstract boolean validate(Command command);

	/**
	 * Executes the command.
	 *
	 * @param command Command to be executed.
	 */
	public abstract void execute(Command command);

}
