package tp1.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.logic.gameobjects.ExplosiveAlien;
import tp1.logic.gameobjects.GameObject;

public class GameObjectContainer {

	private List<GameObject> objects;

	public GameObjectContainer() {
		objects = new ArrayList<>();
	}

	public void add(GameObject object) {
		objects.add(object);
	}

	public void remove(GameObject object) {
		objects.remove(object);
	}

	public void automaticMoves() {
		for (int i=0;i<objects.size();i++) {
			GameObject object = objects.get(i);
			object.automaticMove();
			if(!object.isAlive() && object.onDelete())
				i--;
		}
	}

	public void computerActions() {
		for (int i=0;i<objects.size();i++) {
			GameObject object = objects.get(i);
			object.computerAction();
		}
	}
	
	public void performAttacks() {
		for (int i=0;i<objects.size();i++) {
			GameObject object = objects.get(i);
			performAttacks(object);
			if(!object.isAlive() && object.onDelete())
				i--;
		}
	}
	
	public void performAttacks(GameObject object) {
		for (int i=0;i<objects.size();i++) {
			GameObject other = objects.get(i);
			if(other != object) {
				if(!object.performAttack(other))
					break;
				if(!other.isAlive() && other.onDelete())
					i--;
			}
		}
	}
	
	public void checkAttacks(GameObject object) {
		for(int j = 0; j < objects.size(); j++) {
			GameObject other = objects.get(j);
			if(other != object) {
				other.performAttack(object);
				if(!other.isAlive() && other.onDelete())
					j--;
			}
		}
	}
	
	public void explosion(ExplosiveAlien alien) {
		Position centro = alien.getPosition();
		for(int i = 0; i < objects.size(); i++) {
			GameObject other = objects.get(i);
			if(other != alien) {
				if(affectedByExplosion(centro, other.getPosition())) {
					other.receiveAttack(alien);
					if(!other.isAlive() && other.onDelete()) i--;
				}
			}
		}
	}
	
	private boolean affectedByExplosion(Position centro, Position other) {
		return (other.equals(new Position(centro.getCol() - 1, centro.getRow()))) ||
		(other.equals(new Position(centro.getCol() - 1, centro.getRow() - 1))) ||
		(other.equals(new Position(centro.getCol() - 1, centro.getRow() + 1))) ||
		(other.equals(new Position(centro.getCol(), centro.getRow() - 1))) ||
		(other.equals(new Position(centro.getCol(), centro.getRow() + 1))) ||
		(other.equals(new Position(centro.getCol() + 1, centro.getRow()))) ||
		(other.equals(new Position(centro.getCol() + 1, centro.getRow() - 1))) ||
		(other.equals(new Position(centro.getCol() + 1, centro.getRow() + 1)));
	}
	
	public String toString(int col, int row) {
		StringBuilder posString = new StringBuilder();
		Position posActual = new Position(col, row);
		
		for(int i = 0; i < objects.size(); i++) {
			GameObject object = objects.get(i);
			if(object.isOnPosition(posActual))
				posString.append(object.toString());
		}
		
		return posString.toString();
	}
}
