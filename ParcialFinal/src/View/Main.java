package View;
import Model.Polo;

import java.util.ArrayList;

import Model.Marco;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("View.Main");
	}
	
	Polo polo;
	Marco marco;
	private ArrayList<Polo> politos;

	public void settings() {
		size(400, 400);
	}

	public void setup() {
	
		politos = new ArrayList<Polo>();
		
	for (int i = 0; i < 20; i++) {
		int posY = (int) random(0, 400);
		int posX = (int) random(0, 400);
		politos.add(new Polo(null, posX, posY, 10, null));
			
	}
	
	}

	public void draw() {
	
	background(217, 184, 148);
	for (int i = 0; i < politos.size(); i++) {
		politos.get(i).draw(this);
		 new Thread(politos.get(i)).start();
		
		 
	}

	
	}


}
