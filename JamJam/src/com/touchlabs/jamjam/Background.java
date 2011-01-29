package com.touchlabs.jamjam;

public class Background {
	private int xPos = 0;
	private int xPos2 = 1068;
	private int speed;
	private int temp;
	
	public Background(){
		speed = 23;
	}
	
	public int getImage(){
		return R.drawable.bg;
	}
	
	
	public int getX(){
		return xPos;
	}
	
	public int getX2(){
		return xPos2;
	}
	
	
	public void setXPos(float timeDelta){
		temp = Double.valueOf(timeDelta * speed).intValue();
		xPos -= temp;//timeDelta * speed;
		xPos2 -= temp;// timeDelta * speed;
		if(xPos <= -1068)
			xPos = xPos2 + 1068;
		
		if(xPos2 <= -1068)
			xPos2 = xPos + 1068;
	}
}
