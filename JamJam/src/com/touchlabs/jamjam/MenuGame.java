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
	//	public GameModel gm;
	private File mFile;
	
	// FOR SAVE
	FileOutputStream f_out;
	ObjectOutputStream obj_out;
	//	GameModel gmsave;
	FileInputStream f_in;
	ObjectInputStream obj_in;
	Object obj;
	boolean save = false;
	
    /**
     * Method called on application start.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MenuGame","onCreate()");
        
        // Set the screen orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        
        
        if (savedInstanceState != null) {
            Toast.makeText(this, "onCreate() : " + savedInstanceState.getString("TO_REMEMBER"), Toast.LENGTH_LONG).show();
        }
                gamePreview = new GamePreview(this); 
        //        gamePreview.setState(2); // Set to STATE_CHOOSETRACK
        

     // Read from disk using FileInputStream.
        try{
		     // Use a FileOutputStream to send data to a file
		     // called myobject.data.
            f_in = new FileInputStream (Environment.getExternalStorageDirectory() + "/etdsavestatetest.ser");

       	     // Read object using ObjectInputStream.
       	     obj_in = new ObjectInputStream (f_in);
       	   
       		 // Read an object.
       		 obj = obj_in.readObject ();

	
	        // Is the object that you read in, say, an instance
	        // of the Vector class?
       		Toast.makeText(this, "obj Instance Of GameModel?", Toast.LENGTH_LONG).show();
       		/*
	        if (obj instanceof GameModel)
	        {
		         // Cast object to a Vector
		         gmsave = (GameModel) obj;
		         //gamePreview.setResumeGame(true);// 
		         save = true;
		         gamePreview.setState(3); // Set to STATE_RESUMEGAME
		         Toast.makeText(this, "Show pop up!", Toast.LENGTH_LONG).show();

	        }
            */
            
            //---------------------

       } catch (FileNotFoundException ds){
    	
    	   Toast.makeText(this, "File Not Found", Toast.LENGTH_LONG).show();
    	   
       } catch (IOException ioex){
    	   Toast.makeText(this, "IO Exception", Toast.LENGTH_LONG).show();
       } catch (ClassNotFoundException ioedsxm){
    	   Toast.makeText(this, "Class not found", Toast.LENGTH_LONG).show();
       }
       
    
        
     if(save){
    	 //   	 gmsave.initialize(this);

    	 //   	 gamePreview.setSavedGameModel(gmsave);
     }
        
       
        
          setContentView(gamePreview);        
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
       {
        // our "pseudo-constructor"
	   in.defaultReadObject();
         // now we are a "live" object again, so let's run rebuild and start
     //  startAnimation();
    
       }
    
    //    private void setGM(GameModel gameM){
    	//   	gm = gameM;
    	//return gameM;
    //   }
    
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