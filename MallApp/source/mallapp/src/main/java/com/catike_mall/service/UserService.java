package com.catike_mall.service;

import org.springframework.web.multipart.MultipartFile;

import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.domain.enums.RegistResult;

/**
 * @disc User Login Service interface
 * 
 * @author Ma Xuefeng
 * @date 2017Äê5ÔÂ28ÈÕ
 * @version v1.0.0
 */

public interface UserService {

	/*
	 * User Login Service
	 */
	int login(UserInfo userInfo);

	/*
	 * Add User Information Service
	 */
	RegistResult addUser(UserInfo userInfo, MultipartFile imgFile);

	/*
	 * Get User Information Service
	 */
	UserInfo getUserInfo(Integer userPkId);

	/*
	 * Update User Information Service
	 */
	void updateUserInfo(UserInfo userInfo, MultipartFile imgFile);

	/*
	 * Get User Information By Username
	 */
	UserInfo getUserInfoByUsername(String username);

	/*
	 * Change Current User Password
	 * @Param currentUserInfo : Current User
	 * @param userInfo : Page User Information 
	 */
	void changePassword(UserInfo userInfo);

	/**
	 * Check Username Is Unique
	 * 
	 * @param username
	 */
	RegistResult usernameUnique(String username);

}