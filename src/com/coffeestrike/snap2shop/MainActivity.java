package com.coffeestrike.snap2shop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {
	
	public static final int REQUEST_CAMERA_TAKE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getSupportFragmentManager().beginTransaction()
			.add(R.id.fragment_container, new GridFragment())
			.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.action_bar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent launchIntent = null;
		/*
		 * Determine which menu item has been selected,
		 * then perform the appropriate action.
		 */
		switch(item.getItemId()){
			/*
			 * In this case, we need to launch an activity
			 * via intent, to capture a picture.
			 */
			case R.id.action_camera:
				launchIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(launchIntent, REQUEST_CAMERA_TAKE);
				return true;
			/*
			 * In this case, we need to launch the built in 
			 * settings activity.
			 */
			case R.id.action_settings:
				return true;
				
			//Defer action to superclass method.
			default:
				return super.onOptionsItemSelected(item);
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if(intent == null){
			return;
		}
		switch (requestCode){
			case REQUEST_CAMERA_TAKE:
				if (resultCode == RESULT_OK) {
					Bitmap b = (Bitmap) intent.getExtras().get("data");
//					TestFragment t = (TestFragment) getSupportFragmentManager()
//							.findFragmentById(R.id.fragment_container);
//					t.setImageView(b);
					GridFragment gridFrag = (GridFragment)getSupportFragmentManager()
							.findFragmentById(R.id.fragment_container);
					gridFrag.addNewItem(b);
				}
				break;
			default:
				return;
		
		}
	}
	
	

}
