package com.catike_mall.util;

import java.util.Date;

import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.domain.enums.AuthorityRole;

/**
 * @disc 
 * 
 * @author Ma Xuefeng
 * @date 2017Äê6ÔÂ16ÈÕ
 * @version v1.0.0
 */

public class AuthorityOperator {
	
	/**
	 * Set New User Authority
	 */
	static public void setNewUserAuthority(UserInfo userInfo){
		
		userInfo.setEnabled(true);
		userInfo.setAuthority(AuthorityRole.ROLE_USER.getValue());
		
		userInfo.setMakeTime(new Date());
	}
}
