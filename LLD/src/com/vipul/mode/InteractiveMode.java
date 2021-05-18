package com.vipul.mode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.vipul.OutputPrinter;
import com.vipul.command.CommandExecutorFactory;
import com.vipul.command.ExitCommandExecutor;
import com.vipul.model.Command;

public class InteractiveMode extends Mode {

	public InteractiveMode(CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter) {
		super(commandExecutorFactory, outputPrinter);
	}

	@Override
	public void process() throws IOException {
		outputPrinter.welcome();
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			final String input = reader.readLine();
			final Command command = new Command(input);
			processCommand(command);
			if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
				break;
			}
		}
	}
}
