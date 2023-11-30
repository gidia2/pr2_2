package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Position;

public abstract class GameObject implements GameItem {

	protected Position pos;
	protected int life;
	protected GameWorld game;
	
	public GameObject(GameWorld game, Position pos, int life) {	
		this.pos = pos;
		this.game = game;
		this.life = life;
	}
	
	public GameObject() {}
	
	@Override
	public boolean isAlive() {
		return this.life > 0;
	}

	public int getLife() {
		return this.life;
	}
	
	public Position getPosition() {
		return pos;
	}
	
	@Override
	public boolean isOnPosition(Position pos) {
		if(this.pos == null) return false;
		else return this.pos.equals(pos);
	}
	
	public void receiveDamage(int damage) {
		life -= damage;
	}

	protected abstract String getSymbol();
	protected abstract int getDamage();
	protected abstract int getArmor();

	public abstract boolean onDelete();
	
	public void automaticMove() {}
	public void computerAction() {}
	
	@Override
	public boolean performAttack(GameItem other) {return false;}
	@Override
	public void receiveAttack(EnemyWeapon weapon) {}
	@Override
	public void receiveAttack(UCMLaser weapon) {}
	@Override
	public void receiveAttack(SuperLaser weapon) {}
	@Override
	public void receiveAttack(ShockWave weapon) {}
	
	public void receiveAttack(ExplosiveAlien alien) {
		receiveDamage(alien.getDamage());
	}
}
