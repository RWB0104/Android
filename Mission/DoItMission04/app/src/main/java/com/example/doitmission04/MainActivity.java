package com.example.doitmission04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity
{
	EditText editText;
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText = findViewById(R.id.inputMessage);
		textView = findViewById(R.id.inputCount);
		
		View.OnClickListener listener = new View.OnClickListener()
		{
			public void onClick(View v) {
				String message = editText.getText().toString();
				Toast.makeText(getApplicationContext(), "전송할 메시지\n\n" + message, Toast.LENGTH_LONG).show();
			}
		};
		
		Button button = findViewById(R.id.sendButton);
		button.setOnClickListener(listener);
		
		TextWatcher watcher = new TextWatcher()
		{
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after)
			{
				// No
			}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count)
			{
				byte[] bytes = null;
				
				try
				{
					bytes = s.toString().getBytes("KSC5601");
					
					int textCount = bytes.length;
					
					textView.setText(textCount + " / 80바이트");
				}
				
				catch (UnsupportedEncodingException e)
				{
					e.printStackTrace();
				}
			}
			
			@Override
			public void afterTextChanged(Editable s)
			{
				String str = s.toString();
				
				try
				{
					byte[] bytes = str.getBytes("KSC5601");
					
					if (bytes.length > 80)
					{
						s.delete(s.length() - 2, s.length() - 1);
					}
				}
				
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		};
		
		editText.addTextChangedListener(watcher);
	}
}