package Model;

import View.Main;
import processing.core.PApplet;

public class Polo extends Thread {
	
	public int posX;
	public int posY;
	public int size;
	public int dir;
	
	public Polo (int PosX, int PosY) {
		
		this.posX = posX;
		this.posY = posY;
		size=10;
		dir = 1;
	
	}
	
	public void draw(PApplet app) {

		app.ellipse( posY, posX, dir,dir);
	}
	
	public void colision (PApplet app) {

		
	}

	
	
	

}
