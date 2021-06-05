package Model;

import processing.core.PApplet;

public class Polo implements Runnable {

	public int posX;
	public int posY;
	public int Size;
	public int DirX;
	public int DirY;
	boolean called;
	Marco marco;
	public PApplet app;

	public Polo(int posX, int posY, int Size, PApplet app) {

		this.posX = posX;
		this.posY = posY;
		this.Size = Size;
		this.DirX = (int) app.random(1, -1);
		this.DirY = (int) app.random(1, -1);
		this.app = app;
	
		called = false;

	}

	public void draw(PApplet app) {
		app.fill(247,233,233);
		app.noStroke();
		app.ellipse(posX, posY, Size, Size);
		app.fill(0);
		app.fill(247,190,191);
		app.text( posX + "," + posY, posX-Size, posY-Size);
		// called();
	}

	public void run() {

		
		move();
		collision();
		called();

		try {

			Thread.sleep(2000);
			//called();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void move() {

		posX += DirX;
		posY += DirY;
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

	public void called() {
		if (called == true ) {
			app.text("Polo", 300, 300);
		}
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

	public int getDirY() {
		return DirY;
	}

	public void setCalled(boolean called) {
		this.called = called;
	}

	public boolean getCalled() {
		return called;
	}

}
