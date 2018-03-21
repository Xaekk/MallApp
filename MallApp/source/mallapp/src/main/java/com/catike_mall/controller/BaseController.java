package com.catike_mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.catike_mall.catike_security.DataEncrypt;
import com.catike_mall.domain.entity.normal.GoodsDetailDis;
import com.catike_mall.domain.entity.normal.GoodsInfo;
import com.catike_mall.domain.entity.normal.StoreInfo;
import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.service.AdvertiseService;
import com.catike_mall.service.GoodsService;
import com.catike_mall.service.StoreService;
import com.catike_mall.service.UserService;
import com.catike_mall.util.PageInfo;
import com.catike_mall.util.ViewDir;

/**
 * @disc Base Controller
 * 
 * @author Ma Xuefeng
 * @date 2017Äê5ÔÂ27ÈÕ
 * @version v1.0.0
 */
@Controller
@RequestMapping(value = "/base")
public class BaseController {

	private GoodsService goodsService;
	private StoreService storeService;
	private UserService userService;
	private AdvertiseService advertiseService;

	@Autowired
	BaseController(GoodsService goodsService, StoreService storeService, UserService userService,
			AdvertiseService advertiseService) {
		this.goodsService = goodsService;
		this.storeService = storeService;
		this.userService = userService;
		this.advertiseService = advertiseService;
	}

	/**
	 * Home Page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String homepage(@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", required = false) Integer pageSize, Model model) {

		PageInfo pageInfo = PageInfo.newPageInfo(pageNum, pageSize, model);
		List<GoodsInfo> goodsInfoList = goodsService.getAllGoodsInfo(pageInfo);

		DataEncrypt.objEncrypt(goodsInfoList);
		model.addAttribute("goodsInfoList", goodsInfoList);

		model.addAttribute("com_url", "base/homepage");
		
		advertiseService.addAllAdvertiseService(model);

		return ViewDir.getDir("base.homePage");
	}

	@RequestMapping(value = "forgetpw")
	public String forgetpw() {
		return ViewDir.getDir("base.forgetpw");
	}

	/**
	 * Get GoodsInfo Detail By GoodsInfo PkId
	 * 
	 * @param goodsInfoPkId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getGoodsInfo")
	public String goodsInfo(@RequestParam("goodsInfoPkId") int goodsInfoPkId, Model model) {

		goodsInfoPkId = DataEncrypt.Decrypt(goodsInfoPkId);

		GoodsInfo goodsInfo = goodsService.getGoodsInfoByPkId(goodsInfoPkId);
		StoreInfo storeInfo = storeService.getStoreInfoByPkId(goodsInfo.getStorePkid());
		UserInfo sallerInfo = userService.getUserInfo(storeInfo.getOwnerPkid());

		GoodsDetailDis goodsDetailDis = goodsService.getGoodsDetailDisByGoodsInfo(goodsInfo);
		if (goodsDetailDis != null) {
			model.addAttribute("goodsDetailDis", goodsDetailDis);
		} else {
			GoodsDetailDis GoodsDetailDisTemp = new GoodsDetailDis();
			GoodsDetailDisTemp.setDiscribe("");
			model.addAttribute("goodsDetailDis", GoodsDetailDisTemp);
		}

		DataEncrypt.objEncrypt(goodsInfo);
		DataEncrypt.objEncrypt(storeInfo);
		DataEncrypt.objEncrypt(sallerInfo);
		model.addAttribute("goodsInfo", goodsInfo);
		model.addAttribute("storeInfo", storeInfo);
		model.addAttribute("sallerInfo", sallerInfo);

		return ViewDir.getDir("base.goodsInfo");
	}
	
	/**
	 * Get GoodsInfo Detail By GoodsInfo PkId For Ajax
	 * 
	 * @param goodsInfoPkId
	 * @param model
	 * @return JSON
	 */
	@RequestMapping(value = "/getGoodsInfoForAjax")
	public @ResponseBody GoodsInfo goodsInfoForAjax(@RequestParam("goodsInfoPkId") int goodsInfoPkId) {
		
		goodsInfoPkId = DataEncrypt.Decrypt(goodsInfoPkId);
		
		GoodsInfo goodsInfo = goodsService.getGoodsInfoByPkId(goodsInfoPkId);
		
		DataEncrypt.objEncrypt(goodsInfo);
		
		return goodsInfo;
	}

	/**
	 * Search GoodsInfo By Fuzzy Keywords
	 * 
	 * @param keywords
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/goodsSearch")
	public String goodsSearch(@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam("keywords") String keywords, Model model) {

		PageInfo pageInfo = PageInfo.newPageInfo(pageNum, pageSize, model);
		List<GoodsInfo> goodsInfoList = goodsService.getGoodsInfoListByKeywords(keywords, pageInfo);

		DataEncrypt.objEncrypt(goodsInfoList);
		model.addAttribute("goodsInfoList", goodsInfoList);

		model.addAttribute("srchStat", "Goods");
		model.addAttribute("keyWords", keywords);

		model.addAttribute("com_url", "base/goodsSearch");

		return ViewDir.getDir("search.goodsSearch");
	}

	/**
	 * Search StoreInfo By Fuzzy Keywords
	 * 
	 * @param keywords
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/storeSearch")
	public String storeSearch(@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam("keywords") String keywords, Model model) {

		PageInfo pageInfo = PageInfo.newPageInfo(pageNum, pageSize, model);
		List<StoreInfo> storeInfoList = storeService.getStoreInfoListByKeywords(keywords, pageInfo);

		DataEncrypt.objEncrypt(storeInfoList);
		model.addAttribute("storeInfoList", storeInfoList);

		model.addAttribute("srchStat", "Store");
		model.addAttribute("keyWords", keywords);

		model.addAttribute("com_url", "base/storeSearch");

		return ViewDir.getDir("search.storeSearch");
	}

	/**
	 * Get StoreInfo by PkId
	 * 
	 * @param storeInfoPkId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getStoreInfo")
	public String getStoreInfoByPkId(@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam("storeInfoPkId") int storeInfoPkId, Model model) {
		
		storeInfoPkId = DataEncrypt.Decrypt(storeInfoPkId);

		StoreInfo storeInfo = storeService.getStoreInfoByPkId(storeInfoPkId);
		UserInfo userInfo = userService.getUserInfo(storeInfo.getOwnerPkid());

		PageInfo pageInfo = PageInfo.newPageInfo(pageNum, pageSize, model);
		List<GoodsInfo> goodsInfoList = storeService.getGoodsInfoListByStoreInfoPkId(storeInfoPkId, pageInfo);

		DataEncrypt.objEncrypt(storeInfo);
		DataEncrypt.objEncrypt(userInfo);
		DataEncrypt.objEncrypt(goodsInfoList);
		model.addAttribute("storeInfo", storeInfo);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("goodsInfoList", goodsInfoList);

		model.addAttribute("com_url", "base/getStoreInfo");

		return ViewDir.getDir("base.storeInfo");
	}
}
