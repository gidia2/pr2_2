package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.view.Messages;

public class Bomb extends EnemyWeapon{
	private static final int ARMOUR = 1;
	private static final int DAMAGE = 1;
	private DestroyerAlien owner;
	
	public Bomb(GameWorld game, DestroyerAlien destroyerAlien) {
		super(game, destroyerAlien.getPosition(), ARMOUR, Move.DOWN);
		this.owner = destroyerAlien;
	}
	
	@Override
	protected int getDamage() {
		return DAMAGE;
	}
	
	@Override
	protected int getArmor() {
		return ARMOUR;
	}
	
	@Override
	public boolean onDelete() {
		if(owner.isAlive())
			game.enableBomb(owner);
		owner = null;
		pos = null;
		life = 0;
		game.removeObject(this);
		return true;
	}
	
	@Override
	protected String getSymbol() {
		return Messages.BOMB_SYMBOL;
	}
}
