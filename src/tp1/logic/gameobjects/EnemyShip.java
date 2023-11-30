package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;
import tp1.logic.GameWorld;
import tp1.logic.Move;

public abstract class EnemyShip extends Ship{
	Move dir;
	
	public EnemyShip(GameWorld game, Position pos, int life) {
		super(game, pos, life);
		this.dir = Move.LEFT;
	}
	
	public EnemyShip() {}
	
	protected abstract int getPoints();
	
	public void receiveAttack(UCMLaser weapon) {
		receiveDamage(weapon.getDamage());
	}
	
	public void receiveAttack(SuperLaser weapon) {
		receiveDamage(weapon.getDamage());
	}

	public String getInfo() {
		return Messages.alienDescription(getDescription(), getPoints(), getDamage(), getArmor());
	}
}
