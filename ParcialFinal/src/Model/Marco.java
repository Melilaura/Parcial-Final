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
		this.DirX = -2;
		this.DirY = -2;
		this.app = app;
	}

	public void draw(PApplet app) {
		app.ellipse(posX, posY, Size, Size);
		app.fill(0);
		app.text("MARCO", posX, posY);
		polo = new Polo(0, 0, 0, app);
	}

	public void run() {

		move();
		collision();

		try {

			Thread.sleep(2000);
			for (int contar = 0; contar < 5; contar++) {
				System.out.println("MARCO");
				call = true;
				call();
			}

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
			DirX = 2;
		}

		if (posY - (Size + 10) / 2 < 0) {
			DirY = 2;
		}

		if (posX + (Size + 10) / 2 > 600) {
			DirX = -2;
		}

		if (posY + (Size + 10) / 2 > 600) {
			DirY = -2;
		}
	}

	public void call() {
		if (call == true) {
			app.text("MARCO", posX, posY - (Size + 5));
		}
	}

	public boolean getCall() {
		return call;
	}

	public void setCall(boolean call) {
		this.call = call;
	}

}