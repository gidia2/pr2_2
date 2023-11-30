package tp1.control.commands;

import java.util.Arrays;
import java.util.List;

public class CommandGenerator {

	private static final List<Command> availableCommands = Arrays.asList(
		new NoneCommand(),
		new MoveCommand(),
		new ShootCommand(),
		new ShockWaveCommand(),
		new ResetCommand(),
		new ExitCommand(),
		new HelpCommand(),
		new ListCommand(),
		new SuperLaserCommand()
	);

	public static Command parse(String[] commandWords) {		
		Command command = null;
		for (Command c: availableCommands) {
			command = c.parse(commandWords);
			if(command != null)	
				break;
		}
		return command;
	}
		
	public static String commandHelp() {
		StringBuilder commands = new StringBuilder();	
		for (Command c: availableCommands) {
			commands
			.append(c.getDetails()).append(" ")
			.append(c.getHelp()).append("\n");
		}
		return commands.toString();
	}

}
