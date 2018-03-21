package com.catike_mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.catike_mall.domain.entity.normal.StoreInfo;
import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.domain.entity.normal.GoodsDetailDis;
import com.catike_mall.domain.entity.normal.GoodsInfo;
import com.catike_mall.service.CurrentUserService;
import com.catike_mall.service.GoodsService;
import com.catike_mall.service.StoreService;
import com.catike_mall.util.PageInfo;
import com.catike_mall.util.ViewDir;

import com.catike_mall.catike_security.DataEncrypt;

/**
 * @disc Store Controller
 * 
 * @author Ma Xuefeng
 * @date 2017Äê5ÔÂ31ÈÕ
 * @version v1.0.0
 */
@Controller
@RequestMapping("/store")
public class StoreController {

	private StoreService storeService;
	private CurrentUserService currentUserService;
	private GoodsService goodsService;

	@Autowired
	public StoreController(StoreService storeService, CurrentUserService currentUserService,
			GoodsService goodsService) {
		this.storeService = storeService;
		this.currentUserService = currentUserService;
		this.goodsService = goodsService;
	}

	@RequestMapping(value = "/openStorepage", method = RequestMethod.GET)
	public String openNewStorePage(Model model) {
		StoreInfo storeInfo = new StoreInfo();

		DataEncrypt.objEncrypt(storeInfo);
		model.addAttribute("storeInfo", storeInfo);

		return ViewDir.getDir("store.newStorePage");
	}

	@RequestMapping(value = "/openStoreaction", method = RequestMethod.POST)
	public String openNewStore(@RequestParam(value="imgFile", required = false) MultipartFile imgFile, StoreInfo storeInfo, Model model) {
		DataEncrypt.objDecrypt(storeInfo);
		
		if(storeInfo.getStoreName() == null || "".equals(storeInfo.getStoreName()) || (storeInfo.getDiscription() != null && storeInfo.getDiscription().length() > 512)){
			return ViewDir.getDir("store.newStorePage");
		}else{
			UserInfo userInfo = currentUserService.getCurrentUser();
	
			storeService.addStore(storeInfo, imgFile,userInfo);
	
			storeInfo = storeService.getStoreInfoByUserInfo(userInfo);
	
			DataEncrypt.objEncrypt(storeInfo);
			model.addAttribute("storeInfo", storeInfo);
	
			return ViewDir.getDir("store.storeInfo");
		}
	}

	@RequestMapping(value = "/deletestore", method = RequestMethod.GET)
	public String deleteStore(@RequestParam("storePkId") Integer storePkId) {
		storePkId = DataEncrypt.Decrypt(storePkId);
		
		storeService.deleteStore(storePkId);

		return ViewDir.getDir("user.userInfo");
	}

	@RequestMapping(value = "/editStoreAction", method = RequestMethod.POST)
	public String editStoreInfo(@RequestParam(value="imgFile", required = false) MultipartFile imgFile, StoreInfo storeInfo, Model model) {
		DataEncrypt.objDecrypt(storeInfo);
		
		if(storeInfo.getStoreName() == null || "".equals(storeInfo.getStoreName()) || (storeInfo.getDiscription() != null && storeInfo.getDiscription().length() > 512)){
			return ViewDir.getDir("store.newStorePage");
		}else{
			UserInfo userInfo = currentUserService.getCurrentUser();
	
			storeService.updateStoreInfo(storeInfo, imgFile, userInfo);
	
			storeInfo = storeService.getStoreInfoByUserInfo(userInfo);
	
			DataEncrypt.objEncrypt(storeInfo);
			model.addAttribute("storeInfo", storeInfo);
	
			return ViewDir.getDir("store.storeInfo");
		}
	}

	@RequestMapping(value = "/storeinfo", method = RequestMethod.GET)
	public String storeInfo(Model model) {

		UserInfo userInfo = currentUserService.getCurrentUser();

		StoreInfo storeInfo = storeService.getStoreInfoByUserInfo(userInfo);

		DataEncrypt.objEncrypt(storeInfo);
		model.addAttribute("storeInfo", storeInfo);

		return ViewDir.getDir("store.storeInfo");
	}

	@RequestMapping(value = "/myStoreAccount", method = RequestMethod.GET)
	public String myStoreAccount(Model model) {

		UserInfo userInfo = currentUserService.getCurrentUser();

		StoreInfo storeInfo = storeService.getStoreInfoByUserInfo(userInfo);

		if (storeInfo == null) {
			return ViewDir.getDir("store.Account.notHasStore");
		} else {
			DataEncrypt.objEncrypt(storeInfo);
			model.addAttribute("storeInfo", storeInfo);
			return ViewDir.getDir("store.Account.hasStore");
		}
	}

