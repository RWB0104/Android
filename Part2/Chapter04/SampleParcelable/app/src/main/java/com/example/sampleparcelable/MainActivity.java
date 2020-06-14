package com.example.sampleparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
	public static final int REQUEST_CODE_MENU = 101;
	public static final String KEY_SIMPLE_DATA = "data";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = findViewById(R.id.button);
		
		View.OnClickListener listener = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				SimpleData data = new SimpleData(100, "Hello World!");
				
				Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
				intent.putExtra(KEY_SIMPLE_DATA, data);
				
				startActivityForResult(intent, REQUEST_CODE_MENU);
			}
		};
		
		button.setOnClickListener(listener);
	}
}
