package tp1.control.commands;

import tp1.control.ExecutionResult;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class ShootCommand extends NoParamsCommand {
	@Override
	protected String getName() {
		return Messages.COMMAND_SHOOT_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_SHOOT_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		return Messages.COMMAND_SHOOT_DETAILS;
	}

	@Override
	protected String getHelp() {
		return Messages.COMMAND_SHOOT_HELP;
	}

	@Override
	public ExecutionResult execute(GameModel game) {
		//TODO fill with your code
		if(game.shoot()) {
			game.update();
			return new ExecutionResult(true, true, Messages.LASER_ERROR);
		}
		return new ExecutionResult(false, true, Messages.LASER_ERROR);
	}
}
