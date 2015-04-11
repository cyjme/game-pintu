package com.example.guiddemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.TextView;
import android.view.TextureView;
import com.igexin.sdk.PushManager;


import com.imooc.game.pintu.view.GamePintuLayout;
import com.imooc.game.pintu.view.GamePintuLayout.GamePintuListener;

public  class LogActivity extends Activity{
	
	private GamePintuLayout mGamePintuLayout;
	private TextView mLevel;
	private TextView mTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        PushManager.getInstance().initialize(this.getApplicationContext());
        
        mTime = (TextView) findViewById(R.id.id_time);
        mLevel = (TextView) findViewById(R.id.id_level);
        
        mGamePintuLayout = (GamePintuLayout) findViewById(R.id.id_gamepintu);
        mGamePintuLayout.setTimeEnabled(true);
        
        mGamePintuLayout.setOnGamePintuListener(new GamePintuListener()
        {
			
			@Override
			public void timechanged(int currentTime) {

				mTime.setText(""+currentTime);
			}
			
			@Override
			public void nextLevel(final int nextLevel) 
			{
				//对话框信息显示
				new AlertDialog.Builder(LogActivity.this).setTitle("Game Info").setMessage("LEVEL UP!!!").setPositiveButton("NEXT LEVEL", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) 
					{
						mGamePintuLayout.nextLevel();
						mLevel.setText(""+nextLevel);
					}
				}).show();
				
			}
			
			@Override
			public void gameover() 
			{
				//对话框信息显示2
				new AlertDialog.Builder(LogActivity.this).setTitle("Game Info").setMessage("Game Over!!!").setPositiveButton("RESTART", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) 
					{
						mGamePintuLayout.restart();
					}
				}).setNegativeButton("QUIT", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {

						finish();
					}
				}).show();
			}
		});        
    }
    @Override
    protected void onPause() {
    	super.onPause();
    	mGamePintuLayout.pause();
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	mGamePintuLayout.resume();
    }
}
