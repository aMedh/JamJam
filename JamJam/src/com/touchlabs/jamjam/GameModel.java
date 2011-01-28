package com.touchlabs.jamjam;

import android.content.Context;



public class GameModel implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Dront mDront;
	
	/**
	 * Constructor
	 */
	public GameModel() {
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
			mDront.updateDront(timeDelta);
			//GEhsssss
	}
	
	//Return the dront
	public Dront getDront() {
		return mDront;
	}


	public  void release() {

		// TODO Auto-generated method stub
		

	}
}
