package com.example.doitmission08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		ReadIntent();
	}
	
	private void ReadIntent()
	{
		Intent intent = getIntent();
		
		if (intent != null)
		{
			String menu = intent.getStringExtra("menu");
			
			if (menu.equals("MainActivity"))
			{
				String id = intent.getStringExtra("id");
				String password = intent.getStringExtra("password");
				
				Toast.makeText(this, menu + "에서 호출함.\nID : " + id + "\nPW : " + password, Toast.LENGTH_SHORT).show();
			}
			
			else
			{
				Toast.makeText(this, menu + "에서 호출함.", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	public void Customer(View v)
	{
		Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
		intent.putExtra("menu", this.getClass().getSimpleName());
		startActivityForResult(intent, 101);
	}
	
	public void Sales(View v)
	{
		Intent intent = new Intent(getApplicationContext(), SalesActivity.class);
		intent.putExtra("menu", this.getClass().getSimpleName());
		startActivityForResult(intent, 101);
	}
	
	public void Product(View v)
	{
		Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
		intent.putExtra("menu", this.getClass().getSimpleName());
		startActivityForResult(intent, 101);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		
		if (data != null)
		{
			String menu = data.getStringExtra("menu");
			
			Toast.makeText(this, menu + "에서 호출함.", Toast.LENGTH_SHORT).show();
		}
		
		else
		{
			Toast.makeText(this, "Intent가 존재하지 않음.", Toast.LENGTH_SHORT).show();
		}
	}
}