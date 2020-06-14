package com.example.doitmission07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		Button button2 = findViewById(R.id.button2);
		
		View.OnClickListener listener2 = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.putExtra("menu", "고객 관리");
				
				setResult(Activity.RESULT_OK, intent);
				
				finish();
			}
		};
		
		button2.setOnClickListener(listener2);
		
		Button button3 = findViewById(R.id.button3);
		
		View.OnClickListener listener3 = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.putExtra("menu", "매출 관리");
				
				setResult(Activity.RESULT_OK, intent);
				
				finish();
			}
		};
		
		button3.setOnClickListener(listener3);
		
		Button button4 = findViewById(R.id.button4);
		
		View.OnClickListener listener4 = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.putExtra("menu", "상품 관리");
				
				setResult(Activity.RESULT_OK, intent);
				
				finish();
			}
		};
		
		button4.setOnClickListener(listener4);
	}
}