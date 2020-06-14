package com.example.samplecallintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
	EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText = findViewById(R.id.editText);
		
		Button button = findViewById(R.id.button);
		
		View.OnClickListener listener = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				String data = editText.getText().toString();
				
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
				
				startActivity(intent);
			}
		};
		
		button.setOnClickListener(listener);
		
		Button button2 = findViewById(R.id.button2);
		
		View.OnClickListener listener2 = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				ComponentName name = new ComponentName("com.example.samplecallintent", "com.example.samplecallintent.MenuActivity");
				
				Intent intent = new Intent();
				intent.setComponent(name);
				
				startActivityForResult(intent, 101);
			}
		};
		
		button2.setOnClickListener(listener2);
	}
}