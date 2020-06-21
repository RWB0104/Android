package com.example.doitmission10;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageFragment extends Fragment
{
	TextView textView;
	
	String name;
	
	public static PageFragment newInstance(String name)
	{
		PageFragment fragment = new PageFragment();
		
		Bundle bundle = new Bundle();
		bundle.putString("name", name);
		
		fragment.setArguments(bundle);
		
		return fragment;
	}
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		Bundle bundle = getArguments();
		
		name = bundle.getString("name");
	}
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.page, container, false);
		
		textView = rootView.findViewById(R.id.textView);
		textView.setText(name);
		
		return rootView;
	}
}