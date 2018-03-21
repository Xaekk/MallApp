package com.catike_mall.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @disc View Direction
 * 
 * @author Ma Xuefeng
 * @date 2017Äê6ÔÂ29ÈÕ
 * @version v1.0.0
 */

public class ImgDir {
	private static final String BUNDLE_NAME = "com.catike_mall.view.dir.ImgDir"; //Image Direction Properties Document

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private ImgDir() {
	}

	public static String getDir(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static String getUserDir(){
		return getDir("user");
	}
	
	public static String getStoreDir(){
		return getDir("store");
	}
	
	public static String getGoodsDir(){
		return getDir("goods");
	}
}
