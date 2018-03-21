package com.catike_mall.domain.enums;

/**
 * @disc Adevertisement Position
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ20ÈÕ
 * @version v1.0.0
 */

public enum AdvertisePosition {

	WithGoodsList("WithGoodsList",0),
	TopOfHomepage("TopOfHomepage",1);
	
	private String name;
	private int value;
	
	AdvertisePosition(String name, int value){
		this.name = name;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}
