package tp1.logic;

public interface GameStatus {
	public static final int DIM_X = 9;
	public static final int DIM_Y = 8;
	
	public String positionToString(int x, int y);
	public String stateToString();
	
	public boolean playerWin();
	public boolean aliensWin();

	public int getCycle();
	public int getRemainingAliens();

}
