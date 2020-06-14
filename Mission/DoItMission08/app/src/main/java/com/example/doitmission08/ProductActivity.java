package com.example.doitmission08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product);
		
		ReadIntent();
	}
	
	private void ReadIntent()
	{
		Intent intent = getIntent();
		
		if (intent != null)
		{
			String menu = intent.getStringExtra("menu");
			
			Toast.makeText(this, menu + "에서 호출함.", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void Menu(View v)
	{
		Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
		intent.putExtra("menu", this.getClass().getSimpleName());
		
		setResult(RESULT_OK, intent);
		
		finish();
	}
	
	public void Logout(View v)
	{
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		intent.putExtra("menu", this.getClass().getSimpleName());
		
		startActivity(intent);
	}
}