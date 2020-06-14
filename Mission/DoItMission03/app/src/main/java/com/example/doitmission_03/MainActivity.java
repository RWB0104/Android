package com.example.doitmission_03;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
	ImageView imageView;
	ImageView imageView2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		imageView = findViewById(R.id.imageView01);
		imageView2 = findViewById(R.id.imageView02);
		
		Button button = findViewById(R.id.button01);
		Button button2 = findViewById(R.id.button02);
		
		View.OnClickListener listener = new View.OnClickListener()
		{
			public void onClick(View v) {
				moveImageUp(imageView, imageView2);
			}
		};
		
		View.OnClickListener listener2 = new View.OnClickListener()
		{
			public void onClick(View v) {
				moveImageDown(imageView, imageView2);
			}
		};
		
		button.setOnClickListener(listener);
		button2.setOnClickListener(listener2);
		
		moveImageUp(imageView, imageView2);
	}
	
	private void moveImageUp(ImageView imageView, ImageView imageView2)
	{
		imageView.setImageResource(R.drawable.beach);
		imageView2.setImageResource(0);
		
		imageView.invalidate();
		imageView2.invalidate();
	}
	
	private void moveImageDown(ImageView imageView, ImageView imageView2)
	{
		imageView.setImageResource(0);
		imageView2.setImageResource(R.drawable.beach);
		
		imageView.invalidate();
		imageView2.invalidate();
	}
}