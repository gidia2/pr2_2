package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;


public abstract class Weapon extends GameObject{
	public static final int DAMAGE = 1;
	private Move dir;
	
	public Weapon(GameWorld game, Position pos, int life, Move dir) {
		super(game, pos, life);
		this.dir = dir;
	}
	
	@Override
	public void automaticMove() {	
		game.checkAttacks(this);
		if(isAlive()) {
			Position newPos = new Position(pos.getCol() + dir.getX(), pos.getRow() + dir.getY());
			if(newPos.isOnBoard())
				pos = newPos;
			else
				life = 0;
		}
	}
	
	@Override
	public boolean performAttack(GameItem other) {
		if(isAlive() && other.isAlive() && other.isOnPosition(pos)) {
			weaponAttack(other);
			receiveDamage(1);
		}
		return true;
	}
	
	protected abstract void weaponAttack(GameItem other);
	

	
	public String toString() {
		return isAlive() 
				? getSymbol() 
				: "";
	}
}
