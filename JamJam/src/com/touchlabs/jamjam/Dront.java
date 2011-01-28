package com.touchlabs.jamjam;

public class Dront {
	private int xPos = 225;
	private int yPos = 220;
	private int gridX = 3;
	private int gridY = 0;
	private int speedX = 600;
	private int speedY = 300;
	
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
	
	public void hitDront() 
	{
		if (gridX > 0) 
			gridX--;
	}

	public void moveDrontUP() 
	{
		if (gridY > 0) 
			gridY--;
	}

	public void moveDrontDOWN() 
	{
		if (gridY < 2) 
			gridY++;
	}
		
	public void updateDront(float timeDelta) {
		
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
		
		//Dront gets hit?
		if (gridX == 3) {
			xPos = 225;			
		}
		if (gridX == 2) {
			if (xPos > 150) {
				xPos -= speedX * timeDelta; 
			}
			else xPos = 150;			
		}
		if (gridX == 1) {
			if (xPos > 75) {
				xPos -= speedX * timeDelta; 
			}
			else xPos = 75;			
		}
		if (gridX == 0) {
			if (xPos > 0) {
				xPos -= speedX * timeDelta; 
			}
			else xPos = 0;			
		}
		
	}
	
}
