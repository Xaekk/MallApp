package com.catike_mall.domain.enums;

/**
 * @disc InnserMail Special From Pkid
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ26ÈÕ
 * @version v1.0.0
 */

public enum InnerMailSpecialFromPkid {

	BROADCAST("broadcast", -1),
	ADMINISTRATOR("administrator", -2);

	private String name;
	private int value;

	InnerMailSpecialFromPkid(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

}
