package tp1.control.commands;

import tp1.control.ExecutionResult;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class ShockWaveCommand extends NoParamsCommand {
	@Override
	protected String getName() {
		return Messages.COMMAND_SHOCKWAVE_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_SHOCKWAVE_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		return Messages.COMMAND_SHOCKWAVE_DETAILS;
	}

	@Override
	protected String getHelp() {
		return Messages.COMMAND_SHOCKWAVE_HELP;
	}

	@Override
	public ExecutionResult execute(GameModel game) {
		if(game.shockWave()) {
			game.update();
			return new ExecutionResult(true, true, Messages.SHOCKWAVE_ERROR);
		}
		return new ExecutionResult(false, true, Messages.SHOCKWAVE_ERROR);
	}
}
