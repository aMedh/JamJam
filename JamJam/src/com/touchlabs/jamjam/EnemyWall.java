package com.touchlabs.jamjam;

import java.util.Random;

public class EnemyWall {

	private int xPos;
	private int yPos;
	private int speed;
	private float startTime;
	private boolean doWall = false;
	
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
	
	public boolean updateWall(float timeDelta, boolean spawnWall){
		boolean spawnedNewWall = false;
		
		startTime -= timeDelta;

		if (!doWall && spawnWall && startTime < 0 ) {
			doWall = true;
			spawnedNewWall = true;
		}

		if(startTime < 0 && doWall){	
			xPos -= timeDelta * speed;
			if(xPos < -100){
				startTime = (generator.nextInt(15) + 1);
				setNewRandomTime();				
			}
		}
		return spawnedNewWall;
	}
	
	public void setNewRandomTime(){
		xPos = 600;
		double tmp = 100;
		double newtmp = tmp / speed;
		int rand = Double.valueOf(15 * newtmp).intValue();
		startTime = (generator.nextInt(rand));
		doWall = false;
	}
	
}
