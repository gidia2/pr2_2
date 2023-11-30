package tp1.control.commands;

import tp1.control.ExecutionResult;
import tp1.logic.GameModel;
import tp1.logic.Move;
import tp1.view.Messages;

public class MoveCommand extends Command {

	private Move move;

	public MoveCommand() {}

	protected MoveCommand(Move move) {
		this.move = move;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_MOVE_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_MOVE_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		return Messages.COMMAND_MOVE_DETAILS;
	}

	@Override
	protected String getHelp() {
		return Messages.COMMAND_MOVE_HELP;
	}

	@Override
	public ExecutionResult execute(GameModel game) {
		//TODO fill with your code
		if(game.move(move)){
			game.update();
			return new ExecutionResult(true, true, Messages.MOVEMENT_ERROR);
		}
		return new ExecutionResult(false, true, Messages.MOVEMENT_ERROR);
	}


	@Override
	public Command parse(String[] commandWords) {
		//TODO fill with your code
		if (matchCommandName(commandWords[0])) {
			//move = getMove(commandWords[1].toLowerCase());
			try {
				move = Move.valueOf(commandWords[1].toUpperCase());
				return new MoveCommand(move);
			} catch(IllegalArgumentException e){
				return null;
			}
		}
		else return null;
	}
}
