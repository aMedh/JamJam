package com.touchlabs.jamjam;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Start extends Activity {	
	 protected int mSplashTime = 10000;
	 protected Thread mSplashThread;
	 private boolean mNextActivityStarted;
	    
	    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        // Set the screen orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        // thread for displaying the SplashScreen
        mSplashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (waited < mSplashTime) {
                        sleep(100); //100
                        waited += 200; //200
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
                	if (mNextActivityStarted == false) {
             			mNextActivityStarted = true;
             			startActivity(new Intent(Start.this, Menu.class));
             			
             			finish();
                	}
                }
            }
        };
        mSplashThread.start();
        
    }
}