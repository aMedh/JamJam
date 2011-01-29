package com.touchlabs.jamjam;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Debug;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class GamePreview extends SurfaceView implements SurfaceHolder.Callback, java.io.Serializable{
	
	public static final long serialVersionUID = 1L;
	private static final Paint sPaintTextWhite = new Paint();
	private static final Paint sPaintTextBlack = new Paint();
	private GamePreviewThread thread;
	private Map<Integer, Bitmap> mBitMapCache = new HashMap<Integer, Bitmap>();
	private Activity mActivity;
	private GameModel mGameModel;

	public Context context;

	
	public GamePreview(Context context) {
		super(context);			
		this.context = context;
		
		mGameModel = new GameModel();
		mGameModel.initialize(context);
		
		fillBitmapCache();	
		mActivity = (Activity) context;		
		getHolder().addCallback(this);
		thread = new GamePreviewThread(this,mGameModel);
		setFocusable(true);
		setFocusableInTouchMode(true);
		requestFocus();
		
		sPaintTextWhite.setTextSize(16);
		sPaintTextWhite.setARGB(255, 255, 255, 255);
		Typeface font2 = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
		sPaintTextWhite.setTypeface(font2);
		sPaintTextWhite.setAntiAlias(true);
		
		sPaintTextBlack.setTextSize(16);
		sPaintTextBlack.setARGB(255, 0, 0, 0);
		Typeface font3 = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
		sPaintTextBlack.setTypeface(font3);
		sPaintTextBlack.setAntiAlias(true);

	}
	

	
	
	private void fillBitmapCache() {
		mBitMapCache = new HashMap<Integer, Bitmap>();
		mBitMapCache.put(R.drawable.background, BitmapFactory.decodeResource(getResources(), R.drawable.background));
		mBitMapCache.put(R.drawable.gamebg, BitmapFactory.decodeResource(getResources(), R.drawable.gamebg));
		mBitMapCache.put(R.drawable.dront, BitmapFactory.decodeResource(getResources(), R.drawable.dront));
		mBitMapCache.put(R.drawable.egg, BitmapFactory.decodeResource(getResources(), R.drawable.egg));
		mBitMapCache.put(R.drawable.watch, BitmapFactory.decodeResource(getResources(), R.drawable.watch));
		mBitMapCache.put(R.drawable.stop, BitmapFactory.decodeResource(getResources(), R.drawable.stop));
		mBitMapCache.put(R.drawable.ground, BitmapFactory.decodeResource(getResources(), R.drawable.ground));
		mBitMapCache.put(R.drawable.wall, BitmapFactory.decodeResource(getResources(), R.drawable.wall));
		mBitMapCache.put(R.drawable.gameover, BitmapFactory.decodeResource(getResources(), R.drawable.gameover));

	}
	

	public void onDraw(Canvas canvas) {
		// Draw background		
		canvas.drawBitmap(mBitMapCache.get(R.drawable.gamebg),0,0,null);
		
		
		// Draw top ground
		canvas.drawBitmap(mBitMapCache.get(R.drawable.ground), mGameModel.getGroundTop().getX1(), mGameModel.getGroundTop().getY(),null);
		canvas.drawBitmap(mBitMapCache.get(R.drawable.ground), mGameModel.getGroundTop().getX2(), mGameModel.getGroundTop().getY(),null);
		
		// Draw middle ground
		canvas.drawBitmap(mBitMapCache.get(R.drawable.ground), mGameModel.getGroundMid().getX1(), mGameModel.getGroundMid().getY(),null);
		canvas.drawBitmap(mBitMapCache.get(R.drawable.ground), mGameModel.getGroundMid().getX2(), mGameModel.getGroundMid().getY(),null);
		
		//Draw bottom ground
		canvas.drawBitmap(mBitMapCache.get(R.drawable.ground), mGameModel.getGroundBot().getX1(), mGameModel.getGroundBot().getY(),null);
		canvas.drawBitmap(mBitMapCache.get(R.drawable.ground), mGameModel.getGroundBot().getX2(), mGameModel.getGroundBot().getY(),null);

		//Draw wall in the middle
		int count = mGameModel.getListEnemyWall().size();
		for(int i = 0; i < count; i++){
			canvas.drawBitmap(mBitMapCache.get(R.drawable.wall), mGameModel.getListEnemyWall().get(i).getX1(), mGameModel.getListEnemyWall().get(i).getY(),null);
		}
		canvas.drawBitmap(mBitMapCache.get(R.drawable.dront),mGameModel.getDront().getX(),mGameModel.getDront().getY(),null);
	
		//PowerUp
		if (mGameModel.getPowerUp().getType() == 0)
			canvas.drawBitmap(mBitMapCache.get(R.drawable.egg),mGameModel.getPowerUp().getX(),mGameModel.getPowerUp().getY(),null);
		else if (mGameModel.getPowerUp().getType() == 1)
			canvas.drawBitmap(mBitMapCache.get(R.drawable.watch),mGameModel.getPowerUp().getX(),mGameModel.getPowerUp().getY(),null);
		else if (mGameModel.getPowerUp().getType() == 2)
			canvas.drawBitmap(mBitMapCache.get(R.drawable.stop),mGameModel.getPowerUp().getX(),mGameModel.getPowerUp().getY(),null);
		
		canvas.drawText("Distance: " + mGameModel.getDistance(), 156,20+2,sPaintTextBlack);
		canvas.drawText("Distance: " + mGameModel.getDistance(), 155,20,sPaintTextWhite);

		//Lost?
		if(mGameModel.getLost()){
			canvas.drawBitmap(mBitMapCache.get(R.drawable.gameover),100-30,60,null);
			canvas.drawText("Your distance: " + mGameModel.getDistance(), 166-20,165+2,sPaintTextBlack);
			
		    // Restore preferences
			SharedPreferences settings = mActivity.getSharedPreferences("Score_file", 0);
			canvas.drawText("Highscore: " + settings.getInt("distance", 0), 166-20,185+2,sPaintTextBlack);
			
			if(mGameModel.getDistance() > settings.getInt("distance", 0)){
			// Save you score
				SharedPreferences settings2 = context.getSharedPreferences("Score_file", 0);
				SharedPreferences.Editor editor = settings2.edit();
				editor.putInt("distance", mGameModel.getDistance());
				editor.commit();
			}
		}

	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {		
		
		synchronized (getHolder()) {			
			
			switch(event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				if(!mGameModel.getLost()){
					if (event.getX() > 0 && event.getX() < 520) {
						if (event.getY() > 0 && event.getY() < 160)
							mGameModel.getDront().moveDrontDOWN();
						if (event.getY() > 160)
							mGameModel.getDront().moveDrontUP();
					}
				} else {
					thread.setRunning(false);
					mBitMapCache = null;
					getHolder().removeCallback(this);
					Activity parent = (Activity) getContext();
					parent.finish();
				}
		
				break;
			case MotionEvent.ACTION_MOVE:
				

				break; 
			case MotionEvent.ACTION_UP:
					
		

				break;
			}
			
		}
		
		return true;
	}


	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	public void surfaceCreated(SurfaceHolder holder) {
		
		if (!thread.isAlive()) {
			thread = new GamePreviewThread(this,mGameModel);			
		}
		
		thread.setRunning(true);
		thread.start();
		
		
		
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		//Log.v("Progression","surfaceDestroyed");
		boolean retry = true;
		thread.setRunning(false);
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// we will try it again and again...
			}
		}
		
		// To prevent memory filled exception
		mBitMapCache = new HashMap<Integer, Bitmap>();
	}
	

}
