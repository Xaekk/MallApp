package com.catike_mall.domain.enums;

/**
 * @disc
 * 
 * @author Ma Xuefeng
 * @date 2017Äê6ÔÂ16ÈÕ
 * @version v1.0.0
 */

public enum AuthorityRole {
	ROLE_USER("ROLE_USER");

	private String value;

	AuthorityRole(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
