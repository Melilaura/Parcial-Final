package Model;

import processing.core.PApplet;

public class Polo implements Runnable {

	public int posX;
	public int posY;
	public int Size;
	public int DirX;
	public int DirY;
	String nombreHilo;
	private PApplet app;

	public Polo(String nombre, int posX, int posY, int Size, PApplet app) {
		nombreHilo = nombre;

		this.posX = posX;
		this.posY = posY;
		this.Size = Size;
		this.DirX = 1;
		this.DirY = 1;
		//this.app = app;

	}

	public void draw(PApplet app) {
		app.ellipse(posX, posY, Size, Size);
		//app.fill(0);
		move();
	}

	public void run() {
		System.out.println("Se crean los polos");
		move();
		collision();
		
		try {
			for (int contar = 0; contar < 5; contar++) {
				Thread.sleep(1);
				System.out.println("se mueven");
				
			}
		} catch (InterruptedException exc) {
			System.out.println( "Hilo Interrumpido.");
		}
		System.out.println("Terminando el hilo");
	}
	
public void move() {
	
	posX += DirX;
	posY += DirY;
	}

public void collision() {
	//colisiones con bordes
	if(posX-Size/2<0) {
		DirX = 1;
	}
	
	if(posY-Size/2<0) {
		DirY = 1;
	}
	
	if(posX+Size/2>400) {
		DirX = -1 ;
	}
	
	if(posY+Size/2>400) {
		DirY = -1;
	}
}

}
