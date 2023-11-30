package tp1.control.commands;

import tp1.control.ExecutionResult;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class SuperLaserCommand extends NoParamsCommand {

	@Override
	protected String getName() {
		return Messages.COMMAND_SUPER_LASER_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_SUPER_LASER_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		return Messages.COMMAND_SUPER_LASER_DETAILS;
	}

	@Override
	protected String getHelp() {
		return Messages.COMMAND_SUPER_LASER_HELP;
	}

	@Override
	public ExecutionResult execute(GameModel game) {
		if(game.shootSuperLaser()) {
			game.update();
			return new ExecutionResult(true, true, Messages.SUPER_LASER_ERROR);
		}
		return new ExecutionResult(false, true, Messages.SUPER_LASER_ERROR);
	}

}
