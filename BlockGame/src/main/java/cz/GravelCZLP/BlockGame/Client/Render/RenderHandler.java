package cz.GravelCZLP.BlockGame.Client.Render;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class RenderHandler {

	public void startGameRender() {
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("Block Game: Multiplayer");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		while(!Display.isCloseRequested()) {
			Display.update();
			Display.sync(30);
		}
	}
	
	public void doSomeStuff() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glBegin(GL_TRIANGLES);
	}
}
