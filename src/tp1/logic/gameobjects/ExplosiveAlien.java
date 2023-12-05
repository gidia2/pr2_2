package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExplosiveAlien extends RegularAlien {
	
	private static final int DAMAGE = 1;
	private static final int POINTS = 12;

	public ExplosiveAlien(GameWorld game, Position pos, AlienManager alienManager) {
		super(game, pos, alienManager);
	}

	public ExplosiveAlien() {}

	protected int getPoints() {
		return POINTS;
	}

	public String getDescription() {
		return Messages.EXPLOSIVE_ALIEN_DESCRIPTION;
	}

	public String getSymbol() {
		return Messages.EXPLOSIVE_ALIEN_SYMBOL;
	}

	protected int getDamage() {
		return DAMAGE;
	}

	@Override
	public boolean onDelete() {
		game.explosion(this);
		return super.onDelete();
	}
	
	protected AlienShip copy(GameWorld game, Position pos, AlienManager am){
		return new ExplosiveAlien(game, pos, am);
	}

}
