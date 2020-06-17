package com.example.samplefragment2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment
{
	public static interface ImageSelectionCallback
	{
		public void onImageSelected(int position);
	}
	
	public ImageSelectionCallback callback;
	
	@Override
	public void onAttach(@NonNull Context context)
	{
		super.onAttach(context);
		
		if (context instanceof ImageSelectionCallback)
		{
			callback = (ImageSelectionCallback) context;
		}
	}
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
		
		Button button = rootView.findViewById(R.id.button);
		
		View.OnClickListener listener = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (callback != null)
				{
					callback.onImageSelected(0);
				}
			}
		};
		
		button.setOnClickListener(listener);
		
		Button button2 = rootView.findViewById(R.id.button2);
		
		View.OnClickListener listener2 = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (callback != null)
				{
					callback.onImageSelected(1);
				}
			}
		};
		
		button2.setOnClickListener(listener2);
		
		Button button3 = rootView.findViewById(R.id.button3);
		
		View.OnClickListener listener3 = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (callback != null)
				{
					callback.onImageSelected(2);
				}
			}
		};
		
		button3.setOnClickListener(listener3);
		
		return rootView;
	}
}