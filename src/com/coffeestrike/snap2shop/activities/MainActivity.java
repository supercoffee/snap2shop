package com.coffeestrike.snap2shop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.coffeestrike.snap2shop.R;


public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button shoppingList = (Button) findViewById(R.id.btn_list);
		shoppingList.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, ShoppingListActivity.class);
				startActivityForResult(i, 0);
			}
		});
		
		Button fridge = (Button) findViewById(R.id.btn_fridge);
		fridge.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, FridgeActivity.class);
				startActivityForResult(i, 0);
			}
		});
	}
	
	
	
	
	

}
