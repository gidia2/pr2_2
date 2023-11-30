package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class SuperLaser extends UCMWeapon {
	
	private static final int ARMOR = 1;
	private static final int DAMAGE = 2;

	public SuperLaser(GameWorld game, Position pos) {
		super(game, pos, ARMOR, Move.UP);
	}

	@Override
	protected void weaponAttack(GameItem other) {
		other.receiveAttack(this);
	}

	@Override
	protected String getSymbol() {
		return Messages.SUPER_LASER_SYMBOL;
	}

	@Override
	protected int getDamage() {
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
		game.enableSuperLaser();
		game.removeObject(this);
		return true;
	}

}
