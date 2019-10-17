package screens;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ditetris.game.DiTetris;

import entities.Piece;

public class GameScreen implements Screen{    
	private static final int NO_COLOURS = 10;
	private static final int TILE_WIDTH = 320;
	private Game game;
	
	SpriteBatch batch;
	ArrayList<Texture> tiles;
	BitmapFont font;
	GlyphLayout layout;
	Texture leftContainer, rightContainer, nextLeft, nextRight, spawnBlock, name, gameTitle, level, score;
	Sound clear, touchdown;
	
	int grid [][];
	float timeFall, timeLastMoveLeft, timeLastMoveRight, timeLevel, timePassed, timeMultiplier;
	ArrayList<Piece> pieces, leftContainerPieces, rightContainerPieces;
	boolean leftCanMove, rightCanMove, leftObstruction, rightObstruction, bLTouchdown, bRTouchdown; //leftRowChecked, rightRowChecked;
	Piece leftPiece, rightPiece;
	
	int iLevel;
	public static int iScore;
	
	public GameScreen(Game g) {
		game = g;
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
		layout = new GlyphLayout();
		//sounds
		clear = Gdx.audio.newSound(Gdx.files.internal("clear.ogg"));
		touchdown = Gdx.audio.newSound(Gdx.files.internal("touchdown.ogg"));
		//timing variables
		timeFall = 0f;
		timeLastMoveLeft = 0f;
		timeLastMoveRight = 0f;
		timeLevel = 3f;
		timePassed = 0f;
		timeMultiplier = 1.25f;
		iLevel = 1;
		iScore = 0;
		//creating tile blocks
		tiles = new ArrayList<Texture>();
		for (int i=0;i<NO_COLOURS;i++) {
			tiles.add(new Texture("Block"+i+".jpg"));
		}
		//containers and headings
		leftContainer = new Texture("darken.jpg");
		rightContainer = new Texture("darken.jpg");
		nextLeft = new Texture("next_left.png");
		nextRight = new Texture("next_right.png");
		spawnBlock = new Texture("spawnblock.jpg");
		name = new Texture("name.jpg");
		gameTitle = new Texture("ditetris45.png");
		level = new Texture("level.png");
		score = new Texture("score.png");
		//creating grid
		grid = new int [10][20];
		for (int x=0;x<10;x++) 
			for (int y=0;y<20;y++)
				grid[x][y] = 0;		
		//creating pieces
		pieces = new ArrayList<Piece>(2);
		leftContainerPieces = new ArrayList<Piece>(2);
		rightContainerPieces = new ArrayList<Piece>(2);
		
		//adding pieces to tile and containers
		pieces.add(new Piece('L',1,19));
		pieces.add(new Piece('R',8,19));
		leftPiece = pieces.get(1);
		rightPiece = pieces.get(0);
		
		//process container pieces
		leftContainerPieces.add(new Piece('L',1,19));
		leftContainerPieces.add(new Piece('L',1,19));
		rightContainerPieces.add(new Piece('R',8,19));
		rightContainerPieces.add(new Piece('R',8,19));
		

		bLTouchdown = false;
		bRTouchdown = false;
		leftCanMove = true;
		rightCanMove = true;
		leftObstruction = false;
		rightObstruction = false;
		//leftRowChecked = false;
		//rightRowChecked = false;
	}

	@Override
	public void show() {
		
	}
	
