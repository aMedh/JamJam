package com.touchlabs.jamjam;

import java.util.Random;

public class EnemyWall {

	private int xPos;
	private int yPos;
	private int speed;
	private float startTime;
	
	Random generator = new Random();
	
	public EnemyWall(int randomTime, int floor){
		xPos = 600;
		if(floor == 1)
			yPos = 100;
		else if(floor == 2)
			yPos = 200;
		else if (floor == 3)
			yPos = 300;
		
		speed = 100;
		startTime = randomTime;
	}
	
	public void setSpeed(double newspeed){
		speed = Double.valueOf(newspeed).intValue();// newspeed;
	}
	
	public int getX1(){
		return xPos;
	}
	
	public void setX(int pos){
		xPos = pos;
	}
	
	public int getY(){
		return yPos - 80;
	}
	
	public void setXPos(float timeDelta){
		startTime -= timeDelta;
		if(startTime < 0){	
			xPos -= timeDelta * speed;
			if(xPos < -100){
				xPos = 600;
				startTime = (generator.nextInt(15) + 1);
			}
		}
	}
	
	public void setNewRandomTime(){
		startTime = (generator.nextInt(15) + 1);
	}
	
}
