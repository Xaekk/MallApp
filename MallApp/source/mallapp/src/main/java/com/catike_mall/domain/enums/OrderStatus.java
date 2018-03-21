package com.catike_mall.domain.enums;

/**
 * @disc Order Status
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ26ÈÕ
 * @version v1.0.0
 */

public enum OrderStatus {

	WAITINGFORSEND("WaitingForSend", 0),
	CANCEL("Cancel",3),//Cancel before OnTheWay
	ONTHEWAY("OnTheWay", 1),
	FINISHED("Finished", 2);
	
	private String name;
	private int value;
	
	OrderStatus(String name, int value){
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
