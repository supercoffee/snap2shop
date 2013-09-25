package com.coffeestrike.snap2shop.utils;

import java.io.File;

import android.net.Uri;
import android.os.Environment;

public class ImageUtil {
	
	public static final String ALBUM_DIR_NAME = "com.coffeestrike.snap2shop";
	
	public static void createAlbumDir(){
		//Check if external media is mounted
		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
			//check if directory already exists
			if(! (new File(Environment.getExternalStoragePublicDirectory(
					Environment.DIRECTORY_PICTURES)
					+ALBUM_DIR_NAME).exists())){
				
			}
		}
	}

	public static Uri createImageUri(File tempFile){
		return null;
		
	}
}
