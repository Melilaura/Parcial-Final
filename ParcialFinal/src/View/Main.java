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
		size(600, 600);
	}

	public void setup() {

		marco = new Marco(200, 200, 50, this);
		polo=new Polo(0, 0, 0, this);
		politos = new ArrayList<Polo>();

		for (int i = 0; i < 20; i++) {
			int posY = (int) random(0, 300);
			int posX = (int) random(0, 300);
			politos.add(new Polo(posX, posY, 20, this));

		}

	}

	public void draw() {

		background(217, 184, 148);

		marco.draw(this);
		new Thread(marco).start();

		for (int i = 0; i < politos.size(); i++) {
			politos.get(i).draw(this);
			new Thread(politos.get(i)).start();

		}
		
		call();

	}
	
	
	public void call() {
		
		if(marco.getCall()==true) {
			polo.setCalled(true);
				
		
			if(polo.getCalled()==true) {
				text("POLO",300,150);
				marco.setCall(false);
		 
		} 

		}

	}

	public ArrayList<Polo> getPolitos() {
		return politos;
	}

}