	@RequestMapping(value = "/onSaleInStore", method = RequestMethod.GET)
	public String onSaleInStore(@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", required = false) Integer pageSize, Model model) {

		UserInfo userInfo = currentUserService.getCurrentUser();
		StoreInfo storeInfo = storeService.getStoreInfoByUserInfo(userInfo);

		PageInfo pageInfo = PageInfo.newPageInfo(pageNum, pageSize, model);
		List<GoodsInfo> goodsInfoList = goodsService.getEnableGoodsInfoByStoreInfo(storeInfo, pageInfo);

		DataEncrypt.objEncrypt(goodsInfoList);
		model.addAttribute("goodsInfoList", goodsInfoList);
		
		model.addAttribute("com_url", "store/onSaleInStore");

		return ViewDir.getDir("store.goodsOnSale");
	}

	@RequestMapping(value = "/disenableInStore", method = RequestMethod.GET)
	public String disenableInStore(@RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", required = false) Integer pageSize, Model model) {

		UserInfo userInfo = currentUserService.getCurrentUser();
		StoreInfo storeInfo = storeService.getStoreInfoByUserInfo(userInfo);

		PageInfo pageInfo = PageInfo.newPageInfo(pageNum, pageSize, model);
		List<GoodsInfo> goodsInfoList = goodsService.getDisenableGoodsInfoByStoreInfo(storeInfo, pageInfo);

		DataEncrypt.objEncrypt(goodsInfoList);
		model.addAttribute("goodsInfoList", goodsInfoList);
		
		model.addAttribute("com_url", "store/disenableInStore");

		return ViewDir.getDir("store.goodsDisenable");
	}

	@RequestMapping(value = "/newGoodsPage", method = RequestMethod.GET)
	public String newGoodsPage(Model model) {

		GoodsInfo goodsInfo = new GoodsInfo();

		DataEncrypt.objEncrypt(goodsInfo);
		model.addAttribute("goodsInfo", goodsInfo);

		return ViewDir.getDir("store.newGoods");
	}

	@RequestMapping(value = "/getGoodsInfo")
	public String getGoodsInfo(@RequestParam("goodsInfoPkId") Integer goodsInfoPkId, Model model) {
		goodsInfoPkId = DataEncrypt.Decrypt(goodsInfoPkId);
		
		if (confirmOwner(goodsInfoPkId)) {
			GoodsInfo goodsInfo = goodsService.getGoodsInfoByPkId(goodsInfoPkId);
			GoodsDetailDis goodsDetailDis = goodsService.getGoodsDetailDisByGoodsInfo(goodsInfo);

			DataEncrypt.objEncrypt(goodsInfo);
			model.addAttribute("goodsInfo", goodsInfo);
			if(goodsDetailDis !=null){
				model.addAttribute("goodsDetailDis", goodsDetailDis);
			}else{
				GoodsDetailDis GoodsDetailDisTemp = new GoodsDetailDis();
				GoodsDetailDisTemp.setDiscribe("");
				model.addAttribute("goodsDetailDis", GoodsDetailDisTemp);
			}

			return ViewDir.getDir("goods.goodsOfOwner");
		} else {
			return ViewDir.getDir("base.homePage");
		}
	}

	/*
	 * to Confirm the Owner of the Goods
	 */
	private boolean confirmOwner(Integer goodsInfoPkId) {
		UserInfo userInfo = currentUserService.getCurrentUser();
		StoreInfo storeInfo = storeService.getStoreInfoByUserInfo(userInfo);

		boolean present = false;
		PageInfo pageInfo = PageInfo.newPageInfo(false);
		List<GoodsInfo> enableGoodsInfoList = goodsService.getEnableGoodsInfoByStoreInfo(storeInfo, pageInfo);
		for (GoodsInfo enableGoodsInfo : enableGoodsInfoList) {
			if (enableGoodsInfo.getPkId() == goodsInfoPkId) {
				present = true;
				break;
			}
		}

		if (!present) {
			List<GoodsInfo> disenableGoodsInfoList = goodsService.getDisenableGoodsInfoByStoreInfo(storeInfo, pageInfo);
			for (GoodsInfo disenableGoodsInfo : disenableGoodsInfoList) {
				if (disenableGoodsInfo.getPkId() == goodsInfoPkId) {
					present = true;
					break;
				}
			}
		}
		return present;
	}
}
