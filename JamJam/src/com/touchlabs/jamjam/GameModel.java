package com.touchlabs.jamjam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;



public class GameModel implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private GroundTop groundTop;
	private GroundMid groundMid;
	private GroundBot groundBot;
	//private EnemyWall enemyWall;
	private Dront mDront;
	
	private List<EnemyWall> listEnemyWall = new ArrayList<EnemyWall>();

	
	/**
	 * Constructor
	 */
	public GameModel() {

		
		groundTop = new GroundTop();
		groundMid = new GroundMid();
		groundBot = new GroundBot();

		mDront = new Dront();
		
		Random generator = new Random();
		for(int i = 0; i < 6; i++){
			
			listEnemyWall.add(new EnemyWall((generator.nextInt(9) + 1), (generator.nextInt(3) + 1)));
		}
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
		
		mDront.updateDront(timeDelta);
		
		int count = listEnemyWall.size();
		for(int i = 0; i < count; i++){
			listEnemyWall.get(i).setXPos(timeDelta);
		}
		
		for(int i = 0; i < count; i++){
			if(mDront.getX() + 80 > listEnemyWall.get(i).getX1() && mDront.getX() < listEnemyWall.get(i).getX1()){
				if(mDront.getY() + 80 > listEnemyWall.get(i).getY() && mDront.getY() < listEnemyWall.get(i).getY() +80){
					mDront.hitDront();
					listEnemyWall.get(i).setNewRandomTime();	
				}
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
	
	public List<EnemyWall> getListEnemyWall(){
		return listEnemyWall;
	}

	public  void release() {

		// TODO Auto-generated method stub
		

	}
}