	public void update(float dt) {
		handleInput();
		//falling code
		timePassed += dt;
		if (timePassed>7f) {
			iLevel++;
			timeLevel -= timeMultiplier;
			if (timeMultiplier>0.1125f) 
				timeMultiplier*=0.3f;
			else if (timeMultiplier<0.1125f&&timeMultiplier>0.01f) 
				timeMultiplier *= 0.8f;
			timePassed = 0f;
		}
		timeFall += dt;
		if (timeFall > timeLevel) {
			for (Piece piece : pieces) {
				if (piece.canMoveDown(grid)) {
					this.cleanPiece(piece);
					piece.moveDown();
				}
			}
			timeFall=0;
		}		
		//if one piece can't move, give it some time before it cannot move		
		if (!leftPiece.canMoveDown(grid)){
			leftObstruction = leftPiece.isObstructed(grid, rightPiece);
			if (!leftObstruction) {
				timeLastMoveLeft += dt;
				if (timeLastMoveLeft>timeLevel) {
					leftCanMove = false;
					timeLastMoveLeft = 0;
					if (!bLTouchdown) {
						touchdown.play();
						bLTouchdown = true;
					}
				}
			}
		}
		if (!rightPiece.canMoveDown(grid)) {
			rightObstruction = rightPiece.isObstructed(grid, leftPiece);
			if (!rightObstruction) {
				timeLastMoveRight += dt;
				if (timeLastMoveRight>timeLevel) {
					rightCanMove = false;
					timeLastMoveRight = 0;
					if (!bRTouchdown) {
						touchdown.play();
						bRTouchdown = true;
					}
				}
			}
			
		}
		//updating grid
		for (Piece p : pieces) {
			for (int i=0;i<p.getCoordinates().size();i++) {
				grid[p.getCoordinates().get(i).getX()][p.getCoordinates().get(i).getY()] = p.getColor();
			}
		}
		
		//if both pieces can't move spawn new pieces
		if (!leftCanMove&&!rightCanMove) {
			//clear rows
			checkRow();
			checkGameOver();
			timeFall = 0;
			//change pieces
			pieces.clear();
			leftContainerPieces.get(0).showcaseToTile();
			rightContainerPieces.get(0).showcaseToTile();
			pieces.add(leftContainerPieces.remove(0));
			pieces.add(rightContainerPieces.remove(0));
			leftContainerPieces.add(new Piece('L',1,19));
			rightContainerPieces.add(new Piece('R',8,19));
			leftPiece = pieces.get(1);
			rightPiece = pieces.get(0);
			leftCanMove = true;
			rightCanMove = true;	
			bRTouchdown = false;
			bLTouchdown = false;
		}
		
		
		
	}
	
	private void checkGameOver() {
		//check if game is done
		//row19
		int iRowCheck = 19;
		for (int w=1;w<9;w++) {
			if (grid[w][iRowCheck]!=0) {
				game.setScreen(new GameOverScreen(game));
			}
		}
		//row18
		iRowCheck--;
		for (int w=1;w<9;w++) {
			if (w==4||w==5)
				continue;
			if (grid[w][iRowCheck]!=0) {
				game.setScreen(new GameOverScreen(game));
			}
		}		
		//row 17
		iRowCheck--;
		for (int w=1;w<9;w++) {
			if (w==3||w==4||w==5||w==6)
				continue;
			if (grid[w][iRowCheck]!=0) {
				game.setScreen(new GameOverScreen(game));
			}
		}		
		//row 16
		iRowCheck--;
		for (int w=1;w<9;w++) {
			if (w==2||w==3||w==4||w==5||w==6||w==7)
				continue;
			if (grid[w][iRowCheck]!=0) {
				game.setScreen(new GameOverScreen(game));
			}
		}
		
	}

