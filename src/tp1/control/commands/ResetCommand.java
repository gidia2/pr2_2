package tp1.control.commands;

import tp1.control.ExecutionResult;
import tp1.logic.GameModel;
import tp1.logic.Move;
import tp1.view.Messages;
import tp1.control.InitialConfiguration;

public class ResetCommand extends Command{
	
	InitialConfiguration conf;
	
	public ResetCommand() {conf = InitialConfiguration.NONE;}
	
	protected ResetCommand(InitialConfiguration conf) {
		this.conf = conf;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_RESET_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_RESET_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		return Messages.COMMAND_RESET_DETAILS;
	}

	@Override
	protected String getHelp() {
		return Messages.COMMAND_RESET_HELP;
	}

	@Override
	public ExecutionResult execute(GameModel game) {
		game.reset(conf);
		return new ExecutionResult(true);
	}
	
	@Override
	public Command parse(String[] commandWords) {
		//TODO fill with your code
		if (matchCommandName(commandWords[0])) {
			conf = InitialConfiguration.valueOfIgnoreCase(commandWords[1].toUpperCase());
			return new ResetCommand(conf);
		}
		else return null;
	}

}
