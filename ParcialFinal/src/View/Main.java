package View;

import Model.Polo;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("View.Main");
	}

	Polo polo;

	public void settings() {

		size(400, 400);

	}

	public void setup() {

		polo = new Polo(200, 200);
	}

	public void draw() {
		background(217, 184, 148);

		polo.draw(this);

	}

}
