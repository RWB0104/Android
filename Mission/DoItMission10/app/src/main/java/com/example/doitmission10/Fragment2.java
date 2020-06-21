package com.example.doitmission10;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment2 extends Fragment
{
	private static final String TAG = "Fragment2";
	
	FragmentCallback callback;
	
	@Override
	public void onAttach(Context context)
	{
		super.onAttach(context);
		
		if (context instanceof FragmentCallback)
		{
			callback = (FragmentCallback) context;
		}
		
		else
		{
			Log.d(TAG, "Activity is not FragmentCallback.");
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);
		
		Button button1 = rootView.findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				callback.onFragmentSelected(2, null);
			}
		});
		
		return rootView;
	}
}