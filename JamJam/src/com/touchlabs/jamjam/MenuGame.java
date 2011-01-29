package com.touchlabs.jamjam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;


public class MenuGame extends Activity {
    
	public GamePreview gamePreview;

	
    /**
     * Method called on application start.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MenuGame","onCreate()");
        
        // Set the screen orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        SoundManager mSoundManager = new SoundManager(getBaseContext());	

        requestWindowFeature(Window.FEATURE_NO_TITLE);
         gamePreview = new GamePreview(this,mSoundManager); 
         setContentView(gamePreview);        
    }

    
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
  
    }
    
    public void startGamePanel() {
    	
    }
    
    /**
     * Method called upon application closure.
     */
    @Override
    public void onStop() {
    	super.onStop();
    	finish();
    }
    
    @Override
    public void onRestart() {
    	//Log.i("MenuGame","onRestart()");
    	super.onRestart();
    }
    
    @Override
    public void onStart() {
    	//Log.i("MenuGame","onStart()");
    	super.onStart();
    }
    
    @Override
    public void onResume() {
    	//Log.i("MenuGame","onResume()");
    	super.onResume();
    
    }
    
    @Override
    public void onPause() {
    	//Log.i("MenuGame","onPause()");
    	super.onPause();
    	
        

    
    }
    
    @Override
    public void onDestroy() {
       	//Log.i("MenuGame","onDestroy()");
    	super.onDestroy();
 
    }
}