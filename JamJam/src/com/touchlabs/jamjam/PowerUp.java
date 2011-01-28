package com.touchlabs.jamjam;

public class PowerUp {

	private int xPos;
	private int yPos;
	private int speed;
	
	public PowerUp(){
		xPos = 600;
		yPos = 200;
		speed = 100;
	}
	
	public int getX(){
		return xPos;
	}
	
	public int getY(){
		return yPos - 80;
	}
	
	public void updatePowerUp(float timeDelta){
		xPos -= timeDelta * speed;
		if(xPos < -100)
			xPos = 600;
	}

}