	private void handleInput() {
		//movement
		// left piece
		if (leftCanMove) {
			if (Gdx.input.isKeyJustPressed(Keys.UP)&&(leftPiece.canTransform(grid))) {
				this.cleanPiece(leftPiece);
				leftPiece.transform();
			}
			if (Gdx.input.isKeyJustPressed(Keys.DOWN)&&leftPiece.canMoveDown(grid)) {
				this.cleanPiece(leftPiece);
				leftPiece.moveDown();
			}
			if (Gdx.input.isKeyJustPressed(Keys.RIGHT)&&leftPiece.canMoveRight(grid)) {
				this.cleanPiece(leftPiece);
				leftPiece.moveRight();
			}
			if (Gdx.input.isKeyJustPressed(Keys.LEFT)&&leftPiece.canMoveLeft(grid)) {
				this.cleanPiece(leftPiece);
				leftPiece.moveLeft();
			}
		}
		// right piece
		if (rightCanMove) {
			if (Gdx.input.isKeyJustPressed(Keys.W)&&rightPiece.canTransform(grid)) {
				this.cleanPiece(rightPiece);
				rightPiece.transform();
			}
			if (Gdx.input.isKeyJustPressed(Keys.S)&&rightPiece.canMoveDown(grid)) {
				this.cleanPiece(rightPiece);
				rightPiece.moveDown();
			}
			if (Gdx.input.isKeyJustPressed(Keys.D)&&rightPiece.canMoveRight(grid)) {
				this.cleanPiece(rightPiece);
				rightPiece.moveRight();
			}
			if (Gdx.input.isKeyJustPressed(Keys.A)&&rightPiece.canMoveLeft(grid)) {
				this.cleanPiece(rightPiece);
				rightPiece.moveLeft();
			}
		}	
		
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			game.setScreen(new GameOverScreen(game));
		}
	}
	private void checkRow() {
		int iRow = 0;
		while (iRow<20) {
			boolean bRow = true;
			for (int o=0;o<10;o++) {
				if (grid[o][iRow]==0) {
					bRow = false;
				}
			}
			if (bRow) {
				this.shiftDown(iRow);
				iScore+=iLevel*10;
				clear.play();
			}
			else
				iRow++;
		}
	}
	private void shiftDown(int row) {
		int iWipe = row;
		while (iWipe<19) {
			for (int p=0;p<10;p++) {
				grid[p][iWipe] = grid[p][iWipe+1];
			}
			iWipe++;
		}
		
		for (int q=0;q<10;q++) {
			grid[q][19]=0;
		}
	}

	private void cleanPiece(Piece p) {
		for (int i=0;i<p.getCoordinates().size();i++) {
			grid[p.getCoordinates().get(i).getX()][p.getCoordinates().get(i).getY()] = 0;
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.109f, 0.768f, 0.737f, 0.84f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.update(delta);
		batch.begin();
		drawAssets(batch);
		for (int x=0;x<10;x++) 
			for (int y=0;y<20;y++) {
				batch.draw(tiles.get(grid[x][y]), x*32+DiTetris.WIDTH/2-TILE_WIDTH/2, y*32);
			}
		spawnBlocks(batch);
		batch.end();
	}

	private void spawnBlocks(SpriteBatch batch2) {
		//row19
		int iRowChange = 19;
		for (int w=1;w<9;w++) {
			if (grid[w][iRowChange]==0) {
				batch.draw(spawnBlock, w*32+DiTetris.WIDTH/2-TILE_WIDTH/2, iRowChange*32);
			}
		}
		//row18
		iRowChange--;
		for (int w=1;w<9;w++) {
			if (w==4||w==5)
				continue;
			if (grid[w][iRowChange]==0) {
				batch.draw(spawnBlock, w*32+DiTetris.WIDTH/2-TILE_WIDTH/2, iRowChange*32);
			} 
		}		
		//row 17
		iRowChange--;
		for (int w=1;w<9;w++) {
			if (w==3||w==4||w==5||w==6)
				continue;
			if (grid[w][iRowChange]==0) {
				batch.draw(spawnBlock, w*32+DiTetris.WIDTH/2-TILE_WIDTH/2, iRowChange*32);
			} 
		}		
		//row 16
		iRowChange--;
		for (int w=1;w<9;w++) {
			if (w==2||w==3||w==4||w==5||w==6||w==7)
				continue;
			if (grid[w][iRowChange]==0) {
				batch.draw(spawnBlock, w*32+DiTetris.WIDTH/2-TILE_WIDTH/2, iRowChange*32);
			}
		}
		
	}

	private void drawAssets(SpriteBatch sb) {
		//containers
		float leftStart = DiTetris.WIDTH/2-160-60;
		float leftHeight = DiTetris.HEIGHT-30;
		float rightStart =  DiTetris.WIDTH/2+160+60;
		float rightHeight = DiTetris.HEIGHT-30;
		
		sb.draw(leftContainer, leftStart-leftContainer.getWidth(), leftHeight-leftContainer.getHeight());
		sb.draw(rightContainer, rightStart, rightHeight-rightContainer.getHeight());
		sb.draw(nextLeft,leftStart-leftContainer.getWidth()/2-nextLeft.getWidth()/2,leftHeight-20-nextLeft.getHeight());
		sb.draw(nextRight,rightStart+rightContainer.getWidth()/2-nextRight.getWidth()/2,rightHeight-20-nextRight.getHeight());
		
		//pieces
		float posWLeftPiece = leftStart-leftContainer.getWidth()/2; //center of container
		float posHLeftPiece = leftHeight-20-nextLeft.getHeight();
		float iLBar = 16;
		
		for (Piece leftPiece:leftContainerPieces) {
			iLBar += heightOfGrid(leftPiece.gridToShowcase())*32;
			for (int r=0;r<4;r++) {
				for (int s=0;s<4;s++) {
					if (leftPiece.gridToShowcase()[r][s]!=0) {
						batch.draw(tiles.get(leftPiece.getColor()), r*32+posWLeftPiece-widthOfGrid(leftPiece.gridToShowcase())*32/2, 
								s*32+posHLeftPiece-iLBar);
					}
				}
			}
			iLBar += 32;
		}
		float posWRightPiece = rightStart-20; //center of container
		float posHRightPiece = rightHeight-20-nextRight.getHeight();
		float iRBar = 16;
		for (Piece rightPiece:rightContainerPieces) {
			iRBar += heightOfGrid(rightPiece.gridToShowcase())*32;
			for (int u=0;u<4;u++) {
				for (int v=0;v<4;v++) {
					if (rightPiece.gridToShowcase()[u][v]!=0) {
						batch.draw(tiles.get(rightPiece.getColor()), u*32+posWRightPiece+widthOfGrid(rightPiece.gridToShowcase())*32/2, 
								v*32+posHRightPiece-iRBar);
					}
				}
			}
			iRBar += 32;
		}
		//text elements
		
		sb.draw(gameTitle, rightStart+rightContainer.getWidth()/2-gameTitle.getWidth()/2, 150);
		sb.draw(name, rightStart+rightContainer.getWidth()/2-name.getWidth()/2, 50);
		layout.setText(font, MenuScreen.PLAYER_NAME);
		float txtWidth = layout.width;
		font.draw(sb, MenuScreen.PLAYER_NAME, rightStart+rightContainer.getWidth()/2-txtWidth/2, 110);
		String sLevel = Integer.toString(iLevel);
		String sScore = Integer.toString(iScore);
		sb.draw(level,leftStart-leftContainer.getWidth()/2-level.getWidth()/2, 170);
		sb.draw(score,leftStart-leftContainer.getWidth()/2-score.getWidth()/2, 60);
		layout.setText(font, sLevel);
		txtWidth = layout.width;
		font.draw(sb, sLevel, leftStart-leftContainer.getWidth()/2-txtWidth/2, 160);
		layout.setText(font, sScore);
		txtWidth = layout.width;
		font.draw(sb, sScore, leftStart-leftContainer.getWidth()/2-txtWidth/2, 60);
		
	}
	//helper method
	private int widthOfGrid(int g[][]) {
		int iCounter=0;
		for (int r=0;r<4;r++) {
			for (int s=0;s<4;s++) {
				if (g[r][s]!=0) {
					iCounter++;
					break;
				}
			}
		}
		return iCounter;
	}
	
	private int heightOfGrid(int g[][]) {
		int iCounter=0;
		for (int r=0;r<4;r++) {
			for (int s=0;s<4;s++) {
				if (g[s][r]!=0) {
					iCounter++;
					break;
				}
			}
		}
		return iCounter;
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		clear.dispose();
		touchdown.dispose();
	}


}
