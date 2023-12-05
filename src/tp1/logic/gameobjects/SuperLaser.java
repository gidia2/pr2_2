package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class SuperLaser extends UCMLaser {
	
	private static final int DAMAGE = 2;

	public SuperLaser(GameWorld game, Position pos) {
		super(game, pos);
	}

	@Override
	protected String getSymbol() {
		return Messages.SUPER_LASER_SYMBOL;
	}

	@Override
	public int getDamage() {
		return DAMAGE;
	}

}
