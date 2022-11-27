package by.BSUIR.WT.Lab4.controller.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandFactory {

	private static final CommandFactory instance = new CommandFactory();
	private static final Map<String, Command> commands = new HashMap<>();
	
	private CommandFactory() {
		
	}
	
	public static CommandFactory getInstance() {
		return instance;
	}
	
	public Command getCommand(String name) {
		return Optional.ofNullable(commands.get(name)).orElse(commands.get(CommandName.DEFAULT_COMMAND));
	}
}
