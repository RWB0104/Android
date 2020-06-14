package com.example.doitmission07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
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
				Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
				
				startActivityForResult(intent, 101);
			}
		};
		
		button.setOnClickListener(listener);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == 101)
		{
			if (data != null)
			{
				String menu = data.getStringExtra("menu");

				Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", menu : " + menu, Toast.LENGTH_LONG);
				toast.show();
			}
		}
	}
}