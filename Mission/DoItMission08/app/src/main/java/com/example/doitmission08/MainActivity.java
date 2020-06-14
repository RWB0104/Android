package com.example.doitmission08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ReadIntent();
	}
	
	public void Login(View v)
	{
		EditText idText = findViewById(R.id.editText);
		EditText passwordText = findViewById(R.id.editText2);
		
		String id = idText.getText().toString();
		String password = passwordText.getText().toString();
		
		if (id.equals("") || password.equals(""))
		{
			Toast.makeText(this, "임의의 계정정보를 입력하세요.", Toast.LENGTH_SHORT).show();
		}
		
		else
		{
			Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
			intent.putExtra("menu", this.getClass().getSimpleName());
			intent.putExtra("id", id);
			intent.putExtra("password", password);
			startActivityForResult(intent, 101);
		}
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
