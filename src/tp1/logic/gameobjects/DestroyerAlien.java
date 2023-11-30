package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.AlienManager;
import tp1.logic.Position;
import tp1.view.Messages;

/**
 * 
 * Class representing a regular alien
 *
 */
public class DestroyerAlien extends AlienShip{
	
	private static final int ARMOR = 1;
	private static final int DAMAGE = 1;
	private static final int POINTS = 10;
	private boolean canShootBomb;
	
	public DestroyerAlien(GameWorld game, Position pos, AlienManager alienManager) {
		super(game, pos, ARMOR, alienManager);
		canShootBomb = true;
	}
	
	public DestroyerAlien() {}
	
	
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
		return Messages.DESTROYER_ALIEN_SYMBOL;
	}
	
	public String getDescription() {
		return Messages.DESTROYER_ALIEN_DESCRIPTION;
	}
		
	//Métodos para llevar acabo las computer actions y soltar bombas
	public void computerAction() {
		if (canShootBomb && game.getRandom().nextDouble() < game.getLevel().getShootFrequency())
			performAttack();
	}
	
	private void performAttack() {
		Bomb bomb = new Bomb(game, this);
		game.addObject(bomb);
		canShootBomb = false;
	}
	
	public void enableBomb() {
		canShootBomb = true;
	}
	
	@Override
	protected AlienShip copy(GameWorld game, Position pos, AlienManager am){
		return new DestroyerAlien(game, pos, am);
	}
}