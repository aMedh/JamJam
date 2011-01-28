package com.touchlabs.jamjam;

import java.util.Random;

public class PowerUp {

	private int xPos;
	private int yPos;
	private int speed;
	private float startTime;
	Random generator = new Random();
	
	public PowerUp(){
		yPos = 200;
		speed = 100;
		newPos();
	}
	
	public int getX(){
		return xPos;
	}
	
	public int getY(){
		return yPos - 80;
	}
	
	public void updatePowerUp(float timeDelta){
		startTime -= timeDelta;
		if(startTime < 0) {	
			xPos -= timeDelta * speed;
			if(xPos < -100) {
				newPos();
			}
		}
	}
	
	private void newPos() {
		xPos = 600;

		int floor = generator.nextInt(3);
		if(floor == 0)
			yPos = 100;
		else if (floor == 1)
			yPos = 200;
		else 
			yPos = 300;
		startTime = 10 + (generator.nextInt(15) + 1);
	}

}
