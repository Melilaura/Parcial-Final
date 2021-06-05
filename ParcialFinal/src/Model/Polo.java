package Model;

import processing.core.PApplet;

public class Polo implements Runnable {

	public int posX;
	public int posY;
	public int Size;
	public int DirX;
	public int DirY;
	boolean called;
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
		app.fill(255);
		app.ellipse(posX, posY, Size, Size);
		app.fill(0);
		app.text("Polo," + posX + "," + posY, posX, posY);
	}

	public void run() {

		move();
		collision();

		try {

			Thread.sleep(2000);

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
