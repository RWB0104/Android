package com.example.sampledialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView = findViewById(R.id.textView);
		
		Button button = findViewById(R.id.button);
		
		View.OnClickListener listener = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showMessage();
			}
		};
		
		button.setOnClickListener(listener);
	}
	
	private void showMessage()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("안내");
		builder.setMessage("종료하시겠습니까?");
		builder.setIcon(android.R.drawable.ic_dialog_alert);
		
		DialogInterface.OnClickListener listener2 = new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				String message = "예 버튼이 눌렸습니다.";
				
				textView.setText(message);
			}
		};
		
		DialogInterface.OnClickListener listener3 = new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				String message = "취소 버튼이 눌렸습니다.";
				
				textView.setText(message);
			}
		};
		
		DialogInterface.OnClickListener listener4 = new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				String message = "아니오 버튼이 눌렸습니다.";
				
				textView.setText(message);
			}
		};
		
		builder.setPositiveButton("예", listener2);
		builder.setNeutralButton("취소", listener3);
		builder.setNegativeButton("아니오", listener4);
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}
}