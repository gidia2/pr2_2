package tp1.logic;

import java.util.Random;

import tp1.logic.gameobjects.AlienShip;
import tp1.logic.gameobjects.DestroyerAlien;
import tp1.logic.gameobjects.ExplosiveAlien;
import tp1.logic.gameobjects.GameObject;

public interface GameWorld {
	public static final int DIM_X = 9;
	public static final int DIM_Y = 8;
	
	public Random getRandom();
	public Level getLevel();
	
	public void addObject(GameObject object);
	public void removeObject(GameObject object);
	
	public void performAttacks(GameObject object);
	public void checkAttacks(GameObject object);
	public void explosion(ExplosiveAlien alien);
	
	public void enableBomb(DestroyerAlien alien);
	public void enableLaser();
	public void enableShockWave();
	
	public void alienDead(AlienShip alien);
	
	public void receivePoints(int points);
}
