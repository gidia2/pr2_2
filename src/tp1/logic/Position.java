package tp1.logic;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private int col;
	private int row;

	//TODO fill your code
	
	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}
	
	//public void move() {}
	
	//public boolean hashCode(){}
	
	public boolean equals(Position position) {
		return this.col == position.getCol() && this.row == position.getRow();
	}
	
	public boolean isOnBoard() {
		return col >= 0 && row >= 0 && col < Game.DIM_X && row < Game.DIM_Y;
	}
	
	public int getCol() {
		return col;
	}
	
	public int getRow() {
		return row;
	}
	
	//public void add() {}
	
	
}
