package com.catike_mall.service;

import com.catike_mall.domain.entity.normal.UserInfo;

/**
 * @disc Current UserInfo Service
 * 
 * @author Ma Xuefeng
 * @date 2017��6��16��
 * @version v1.0.0
 */

public interface CurrentUserService {
	
	/*
	 * Get Current User Information 
	 */
	UserInfo getCurrentUser();
}