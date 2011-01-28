package com.touchlabs.jamjam;

public class GroundBot {
	private int xPos;
	private int yPos;
	private int speed;
	
	public GroundBot(){
		xPos = 0;
		yPos = 300;
		speed = 100;
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
