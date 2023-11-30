package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class AlienShip extends EnemyShip{
	protected int cyclesToMove;
	private int speed;
	private AlienManager alienManager;
	
	public AlienShip(GameWorld game, Position pos, int life, AlienManager alienManager){
		super(game, pos, life);
		cyclesToMove = game.getLevel().getNumCyclesToMoveOneCell();
		speed = cyclesToMove;
		this.alienManager = alienManager;
	}
	
	public AlienShip() {}
	
	public void automaticMove() {
		if (cyclesToMove == 0) {
			move(dir);
			cyclesToMove = speed;
			if(isInBorder())
				alienManager.shipOnBorder();
		}
		
		else {
			if(alienManager.onBorder())
				descend();
			else
				cyclesToMove--;
		}
	}
	
	private boolean isInBorder() {
		return pos.getCol() == 0 || pos.getCol() == GameWorld.DIM_X - 1;
	}
	
	private void descend() {
		move(Move.DOWN);
		game.checkAttacks(this);
		if(isAlive()) {
			if(isInFinalRow())
				alienManager.squadInFinalRow();
			changeDir();
			alienManager.decreaseOnBorder();
		}
	}
	
	private boolean isInFinalRow() {
		return pos.getRow() == GameWorld.DIM_Y - 1;
	}

	private void changeDir() {
		if(dir == Move.LEFT)
			dir = Move.RIGHT;
		else
			dir = Move.LEFT;
	}
	
	public void receiveAttack(ShockWave weapon) {
		receiveDamage(weapon.getDamage());
	}
	
	public boolean onDelete () {
		pos = null;
		life = 0;
		game.receivePoints(getPoints());
		game.alienDead(this);
		return true;
	}
	
	protected abstract AlienShip copy(GameWorld game, Position pos, AlienManager am);
}
