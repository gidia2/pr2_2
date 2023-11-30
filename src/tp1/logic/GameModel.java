package tp1.logic;

import tp1.control.InitialConfiguration;

public interface GameModel {
	public void exit();
	public void reset(InitialConfiguration conf);
	public void list();
	public boolean move(Move dir);
	public boolean shoot();
	public boolean shootSuperLaser();
	public boolean shockWave();
	
	public void update();
	
	public boolean isFinished();
}
