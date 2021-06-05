package Model;

import processing.core.PApplet;

public class Marco implements Runnable {

	public int posX;
	public int posY;
	public int Size;
	public int DirX;
	public int DirY;

	boolean call;
	private PApplet app;

	Polo polo;

	public Marco(int posX, int posY, int Size, PApplet app) {

		this.posX = posX;
		this.posY = posY;
		this.Size = Size;
		this.DirX = 2;
		this.DirY = 2;
		
		
		this.app = app;
	}

	public void draw(PApplet app) {
		app.fill(155,184,255);
		app.noStroke();
		app.ellipse(posX, posY, Size, Size);
		app.fill(211,223,249);
		app.text("MARCO", posX, posY+Size);
		polo = new Polo(0, 0, 0, app);
	}

	public void run() {

		move();
		collision();
		
		call = true;
		call();
		

		try {

			
			Thread.sleep(2000);
			
			
			

		} catch (InterruptedException e) {

			e.printStackTrace();
			

		}

	}

	public void move() {
		posY += DirY;
		posX += DirX;
		
		 
		 
	}

	public void collision() {

		if (posX - (Size + 10) / 2 < 0) {
			DirX = 1;
		}

		if (posY - (Size + 10) / 2 < 0) {
			DirY = 1;
		}

		if (posX + (Size + 10) / 2 > 600) {
			DirX = -1;
		}

		if (posY + (Size + 10) / 2 > 600) {
			DirY = -1;
		}
	}

	public void call() {
		if (call == true) {
			app.text("MARCO", posX-Size, posY-Size);
		}
	}


	public boolean getCall() {
		return call;
	}

	public void setCall(boolean call) {
		this.call = call;
	}

	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	public int getDirX() {
		return DirX;
	}
	public void setDirX(int dirX) {
		DirX = dirX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void setDirY(int dirY) {
		DirY = dirY;
	}
	
	
	
	
}