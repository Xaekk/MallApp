package com.catike_mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.service.CurrentUserService;
import com.catike_mall.service.UserService;

/**
 * @disc Current User Service Implement
 * 
 * @author Ma Xuefeng
 * @date 2017Äê6ÔÂ16ÈÕ
 * @version v1.0.0
 */
@Service("currentUserService")
@Transactional
public class CurrentUserServiceImpl implements CurrentUserService {

	private UserService userService;

	@Autowired
	public CurrentUserServiceImpl(UserService userService) {
		this.userService = userService;

	}

	public UserInfo getCurrentUser() {
		
		if(SecurityContextHolder.getContext().getAuthentication() != null){
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
			if (principal instanceof UserDetails) {
				UserDetails userDetails = (UserDetails) principal;
	
				UserInfo userInfo = userService.getUserInfoByUsername(userDetails.getUsername());
	
				if (userInfo != null) {
					return userInfo;
				}
			}
		}
		return null;
	}

}
