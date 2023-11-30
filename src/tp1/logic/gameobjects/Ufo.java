package tp1.logic.gameobjects;

//import java.util.Random;

import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;


public class Ufo extends EnemyShip {
	private static final int DAMAGE = 0;
	private static final int ARMOR = 1;
	private static final int POINTS = 25;
	private static final Position INITIAL_POSITION = new Position(9, 0);
	
	private boolean enabled;
	
	
	public Ufo(GameWorld game) {
		super(game, INITIAL_POSITION, 0);
		enabled = false;
	}
	
	protected int getDamage() {
		return DAMAGE;
	}
	
	protected int getArmor() {
		return ARMOR;
	}
	
	protected int getPoints() {
		return POINTS;
	}
	
	public String getSymbol() {
		return Messages.UFO_SYMBOL;
	}
	
	public String getDescription() {
		return Messages.UFO_DESCRIPTION;
	}
	
	public void automaticMove() {
		if(isAlive() && !move(dir)) {
			life = 0;
		}
	}
	
	//Método para las computerActions y hacer aparecer el Ufo
	public void computerAction() {
		if(!enabled && canGenerateRandomUfo())
			enable();
	}
	
	private void enable() {
		enabled = true;
		life = ARMOR;
		pos = INITIAL_POSITION;
	}

	private boolean canGenerateRandomUfo(){
		return  game.getRandom().nextDouble() < game.getLevel().getUfoFrequency();
	}
	
	public void receiveAttack(UCMLaser weapon) {
		game.enableShockWave();
		game.receivePoints(getPoints());
		receiveDamage(weapon.getDamage());
	}
	
	public void receiveAttack(SuperLaser weapon) {
		game.enableShockWave();
		game.receivePoints(getPoints());
		receiveDamage(weapon.getDamage());
	}
	
	public boolean onDelete() {
		enabled = false;
		life = 0;
		pos = null;
		return false;
	}
}
