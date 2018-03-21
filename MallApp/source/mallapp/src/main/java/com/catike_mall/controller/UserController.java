package com.catike_mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.catike_mall.catike_security.DataEncrypt;
import com.catike_mall.domain.entity.normal.StoreInfo;
import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.domain.enums.RegistResult;
import com.catike_mall.service.AdvertiseService;
import com.catike_mall.service.CurrentUserService;
import com.catike_mall.service.StoreService;
import com.catike_mall.service.UserService;
import com.catike_mall.util.ViewDir;

/**
 * @disc User Related Operartions
 * 
 * @author Ma Xuefeng
 * @date 2017Äê5ÔÂ27ÈÕ
 * @version v1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	private CurrentUserService currentUserService;
	private StoreService storeService;
	private AdvertiseService advertiseService;

	@Autowired
	public UserController(UserService userService, CurrentUserService currentUserService, StoreService storeService, AdvertiseService advertiseService) {
		this.userService = userService;
		this.currentUserService = currentUserService;
		this.storeService = storeService;
		this.advertiseService = advertiseService;
	}

	/*
	 * Login Page Display
	 */
	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String login_page(Model model) {

		UserInfo userInfo = new UserInfo();
		DataEncrypt.objEncrypt(userInfo);
		model.addAttribute("userInfo", userInfo);

		return ViewDir.getDir("user.login");
	}

	/*
	 * Show Account Information
	 */
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model) {

		UserInfo userInfo = currentUserService.getCurrentUser();
		DataEncrypt.objEncrypt(userInfo);
		model.addAttribute("userInfo", userInfo);

		return ViewDir.getDir("user.account");
	}

	/*
	 * Show My_Account on PageHead,response AJAX Not Security
	 */
	@RequestMapping(value = "/myAccount", method = RequestMethod.GET)
	public String myAccount(Model model) {

		UserInfo userInfo = currentUserService.getCurrentUser();

		if (userInfo != null) {
			DataEncrypt.objEncrypt(userInfo);
			model.addAttribute("userInfo", userInfo);

			return ViewDir.getDir("user.hasLogin");
		} else {
			return ViewDir.getDir("user.notLogin");
		}
	}

	/*
	 * Show My_Account on PageHead,response AJAX Not Security
	 */
	@RequestMapping(value = "/myStore", method = RequestMethod.GET)
	public String myStore(Model model) {

		UserInfo userInfo = currentUserService.getCurrentUser();

		if (userInfo != null) {
			StoreInfo storeInfo = storeService.getStoreInfoByUserInfo(userInfo);

			if (storeInfo != null) {
				DataEncrypt.objEncrypt(storeInfo);
				model.addAttribute("storeInfo", storeInfo);

				return ViewDir.getDir("user.hasStore");
			} else {
				return ViewDir.getDir("user.notHasStore");
			}
		} else {
			advertiseService.addAllAdvertiseService(model);
			return ViewDir.getDir("user.adNotLogin");
		}
	}

	/*
	 * Regist Page Display
	 */
	@RequestMapping(value = "/registpage", method = RequestMethod.GET)
	public String regist_page(Model model) {

		UserInfo userInfo = new UserInfo();
		DataEncrypt.objEncrypt(userInfo);
		model.addAttribute("userInfo", userInfo);

		return ViewDir.getDir("user.register");
	}

	/*
	 * Regist Action
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist_action(@RequestParam(value = "imgFile", required = false) MultipartFile imgFile,
			@RequestParam("confirm") String confirm, UserInfo userInfo, Model model) {
		DataEncrypt.objDecrypt(userInfo);

		if (userInfo.getPassword() == null || "".equals(userInfo.getPassword()) || confirm == null || "".equals(confirm)
				|| !userInfo.getPassword().equals(confirm)) {
			return ViewDir.getDir("user.register");
		} else {

			RegistResult registResult = userService.addUser(userInfo, imgFile);

			if (registResult == RegistResult.SUCCESS) {
				return ViewDir.getDir("user.registSuccess");
			} else {
				return ViewDir.getDir("user.register");
			}
		}
	}

	/*
	 * Rigist Username Unique
	 */
	@RequestMapping("/usernameUnique")
	public @ResponseBody boolean usernameUnique(@RequestParam("username") String username) {

		RegistResult registResult = userService.usernameUnique(username);

		if (registResult == RegistResult.USERNAME_EXIST) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * User Information Page Display
	 */
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public String userInfo(Model model) {

		UserInfo userInfo = currentUserService.getCurrentUser();

		DataEncrypt.objEncrypt(userInfo);
		model.addAttribute("userInfo", userInfo);

		return ViewDir.getDir("user.userInfo");
	}

	/*
	 * User Information Edit Action
	 */
	@RequestMapping(value = "/userinfoedit", method = RequestMethod.POST)
	public String updateUserInfoAction(@RequestParam(value = "imgFile", required = false) MultipartFile imgFile,
			UserInfo userInfo, Model model) {
		DataEncrypt.objDecrypt(userInfo);

		userInfo.setPkId(currentUserService.getCurrentUser().getPkId());

		userService.updateUserInfo(userInfo, imgFile);

		userInfo = currentUserService.getCurrentUser();

		DataEncrypt.objEncrypt(userInfo);
		model.addAttribute("userInfo", userInfo);

		return ViewDir.getDir("user.userInfo");
	}

	/*
	 * Change Password Page
	 */
	@RequestMapping(value = "/changePasswordPage", method = RequestMethod.GET)
	public String changePasswordPage(Model model) {

		UserInfo currentUserInfo = currentUserService.getCurrentUser();

		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(currentUserInfo.getUsername());
		userInfo.setVer(currentUserInfo.getVer());

		DataEncrypt.objEncrypt(userInfo);
		model.addAttribute("userInfo", userInfo);

		return ViewDir.getDir("user.changePassword");
	}

	/*
	 * Change Password Action
	 */
	@RequestMapping(value = "/changePasswordAction", method = RequestMethod.POST)
	public String changePasswordAction(@RequestParam String oldPassword, @RequestParam String password,
			@RequestParam String confirmPassword, UserInfo userInfo, Model model) {
		DataEncrypt.objDecrypt(userInfo);

		UserInfo currentUserInfo = currentUserService.getCurrentUser();

		if (!currentUserInfo.getPassword().equals(oldPassword) || password == null || "".equals(password)
				|| confirmPassword == null || "".equals(confirmPassword) || !password.equals(confirmPassword)) {

			userInfo = new UserInfo();
			userInfo.setUsername(currentUserInfo.getUsername());
			userInfo.setVer(currentUserInfo.getVer());

			DataEncrypt.objEncrypt(userInfo);
			model.addAttribute("userInfo", userInfo);

			return ViewDir.getDir("user.changePassword");
		} else {

			userInfo.setPassword(password);

			userService.changePassword(userInfo);

			userInfo = currentUserService.getCurrentUser();
			DataEncrypt.objEncrypt(userInfo);
			model.addAttribute("userInfo", userInfo);

			return ViewDir.getDir("user.account");
		}
	}

}
