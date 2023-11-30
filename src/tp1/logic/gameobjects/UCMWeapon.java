package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class UCMWeapon extends Weapon {

	public UCMWeapon(GameWorld game, Position pos, int life, Move dir) {
		super(game, pos, life, dir);
	}
	
	@Override
	public void receiveAttack(EnemyWeapon weapon) {
		receiveDamage(weapon.getDamage());
	}

}
