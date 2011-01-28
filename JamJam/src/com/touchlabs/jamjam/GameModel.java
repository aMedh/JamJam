package com.touchlabs.jamjam;

import android.content.Context;



public class GameModel implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private GroundTop groundTop;
	private GroundMid groundMid;
	private GroundBot groundBot;
	private EnemyWall enemyWall;

	private Dront mDront;

	
	/**
	 * Constructor
	 */
	public GameModel() {

		groundTop = new GroundTop();
		groundMid = new GroundMid();
		groundBot = new GroundBot();
		enemyWall = new EnemyWall();

		mDront = new Dront();

	}
	
	/**
	 * Initializes all variables of the GameModel.
	 */
	public  void initialize(Context context) {
	
	
	}
	
	/**
	 * This class is called from the GameThread. 
	 * @param timeDelta 
	 */
	public  void updateModel(float timeDelta) {


		groundTop.setXPos(timeDelta);
		groundMid.setXPos(timeDelta);
		groundBot.setXPos(timeDelta);
		
		enemyWall.setXPos(timeDelta); //Wall in the middle
		

		mDront.updateDront(timeDelta);
		
		if(mDront.getX() + 80 > enemyWall.getX1() && mDront.getX() < enemyWall.getX1()){
			if(mDront.getY() + 80 > enemyWall.getY() && mDront.getY() < enemyWall.getY() +80){
				mDront.hitDront();
				enemyWall.setXPos(600);
				
				
			}
		}

	}
	
	//Return the dront
	public Dront getDront() {
		return mDront;
	}

	public GroundTop getGroundTop(){
		return groundTop;
	}
	
	public GroundMid getGroundMid(){
		return groundMid;
	}
	
	public GroundBot getGroundBot(){
		return groundBot;
	}
	
	public EnemyWall getEnemyWall(){
		return enemyWall;
	}

	public  void release() {

		// TODO Auto-generated method stub
		

	}
}
