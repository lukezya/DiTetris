package com.ditetris.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ditetris.game.DiTetris;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = DiTetris.HEIGHT;
		config.width = DiTetris.WIDTH;
		config.title = DiTetris.TITLE;
		config.y += 30;
		config.resizable = false;
		new LwjglApplication(new DiTetris(), config);
	}
}
