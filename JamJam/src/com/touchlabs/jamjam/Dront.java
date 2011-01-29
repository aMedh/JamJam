package com.touchlabs.jamjam;

public class Dront {
	private int xPos = 150;
	private int yPos = 220;
	private int gridX = 3;
	private int gridY = 0;
	private int speedX = 600;
	private int speedY = 300;
	private boolean freeze = false;
	private double freezeTime = 2;
	private float mAnimation;
	private float mAnimationWalk = 1.8f;
	private int tempImage = R.drawable.d1;
	
	//Constructor
	public Dront() {}
	
	//Return actual pos X
	public int getX() {
		return xPos;		
	}

	//Return actual pos Y
	public int getY() {
		return yPos;		
	}

	//Set the actual pos X
	public void setX(int x) {
		xPos = x;		
	}

	//Set the actual pos Y
	public void setY(int y) {
		yPos = y;		
	}

	
	//If the dront gets hit by obstacle
	public void hitDront() 
	{
		if (gridX > 0) 
			gridX--;
	}
	
	//If the dront gets hit by obstacle
	public void drontPowerUp() 
	{
		if (gridX < 4) 
			gridX++;
	}

	public void moveDrontUP() 
	{
		if (!freeze) {
			if (gridY > 0) 
				gridY--;
		}
	}

	public void moveDrontDOWN() 
	{
		if (!freeze) {
			if (gridY < 2) 
				gridY++;
		}
	}
	public void frontFreeze() {
		freeze = true;
		freezeTime = 2;
	}
	
	public void setAnimationWalk(float timer){
		mAnimationWalk *= timer;
	}
	
	public int getDrontImage(){
				if(!freeze){
					if (mAnimation >= 8*mAnimationWalk/8) {
						tempImage = R.drawable.d1;
						return R.drawable.d1;
					} else if (mAnimation >= 7*mAnimationWalk/8) {
						tempImage = R.drawable.d2;
						return R.drawable.d2;
					} else if (mAnimation >= 6*mAnimationWalk/8) {
						tempImage = R.drawable.d3;
						return R.drawable.d3;
					} else if (mAnimation >= 5*mAnimationWalk/8) {
						tempImage = R.drawable.d4;
						return R.drawable.d4;
					} else if (mAnimation >= 4*mAnimationWalk/8) {
						tempImage = R.drawable.d5;
						return R.drawable.d5;
					} else if (mAnimation >= 3*mAnimationWalk/8) {
						tempImage = R.drawable.d6;
						return R.drawable.d6;
					} else if (mAnimation >= 2*mAnimationWalk/8) {
						tempImage = R.drawable.d7;
						return R.drawable.d7;
					} else if (mAnimation >= 1*mAnimationWalk/8) {
						tempImage = R.drawable.d8;
						return R.drawable.d8;
					} else 
						tempImage = R.drawable.d1;
						return R.drawable.d1;
				} else {
					return tempImage;
				}
	}
	
	public double getFreezeTime(){
		return freezeTime;
	}
	
	public boolean getFreeze(){
		return freeze;
	}
	public void updateDront(float timeDelta) {
		
		
		if (freeze) {
			freezeTime -=timeDelta;
			if (freezeTime < 0)
				freeze = false;
		}
		
		mAnimation -= timeDelta;
		if(mAnimation < 0){
			mAnimation += mAnimationWalk;
		}
		
		//Dront moves?
		if (gridY == 0) {
			if (yPos < 220) {
				yPos += speedY * timeDelta; 
				if (yPos > 220)
					yPos = 220;			
			}
			else yPos = 220;			
		}
		else if (gridY == 1) {
			if (yPos > 120) {
				yPos -= speedY * timeDelta;
				if (yPos < 120)
					yPos = 120;
			}
			else if (yPos < 120) {
				yPos += speedY * timeDelta; 
				if (yPos > 120)
					yPos = 120;
			}
			else yPos = 120;
		}
		else if (gridY == 2) {
			if (yPos > 20) {
				yPos -= speedY * timeDelta; 
				if (yPos < 20)
					yPos = 20;			
			}
			else yPos = 20;		
		}
		
		//Dront gets hit or power up
		if (gridX == 4) {
			if (xPos < 200) {
				xPos += speedX * timeDelta; 
				if (xPos > 200)
					xPos = 200;
			} else xPos = 200;			
		}
		else if (gridX == 3) {
			if (xPos > 150) {
				xPos -= speedX * timeDelta; 
				if (xPos < 150)
					xPos = 150; 				
			}
			else if (xPos < 150) {
				xPos += speedX * timeDelta; 
				if (xPos > 150)
					xPos = 150;
			} 			
			else xPos = 150;			
		}
		else if (gridX == 2) {
			if (xPos > 100) {
				xPos -= speedX * timeDelta; 
				if (xPos < 100)
					xPos = 100; 				
			}
			else if (xPos < 100) {
				xPos += speedX * timeDelta; 
				if (xPos > 100)
					xPos = 100;
			} 			
			else xPos = 100;			
		}
		else if (gridX == 1) {
			if (xPos > 50) {
				xPos -= speedX * timeDelta; 
				if (xPos < 50)
					xPos = 50; 				
			}
			else if (xPos < 50) {
				xPos += speedX * timeDelta; 
				if (xPos > 50)
					xPos = 50;
			} 			
			else xPos = 50;			
		}
		else if (gridX == 0) {
			if (xPos > 0) {
				xPos -= speedX * timeDelta; 
				if (xPos < 0)
					xPos = 0; 				
			}
			else xPos = 0;			
		}
		
	}
	
}
