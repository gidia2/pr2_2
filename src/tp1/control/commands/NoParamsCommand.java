package tp1.control.commands;

public abstract class NoParamsCommand extends Command {

	@Override
	public Command parse(String[] commandWords) {
		//TODO fill with your code
		if(matchCommandName(commandWords[0])) return this;
		else return null;
	}
	
}
