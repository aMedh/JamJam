package com.touchlabs.jamjam;

public class EnemyWall {

	private int xPos;
	private int yPos;
	private int speed;
	
	public EnemyWall(){
		xPos = 600;
		yPos = 200;
		speed = 100;
	}
	
	public int getX1(){
		return xPos;
	}
	
	public int getY(){
		return yPos - 80;
	}
	
	public void setXPos(float timeDelta){
		xPos -= timeDelta * speed;
		if(xPos < -100)
			xPos = 600;
	}
	
}
