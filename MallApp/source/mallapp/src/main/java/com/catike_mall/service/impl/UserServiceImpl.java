package com.catike_mall.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.catike_mall.dao.normal.UserInfoMapper;
import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.domain.entity.normal.UserInfoExample;
import com.catike_mall.domain.enums.RegistResult;
import com.catike_mall.service.UserService;
import com.catike_mall.service.VerService;
import com.catike_mall.util.AuthorityOperator;
import com.catike_mall.util.ImgDir;

/**
 * @disc User Login Service implement
 * 
 * @author Ma Xuefeng
 * @date 2017Äê5ÔÂ28ÈÕ
 * @version v1.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private UserInfoMapper userInfoMapper;
	private VerService verService;

	@Autowired
	public UserServiceImpl(UserInfoMapper userInfoMapper, VerService verService) {

		this.userInfoMapper = userInfoMapper;
		this.verService = verService;
	}

	public int login(UserInfo userInfo) {

		UserInfoExample userInfoExample = new UserInfoExample();
		UserInfoExample.Criteria userInfoExampleCriteria = userInfoExample.createCriteria();
		userInfoExampleCriteria.andUsernameEqualTo(userInfo.getUsername());

		List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);

		for (int i = 0; i < userInfoList.size(); i++) {
			if (userInfo.getPassword().equals(userInfoList.get(i).getPassword())) {
				return userInfoList.get(i).getPkId();
			}
		}
		return -1;
	}

	public RegistResult addUser(UserInfo userInfo, MultipartFile imgFile) {

		upLoadImage(userInfo, imgFile);

		RegistResult registResult = usernameUnique(userInfo.getUsername());

		if (registResult == RegistResult.USERNAME_EXIST) {
			return registResult;
		} else {
			AuthorityOperator.setNewUserAuthority(userInfo);

			verService.entityCreate(userInfo);
			userInfoMapper.insertSelective(userInfo);

			return RegistResult.SUCCESS;
		}
	}

	public RegistResult usernameUnique(String username) {
		UserInfoExample userInfoExample = new UserInfoExample();
		UserInfoExample.Criteria userInfoExampleCriteria = userInfoExample.createCriteria();
		userInfoExampleCriteria.andUsernameEqualTo(username);

		List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);

		if (userInfoList.size() > 0) {

			return RegistResult.USERNAME_EXIST;
		} else {

			return RegistResult.USERNAME_NOT_EXIST;
		}
	}

	public UserInfo getUserInfo(Integer userPkId) {

		UserInfoExample userInfoExample = new UserInfoExample();

		UserInfoExample.Criteria userInfoExampleCriteria = userInfoExample.createCriteria();
		userInfoExampleCriteria.andPkIdEqualTo(userPkId);

		List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);

		if (userInfoList.size() < 1) {
			return null;
		} else {
			return userInfoList.get(0);
		}
	}

	public void updateUserInfo(UserInfo userInfo, MultipartFile imgFile) {

		if(verService.entityUpdate(userInfo)){
			upLoadImage(userInfo, imgFile);
	
			UserInfoExample userInfoExample = new UserInfoExample();
	
			UserInfoExample.Criteria userInfoExampleCriteria = userInfoExample.createCriteria();
	
			userInfoExampleCriteria.andPkIdEqualTo(userInfo.getPkId());
	
			userInfoMapper.updateByExampleSelective(userInfo, userInfoExample);
		}
	}

	public UserInfo getUserInfoByUsername(String username) {

		UserInfoExample userInfoExample = new UserInfoExample();

		UserInfoExample.Criteria userInfoExampleCriteria = userInfoExample.createCriteria();
		userInfoExampleCriteria.andUsernameEqualTo(username);

		List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);

		if (userInfoList.size() < 1) {
			return null;
		} else {
			return userInfoList.get(0);
		}
	}

	public void changePassword(UserInfo userInfo) {
		UserInfo currentUserInfo = getCurrentUser();

		UserInfo changeUserInfo = new UserInfo();
		changeUserInfo.setPkId(currentUserInfo.getPkId());
		changeUserInfo.setPassword(userInfo.getPassword());
		changeUserInfo.setVer(userInfo.getVer());

		if(verService.entityUpdate(changeUserInfo)){
			UserInfoExample userInfoExample = new UserInfoExample();
	
			UserInfoExample.Criteria userInfoExampleCriteria = userInfoExample.createCriteria();
			userInfoExampleCriteria.andPkIdEqualTo(currentUserInfo.getPkId());
	
			userInfoMapper.updateByExampleSelective(changeUserInfo, userInfoExample);
		}
	}

	/*
	 * Upload Image Function
	 */
	private void upLoadImage(UserInfo userInfo, MultipartFile imgFile) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		if (imgFile != null && !imgFile.isEmpty()) {
			String path = request.getSession().getServletContext().getRealPath(ImgDir.getUserDir());

			if (getCurrentUser() != null && getCurrentUser().getImageDir() != null) {
				String pathOld = request.getSession().getServletContext().getRealPath(getCurrentUser().getImageDir());
				File file = new File(pathOld);
				if (file.exists() && file.isFile()) {
					file.delete();
				}
			}

			long date = (new Date()).getTime();
			int random = (new Random()).nextInt(1000);
			String fileName = date + "" + random + ".jpg";
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// save
			try {
				imgFile.transferTo(targetFile);

				userInfo.setImageDir(ImgDir.getUserDir() + fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Get Current User
	 */
	private UserInfo getCurrentUser() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;

			UserInfo userInfo = getUserInfoByUsername(userDetails.getUsername());

			if (userInfo != null) {
				return userInfo;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
