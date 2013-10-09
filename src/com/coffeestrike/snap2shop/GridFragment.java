package com.coffeestrike.snap2shop;

import java.util.ArrayList;

import com.coffeestrike.snap2shop.activities.ShoppingListActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridFragment extends Fragment {
	
	private static String STATE_IMAGES = "mImages";

	private ArrayList<Bitmap> mImages;
	private GridAdapter mAdapter;
	
	@SuppressWarnings("unchecked")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//this section here will reload the images 
		if (savedInstanceState == null) {
			mImages = new ArrayList<Bitmap>();
		}
		else{
			mImages = (ArrayList<Bitmap>) savedInstanceState.getSerializable(STATE_IMAGES);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		GridView g = (GridView) inflater.inflate(R.layout.grid, null);
		
		
		mAdapter = new GridAdapter(getActivity().getApplicationContext(), 0, mImages);
		g.setAdapter(mAdapter);

		return g;
	}
	
	public void addNewItem(Bitmap bitmap){
		mImages.add(bitmap);
		mAdapter.notifyDataSetChanged();
	}
	
	
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putSerializable(STATE_IMAGES, mImages);
	}

	
	


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode !=  Activity.RESULT_OK){
			return;
		}
		switch(requestCode){
			case ShoppingListActivity.REQUEST_CAMERA_TAKE:
				//add the new image from the intent to the grid
				mAdapter.add((Bitmap) data.getExtras().get("data"));
				break;
			default:
				return;
					
		}
	}





	private class GridAdapter extends ArrayAdapter<Bitmap>{
		
		public GridAdapter(Context applicationContext, int i
				, ArrayList<Bitmap> images) {
			super(applicationContext, i, images);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if(convertView == null){ //create a new view
				imageView = new ImageView(getContext());
			}
			else{ //reuse the old view
				imageView = (ImageView) convertView;
			}
			if (mImages != null) {
				imageView.setImageBitmap(getItem(position));
			}
			return imageView;
		}
		
	}
	
	

}
