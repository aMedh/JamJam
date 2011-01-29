package com.touchlabs.jamjam;

import java.util.Random;

public class PowerUp {

	private int xPos;
	private int yPos;
	private int speed;
	private float startTime;
	Random generator = new Random();
	int type;
	
	public PowerUp(){
		speed = 100;
		newPos();
	}

	public void setSpeed(double newspeed){
		speed = Double.valueOf(newspeed).intValue();// newspeed;
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

		int type2 = generator.nextInt(4);
		if (type2 == 3)
			type = 1;
		else if (type2 == 2)
			type = 2;
		else type = 0;
			
		int floor = generator.nextInt(3);
		if(floor == 0)
			yPos = 120;
		else if (floor == 1)
			yPos = 220;
		else 
			yPos = 320;
		startTime = 10 + (generator.nextInt(15) + 1);
	}
	
	public int getType() {
		return type;		
	}

}
