package entities;

import java.util.ArrayList;

public class Coordinate {
	private int x;
	private int y;
	
	public Coordinate(int xCoordinate, int yCoordinate) {
		x = xCoordinate;
		y = yCoordinate;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	/*public void setCoordinate(int setX, int setY) {
		x = setX;
		y = setY;
	}*/	
	public void moveUp() {
		y++;
	}
	public void moveDown() {
		y--;
	}
	public void moveRight() {
		x++;
	}
	public void moveLeft() {
		x--;
	}
	public String toString() {
		String sCoordinate = "x: " + x + " y: " + y;
		return sCoordinate;
	}
	public boolean isInAfterDecY(ArrayList<Coordinate> coordinates) {
		for (Coordinate c : coordinates) {
			if  (x == c.getX()&&y-1==c.getY()){
				return true;
			}
		}
		return false;
	}
	public boolean isInAfterDecX(ArrayList<Coordinate> coordinates) {
		for (Coordinate c : coordinates) {
			if (x-1 == c.getX()&&y==c.getY()) {
				return true;
			}
		}
		return false;
	}
	public boolean isInAfterIncX(ArrayList<Coordinate> coordinates) {
		for (Coordinate c : coordinates) {
			if (x+1 == c.getX()&&y==c.getY()) {
				return true;
			}
		}
		return false;
	}
	public boolean isInvalid() {
		if ((x<0||x>9)||(y<0||y>19))
			return true;
		else 
			return false;
	}
	public boolean same(Coordinate c) {
		if (x == c.getX()&&y==c.getY()) 
			return true;
		else
			return false;
	}
}
