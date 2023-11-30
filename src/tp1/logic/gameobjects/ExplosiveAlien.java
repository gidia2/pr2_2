package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExplosiveAlien extends AlienShip {
	
	private static final int ARMOR = 2;
	private static final int DAMAGE = 1;
	private static final int POINTS = 12;

	public ExplosiveAlien(GameWorld game, Position pos, AlienManager alienManager) {
		super(game, pos, ARMOR, alienManager);
	}

	public ExplosiveAlien() {}

	protected int getPoints() {
		return POINTS;
	}

	protected String getDescription() {
		return Messages.EXPLOSIVE_ALIEN_DESCRIPTION;
	}

	protected String getSymbol() {
		return Messages.EXPLOSIVE_ALIEN_SYMBOL;
	}

	protected int getDamage() {
		return DAMAGE;
	}

	protected int getArmor() {
		return ARMOR;
	}
	
	@Override
	public boolean onDelete () {
		life = 0;
		game.receivePoints(getPoints());
		game.explosion(this);
		pos = null;
		game.alienDead(this);
		return true;
	}
	
	protected AlienShip copy(GameWorld game, Position pos, AlienManager am){
		return new ExplosiveAlien(game, pos, am);
	}

}
