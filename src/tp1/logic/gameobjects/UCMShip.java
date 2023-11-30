package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMShip extends Ship {
	private static final int ARMOR = 3;
	private static final int DAMAGE = 1;	
	private static final Position INITIAL_POS = new Position(4, 7);

	private int points;
	private boolean hasShockWave;
	private boolean canShootLaser;
	private boolean canShootSuperLaser;
	
	public UCMShip(GameWorld game) {
		super(game, INITIAL_POS, ARMOR);
		points = 0;
		hasShockWave = false;
		canShootLaser = true;
		canShootSuperLaser = true;
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
	protected String getSymbol() {
		return isAlive()
				? Messages.UCMSHIP_SYMBOL 
				: Messages.UCMSHIP_DEAD_SYMBOL;
	}
	
	@Override
	public String getInfo() {
		return Messages.ucmShipDescription(getDescription(), DAMAGE, ARMOR);
	}
	
	public String getDescription() {
		return Messages.UCMSHIP_DESCRIPTION;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void receivePoints(int points) {
		this.points += points;
	}
	
	public void enableLaser(){
		canShootLaser = true;
	}
	
	public void enableSuperLaser(){
		canShootSuperLaser = true;
	}
	
	public boolean hasShockWave() {
		return hasShockWave;
	}
	public void enableShockWave() {
		hasShockWave = true;
	}
	
	public boolean shootLaser() {
		if(canShootLaser) {
			UCMLaser laser = new UCMLaser(game, pos);
			game.addObject(laser);
			canShootLaser = false;
			return true;
		}
		return false;
	}
	
	public boolean shootSuperLaser() {
		if(canShootSuperLaser && points >= 5) {
			SuperLaser superLaser = new SuperLaser(game, pos);
			game.addObject(superLaser);
			canShootSuperLaser = false;
			points -= 5;
			return true;
		}
		return false;
	}
	
	public boolean shockWave() {
		if(hasShockWave) {
			ShockWave shockwave = new ShockWave(game, pos);
			game.addObject(shockwave);
			game.performAttacks(shockwave);
			game.removeObject(shockwave);
			hasShockWave = false;
			return true;
		}
		return false;
	}
	
	public void receiveAttack(EnemyWeapon weapon) {
		receiveDamage(weapon.getDamage());
	}
	
	public String toString() {
		return isAlive()
				? Messages.UCMSHIP_SYMBOL 
				: Messages.UCMSHIP_DEAD_SYMBOL;
	}
	
	public boolean onDelete() {
		life = 0;
		return false;
	}
}
