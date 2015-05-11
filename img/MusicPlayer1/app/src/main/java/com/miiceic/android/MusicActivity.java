package com.miiceic.android;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;


public class MusicActivity extends Activity 
{
	private ImageButton	mStopImageButton;
	private ImageButton	mStartImageButton;
	private ImageButton	mPauseImageButton;
	private TextView mTextView;	

	private boolean		bIsReleased		= false;
	private boolean		bIsPaused		= false;
	private boolean 	bIsPlaying		= false;

	public MediaPlayer mMediaPlayer = new MediaPlayer();  ;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mStopImageButton = (ImageButton) findViewById(R.id.StopImageButton);
		mStartImageButton = (ImageButton) findViewById(R.id.StartImageButton); 
		mPauseImageButton = (ImageButton) findViewById(R.id.PauseImageButton);
		
		mTextView = (TextView) findViewById(R.id.TextView01); 

		mStopImageButton.setOnClickListener(new ImageButton.OnClickListener() 
		{
			@Override
			public void onClick(View v)
			{
				if (bIsPlaying == true)
				{
					if ( !bIsReleased )
					{
						mMediaPlayer.stop();
						mMediaPlayer.release();
						bIsReleased = true;	
					}
					bIsPlaying = false;
					mTextView.setText("��ǰΪֹͣ״̬���밴��ʼ���������֣�");
				}
			}
		}); 

		mStartImageButton.setOnClickListener(new ImageButton.OnClickListener() 
		{
			@Override
			public void onClick(View v)
			{
				try
				{
					if ( !bIsPlaying )
					{
						bIsPlaying = true;

						mMediaPlayer = MediaPlayer.create(MusicActivity.this, R.raw.la_isla_bonita);
						bIsReleased = false;

						mMediaPlayer.setLooping(true);
						try
						{
							mMediaPlayer.prepare();
						}
						catch (IllegalStateException e)
						{
							e.printStackTrace();
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
						mMediaPlayer.start();
						mTextView.setText("���ڲ������֣�");
					}
				}
				catch (IllegalStateException e)
				{
					e.printStackTrace();
				}
				mMediaPlayer.setOnCompletionListener(new OnCompletionListener() 
				{
					// @Override
					public void onCompletion(MediaPlayer arg0)
					{
						mMediaPlayer.release(); 
					}
				});
			}
		});  
		

		mPauseImageButton.setOnClickListener(new ImageButton.OnClickListener() 
		{
			public void onClick(View view)
			{
				if (mMediaPlayer != null)
				{
					if (bIsReleased == false)
					{
						if (bIsPaused == false)
						{
							mMediaPlayer.pause();
							bIsPaused = true;
							bIsPlaying = true;
							mTextView.setText("�Ѿ���ͣ�����ٴΰ���ͣ��ť�ָ����ţ�");
						}
						else if (bIsPaused == true)
						{
							mMediaPlayer.start();
							bIsPaused = false;
							mTextView.setText("���ָֻ����ţ�");
						}
					}
				}
			}
		});
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if ( keyCode ==  KeyEvent.KEYCODE_BACK)
		{
			if ( !bIsReleased )
			{
				mMediaPlayer.stop();
				mMediaPlayer.release();
				bIsReleased = true;	
			}
			this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
