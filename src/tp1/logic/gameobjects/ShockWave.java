package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class ShockWave extends UCMWeapon {
	private static final int DAMAGE = 1;
	private static final int ARMOR = 1;
	
	public ShockWave(GameWorld game, Position pos) {
		super(game, pos, ARMOR, Move.NONE);
	}

	@Override
	public int getDamage() {
		return DAMAGE;
	}
	
	@Override
	protected int getArmor() {
		return ARMOR;
	}
	
	@Override
	public boolean onDelete() {
		life = 0;
		pos = null;
		game.removeObject(this);;
		return true;
	}
	
	@Override
	protected String getSymbol() {
		return Messages.SHOCKWAVE_SYMBOL;
	}
	
	@Override
	public boolean performAttack(GameItem other) {
		weaponAttack(other);
		return true;
	}
	
	@Override
	public void weaponAttack(GameItem other) {
		other.receiveAttack(this);
	}
	
}
