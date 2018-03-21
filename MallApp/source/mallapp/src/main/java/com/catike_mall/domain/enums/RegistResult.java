package com.catike_mall.domain.enums;

/**
 * @disc Regist Result
 * 
 * @author Ma Xuefeng
 * @date 2017Äê6ÔÂ17ÈÕ
 * @version v1.0.0
 */

public enum RegistResult {
	
	SUCCESS("Regist Success"),
	USERNAME_EXIST("Username Exist"),
	USERNAME_NOT_EXIST("Username Not Exist");
	
	private String value;
	
	RegistResult(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

}
