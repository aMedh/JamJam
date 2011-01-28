package com.touchlabs.jamjam;

public class GroundMid {
	private int xPos;
	private int yPos;
	private int speed;
	
	public GroundMid(){
		xPos = 0;
		yPos = 200;
		speed = 100;
	}
	
	public void setSpeed(double newspeed){
		speed = Double.valueOf(newspeed).intValue();// newspeed;
	}
	
	public int getX1(){
		return xPos;
	}
	
	public int getX2(){
		return xPos + 600;
	}
	
	public int getY(){
		return yPos;
	}
	
	public void setXPos(float timeDelta){
		xPos -= timeDelta * speed;
		if(xPos < -600)
			xPos = 0;
	}
}
