package com.ditetris.game;

import screens.MenuScreen;

import com.badlogic.gdx.Game;

public class DiTetris extends Game{
	public static final int WIDTH = 1000;
    public static final int HEIGHT = 650;
    public static final String TITLE = "DiTetris";
	
	@Override
	public void create () {
		// start with MenuScreen
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		// use render method in Game class
		super.render();
	}
}
