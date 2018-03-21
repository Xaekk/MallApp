package com.catike_mall.domain.enums;

/**
 * @disc
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ27ÈÕ
 * @version v1.0.0
 */

public enum AjaxResultStatus {

	SUCCESS("Success", 0),
	FAIL("Fail", 1),
	NOTLOGIN("NotLogin", 2);
	
	private String name;
	private int value;

	AjaxResultStatus(String name,int value){
		this.name=name;
		this.value= value;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

}
