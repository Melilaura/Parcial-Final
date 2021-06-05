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
	public boolean catchPolo;

	public void settings() {
		size(600, 600);
	}

	public void setup() {

		marco = new Marco((int) random(0, 600), (int) random(0, 600), 30, this);
		polo = new Polo(0, 0, 0, this);
		politos = new ArrayList<Polo>();
		catchPolo = false;

		for (int i = 0; i < 20; i++) {
			int posY = (int) random(0, 600);
			int posX = (int) random(0, 600);
			politos.add(new Polo(posX, posY, 20, this));

		}

	}

	public void draw() {

		background(255);

		marco.draw(this);
		new Thread(marco).start();

		for (int i = 0; i < politos.size(); i++) {
			politos.get(i).draw(this);
			politos.get(i).called();
			new Thread(politos.get(i)).start();

		}

		call();

	}

	public void call() {

		if (marco.getCall() == true) {
			polo.setCalled(true);
		}else {
			polo.setCalled(false);
			
		}
		for (int j = 0; j < politos.size(); j++) {

			if (polo.getCalled() == true) {
				
				//text ("Polo", politos.get(j).getPosX(), politos.get(j).getPosY()+40);
				huntPolitos();
				catchPolitos();

			}

		}
		
		

	}

	public void huntPolitos() {

		for (int i = 0; i < politos.size(); i++) {
			if (dist(marco.getPosX(), marco.getPosY(), politos.get(i).getPosX(), politos.get(i).getPosY()) < 60) {

				marco.setPosX(politos.get(i).getPosX());
				marco.setPosY(politos.get(i).getPosY());

			}

		}

	}

	public void catchPolitos() {

		for (int i = 0; i < politos.size(); i++) {
			if (dist(marco.getPosX(), marco.getPosY(), politos.get(i).getPosX(), politos.get(i).getPosY()) < 60) {

				catchPolo = true;
				politos.remove(i);

			}

		}

	}
	


}
