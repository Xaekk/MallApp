package com.catike_mall.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @disc View Direction
 * 
 * @author Ma Xuefeng
 * @date 2017Äê5ÔÂ28ÈÕ
 * @version v1.0.0
 */

public class ViewDir {
	private static final String BUNDLE_NAME = "com.catike_mall.view.dir.ViewDir"; //View Direction Properties Document

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private ViewDir() {
	}

	public static String getDir(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
