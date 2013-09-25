package com.coffeestrike.snap2shop;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridFragment extends Fragment {
	
	private static String STATE_IMAGES = "mImages";

	private ArrayList<Bitmap> mImages;
	private GridAdapter mAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		GridView g = (GridView) inflater.inflate(R.layout.grid, null);
		
		if (savedInstanceState == null) {
			mImages = new ArrayList<Bitmap>();
		}
		else{
			mImages = (ArrayList<Bitmap>) savedInstanceState.getSerializable(STATE_IMAGES);
		}
		mAdapter = new GridAdapter(getActivity());
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



	private class GridAdapter extends BaseAdapter{
		private Context mContext;
		
		public GridAdapter(Context c){
			mContext = c;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mImages.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if(convertView == null){
				imageView = new ImageView(mContext);
			}
			else{
				imageView = (ImageView)convertView;
			}
			if (mImages != null) {
				imageView.setImageBitmap(mImages.get(position));
			}
			return imageView;
		}
		
	}
	
	

}
