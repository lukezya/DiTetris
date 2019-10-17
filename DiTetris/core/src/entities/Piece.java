package entities;

import java.util.ArrayList;
import java.util.Random;

public class Piece {
	private int iSet;
	private char cStartLocation;
	private int iVariation;
	private int x;
	private int y;
	
	private int iColour;
	private ArrayList<Coordinate> coordinates;
	Random random;
	
	public Piece(char cLoc, int markX, int markY) {
		random = new Random();
		iColour = random.nextInt(9)+1; //1..9
		iSet = random.nextInt(7)+1; //1..7
		cStartLocation = cLoc; //L or R
		x = markX;
		y = markY;
		coordinates = new ArrayList<Coordinate>(4);
		this.setCoordinates();	
	}
	public Piece(char cLoc, int markX, int markY, int color, int set, ArrayList<Coordinate> coord, int variation) {
		iColour = color;
		iSet = set;
		cStartLocation = cLoc; //L or R
		x = markX;
		y = markY;
		coordinates = new ArrayList<Coordinate>(4);
	    for (int i=0;i<coord.size();i++) { 
	    	coordinates.add(coord.get(i));
	    }
	    iVariation = variation;
	}
	
	private void setCoordinates() {
		switch (cStartLocation) {
			case 'L': {
				switch (iSet) {
					case 1:
						iVariation = random.nextInt(4)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x+2,y));
								coordinates.add(new Coordinate(x,y-1));
								break;
							case 2:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x+1,y-1));
								coordinates.add(new Coordinate(x+1,y-2));
								break;
							case 3:
								coordinates.add(new Coordinate(x+2,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x+1,y-1));
								coordinates.add(new Coordinate(x+2,y-1));
								break;
							case 4:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x,y-2));
								coordinates.add(new Coordinate(x+1,y-2));
								break;
						
						}
						break;
					case 2:
						iVariation = random.nextInt(4)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x+2,y));
								coordinates.add(new Coordinate(x+2,y-1));
								break;
							case 2:
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x+1,y-1));
								coordinates.add(new Coordinate(x,y-2));
								coordinates.add(new Coordinate(x+1,y-2));
								break;
							case 3:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x+1,y-1));
								coordinates.add(new Coordinate(x+2,y-1));
								break;
							case 4:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x,y-2));
								break;
						
						}
						break;
					case 3:
						iVariation = 0;
						coordinates.add(new Coordinate(x,y));
						coordinates.add(new Coordinate(x+1,y));
						coordinates.add(new Coordinate(x,y-1));
						coordinates.add(new Coordinate(x+1,y-1));
						break;
					case 4:
						iVariation = random.nextInt(2)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x,y-2));
								coordinates.add(new Coordinate(x,y-3));
								break;
							case 2:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x+2,y));
								coordinates.add(new Coordinate(x+3,y));
								break;						
						}
						break;
					case 5:
						iVariation = random.nextInt(2)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x+1,y-1));
								coordinates.add(new Coordinate(x+1,y-2));
								break;
							case 2:
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x+2,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x+1,y-1));
								break;						
						}
						break;
					case 6:
						iVariation = random.nextInt(2)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x+1,y-1));
								coordinates.add(new Coordinate(x,y-2));
								break;
							case 2:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x+1,y-1));
								coordinates.add(new Coordinate(x+2,y-1));
								break;						
						}
						break;
					case 7:
						iVariation = random.nextInt(4)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x+1,y-1));
								coordinates.add(new Coordinate(x+2,y-1));
								break;
							case 2:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x+1,y-1));
								coordinates.add(new Coordinate(x,y-2));
								break;
							case 3:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x+2,y));
								coordinates.add(new Coordinate(x+1,y-1));
								break;
							case 4:
								coordinates.add(new Coordinate(x+1,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x+1,y-1));
								coordinates.add(new Coordinate(x+1,y-2));
								break;
						
						}
						break;
				}
				break;
			}
			case 'R': {
				switch (iSet) {
					case 1:
						iVariation = random.nextInt(4)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x-2,y));
								coordinates.add(new Coordinate(x-2,y-1));
								break;
							case 2:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x,y-2));
								break;
							case 3:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x-1,y-1));
								coordinates.add(new Coordinate(x-2,y-1));
								break;
							case 4:
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x-1,y-1));
								coordinates.add(new Coordinate(x,y-2));
								coordinates.add(new Coordinate(x-1,y-2));
								break;
						
						}
						break;
					case 2:
						iVariation = random.nextInt(4)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x-2,y));
								coordinates.add(new Coordinate(x,y-1));
								break;
							case 2:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x,y-2));
								coordinates.add(new Coordinate(x-1,y-2));
								break;
							case 3:
								coordinates.add(new Coordinate(x-2,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x-1,y-1));
								coordinates.add(new Coordinate(x-2,y-1));
								break;
							case 4:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x-1,y-1));
								coordinates.add(new Coordinate(x-1,y-2));
								break;
						
						}
						break;
					case 3:
						iVariation = 0;
						coordinates.add(new Coordinate(x,y));
						coordinates.add(new Coordinate(x-1,y));
						coordinates.add(new Coordinate(x,y-1));
						coordinates.add(new Coordinate(x-1,y-1));
						break;
					case 4:
						iVariation = random.nextInt(2)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x,y-2));
								coordinates.add(new Coordinate(x,y-3));
								break;
							case 2:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x-2,y));
								coordinates.add(new Coordinate(x-3,y));
								break;						
						}
						break;
					case 5:
						iVariation = random.nextInt(2)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x-1,y-1));
								coordinates.add(new Coordinate(x,y-2));
								break;
							case 2:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x-1,y-1));
								coordinates.add(new Coordinate(x-2,y-1));
								break;						
						}
						break;
					case 6:
						iVariation = random.nextInt(2)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x-1,y-1));
								coordinates.add(new Coordinate(x-1,y-2));
								break;
							case 2:
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x-2,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x-1,y-1));
								break;						
						}
						break;
					case 7:
						iVariation = random.nextInt(4)+1;
						switch (iVariation) {
							case 1:
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x-1,y-1));
								coordinates.add(new Coordinate(x-2,y-1));
								break;
							case 2:
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x-1,y-1));
								coordinates.add(new Coordinate(x-1,y-2));
								break;
							case 3:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x-1,y));
								coordinates.add(new Coordinate(x-2,y));
								coordinates.add(new Coordinate(x-1,y-1));
								break;
							case 4:
								coordinates.add(new Coordinate(x,y));
								coordinates.add(new Coordinate(x,y-1));
								coordinates.add(new Coordinate(x-1,y-1));
								coordinates.add(new Coordinate(x,y-2));
								break;
						
						}
						break;
				}
				break;
			}
		}
	}
	public int getColor() {
		return iColour;
	}
	public ArrayList<Coordinate> getCoordinates() {
		return coordinates;
	}
	public String toString() {
		String sPiece = "Colour:"+iColour+"\n"+
				"Set:"+iSet +"L or R:"+cStartLocation+
				"Variation: "+iVariation;
		return sPiece;				
	}
	public void transform() {
		switch (cStartLocation) {
			case 'L': {
				switch (iSet) {
					case 1:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-1,coordinates.get(2).getY()-1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+1,coordinates.get(3).getY()-1));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()+2,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-1,coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX(),coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+1,coordinates.get(3).getY()+1));
								break;
							case 3:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-2,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-1,coordinates.get(2).getY()-1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-1,coordinates.get(3).getY()-1));
								break;
							case 4:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+1,coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+2,coordinates.get(2).getY()+2));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-1,coordinates.get(3).getY()+1));
								break;
						
						}
						if (iVariation+1==5)
							iVariation = 1;
						else
							iVariation++;
						break;
					case 2:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()+1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-2,coordinates.get(2).getY()-2));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-1,coordinates.get(3).getY()-1));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-1,coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+1,coordinates.get(2).getY()+1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+1,coordinates.get(3).getY()+1));
								break;
							case 3:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+1,coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-1,coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-2,coordinates.get(3).getY()-1));
								break;
							case 4:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+2,coordinates.get(2).getY()+1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+2,coordinates.get(3).getY()+1));
								break;
						
						}
						if (iVariation+1==5)
							iVariation = 1;
						else
							iVariation++;
						break;
					case 3:
						break;
					case 4:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+1,coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+2,coordinates.get(2).getY()+2));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+3,coordinates.get(3).getY()+3));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-1,coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-2,coordinates.get(2).getY()-2));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-3,coordinates.get(3).getY()-3));
								break;						
						}
						if (iVariation+1==3)
							iVariation = 1;
						else
							iVariation++;
						break;
					case 5:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()+1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+2,coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-1,coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX(),coordinates.get(3).getY()+1));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-2,coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+1,coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX(),coordinates.get(3).getY()-1));
								break;						
						}
						if (iVariation+1==3)
							iVariation = 1;
						else
							iVariation++;
						break;
					case 6:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+1,coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX(),coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+2,coordinates.get(3).getY()+1));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()+1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-1,coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX(),coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-2,coordinates.get(3).getY()-1));
								break;						
						}
						if (iVariation+1==3)
							iVariation = 1;
						else
							iVariation++;
						break;
					case 7:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX(),coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-2,coordinates.get(3).getY()-1));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+1,coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+1,coordinates.get(2).getY()+1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+1,coordinates.get(3).getY()+1));
								break;
							case 3:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()+2,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX(),coordinates.get(2).getY()-1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+1,coordinates.get(3).getY()-1));
								break;
							case 4:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-1,coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-1,coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX(),coordinates.get(3).getY()+1));
								break;
						
						}
						if (iVariation+1==5)
							iVariation = 1;
						else
							iVariation++;
						break;
				}
				break;
			}
			case 'R': {
				switch (iSet) {
					case 1:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+2,coordinates.get(2).getY()-1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+2,coordinates.get(3).getY()-1));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+1,coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-1,coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-2,coordinates.get(3).getY()+1));
								break;
							case 3:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-1,coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+1,coordinates.get(2).getY()-1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+1,coordinates.get(3).getY()-1));
								break;
							case 4:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()+1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-2,coordinates.get(2).getY()+2));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-1,coordinates.get(3).getY()+1));
								break;
						
						}
						if (iVariation+1==5)
							iVariation = 1;
						else
							iVariation++;
						break;
					case 2:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+1,coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+2,coordinates.get(2).getY()-2));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-1,coordinates.get(3).getY()-1));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-2,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-1,coordinates.get(2).getY()+1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-1,coordinates.get(3).getY()+1));
								break;
							case 3:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()+2,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-1,coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX(),coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+1,coordinates.get(3).getY()-1));
								break;
							case 4:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-1,coordinates.get(2).getY()+1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+1,coordinates.get(3).getY()+1));
								break;
						
						}
						if (iVariation+1==5)
							iVariation = 1;
						else
							iVariation++;
						break;
					case 3:
						break;
					case 4:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-1,coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-2,coordinates.get(2).getY()+2));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-3,coordinates.get(3).getY()+3));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+1,coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+2,coordinates.get(2).getY()-2));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+3,coordinates.get(3).getY()-3));
								break;						
						}
						if (iVariation+1==3)
							iVariation = 1;
						else
							iVariation++;
						break;
					case 5:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()+1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-1,coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX(),coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-2,coordinates.get(3).getY()+1));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+1,coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX(),coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+2,coordinates.get(3).getY()-1));
								break;						
						}
						if (iVariation+1==3)
							iVariation = 1;
						else
							iVariation++;
						break;
					case 6:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-2,coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+1,coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX(),coordinates.get(3).getY()+1));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()+1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+2,coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-1,coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX(),coordinates.get(3).getY()-1));
								break;						
						}
						if (iVariation+1==3)
							iVariation = 1;
						else
							iVariation++;
						break;
					case 7:
						switch (iVariation) {
							case 1:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()-1,coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()-1,coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX(),coordinates.get(3).getY()-1));
								break;
							case 2:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()+2,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()+1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX(),coordinates.get(2).getY()+1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+1,coordinates.get(3).getY()+1));
								break;
							case 3:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX(),coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX()+1,coordinates.get(1).getY()-1));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX()+1,coordinates.get(2).getY()-1));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()+1,coordinates.get(3).getY()-1));
								break;
							case 4:
								coordinates.set(0, new Coordinate(coordinates.get(0).getX()-1,coordinates.get(0).getY()));
								coordinates.set(1, new Coordinate(coordinates.get(1).getX(),coordinates.get(1).getY()));
								coordinates.set(2, new Coordinate(coordinates.get(2).getX(),coordinates.get(2).getY()));
								coordinates.set(3, new Coordinate(coordinates.get(3).getX()-2,coordinates.get(3).getY()+1));
								break;
						
						}
						if (iVariation+1==5)
							iVariation = 1;
						else
							iVariation++;
						break;
				}
				break;
			}
		}
	}
	public void moveDown() {
		for (Coordinate coordinate:coordinates) {
			coordinate.moveDown();
		}
	}
	public void moveRight() {
		for (Coordinate coordinate:coordinates) {
			coordinate.moveRight();
		}
	}
	public void moveLeft() {
		for (Coordinate coordinate:coordinates) {
			coordinate.moveLeft();
		}
	}
	public Piece clone() {
		Piece temp = new Piece(cStartLocation, x ,y, iColour, iSet,coordinates,iVariation);
		return temp;
	}
	public boolean canTransform(int grid[][]) {
		Piece clone = this.clone();
		clone.transform();
		for (Coordinate coordinate:clone.getCoordinates()) {
			boolean bSame = false;
			for (Coordinate c:coordinates) {
				if (coordinate.same(c)) {
					bSame = true;
					break;
				}
			}
			if (bSame)
				continue;
			if(coordinate.isInvalid()||grid[coordinate.getX()][coordinate.getY()]!=0) {
				return false;
			}
		}
		return true;
		
	}
	public boolean isObstructed(int grid[][], Piece otherPiece) {
		if (!this.canMoveDown(grid)) {
			//check if its obstructed by other piece
			boolean bOtherPiece = false;
			for (Coordinate coordinate:coordinates) {
				//if its obstructed by other piece
				if (coordinate.isInAfterDecY(otherPiece.getCoordinates())) {
					bOtherPiece = true;
					break;
				}
			}
			if (bOtherPiece)
				return otherPiece.canMoveDown(grid);
		}
		return false;
	}
	public boolean canMoveDown(int grid [][]) {
		for (Coordinate coordinate:coordinates) {
			if (coordinate.getY()-1<0) {
				return false;
			}
			//if its surrounded by elements that's not itself
			if (grid[coordinate.getX()][coordinate.getY()-1] != 0) {
				if (!coordinate.isInAfterDecY(coordinates)) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean canMoveLeft(int grid [][]) {
		for (Coordinate coordinate:coordinates) {
			if (coordinate.getX()-1<0) {
				return false;
			}
			if (grid[coordinate.getX()-1][coordinate.getY()] != 0) {
				if (!coordinate.isInAfterDecX(coordinates)) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean canMoveRight(int grid [][]) {
		for (Coordinate coordinate:coordinates) {
			if (coordinate.getX()+1>9) {
				return false;
			}
			if (grid[coordinate.getX()+1][coordinate.getY()] != 0) {
				if (!coordinate.isInAfterIncX(coordinates)) {
					return false;
				}
			}
		}
		return true;
	}
	public void showcaseToTile() {
		boolean bStop = false;
		while (!bStop) {
			for (Coordinate coordinate: coordinates) {
				if(coordinate.getY()+1>19) {
					bStop = true;
					break;
				}
			}
			if (!bStop) {
				for (Coordinate c : coordinates) {
					c.moveUp();					
				}
			}
		}
	}
	public int[][] gridToShowcase(){
		boolean bStop = false;
		while (!bStop) {
			for (Coordinate coordinate: coordinates) {
				if(coordinate.getY()-1<0) {
					bStop = true;
					break;
				}
			}
			if (!bStop) {
				for (Coordinate c : coordinates) {
					c.moveDown();					
				}
			}
		}
//		for (Coordinate d:coordinates)
//			System.out.println(d.toString());
		int showcase[][] = new int[4][4];
		for (int x=0;x<4;x++) 
			for (int y=0;y<4;y++)
				showcase[x][y] = 0;	
		for (int i=0;i<4;i++) {
			switch (cStartLocation) {
				case 'L': showcase[coordinates.get(i).getX()-1][coordinates.get(i).getY()]=iColour;
						  break;
				case 'R': showcase[coordinates.get(i).getX()-5][coordinates.get(i).getY()]=iColour;
						  break;
			}
		}
		return showcase;
		
	}

}
