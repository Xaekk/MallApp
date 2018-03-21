package com.catike_mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.catike_mall.domain.entity.normal.GoodsDetailDis;
import com.catike_mall.domain.entity.normal.GoodsInfo;
import com.catike_mall.domain.entity.normal.StoreInfo;
import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.service.AdvertiseService;
import com.catike_mall.service.CurrentUserService;
import com.catike_mall.service.GoodsService;
import com.catike_mall.service.StoreService;
import com.catike_mall.util.PageInfo;
import com.catike_mall.util.ViewDir;

import com.catike_mall.catike_security.DataEncrypt;

/**
 * @disc Goods Related Operation Controller
 * 
 * @author Ma Xuefeng
 * @date 2017Äê5ÔÂ31ÈÕ
 * @version v1.0.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

	private GoodsService goodsService;
	private StoreService storeService;
	private CurrentUserService currentUserService;

	@Autowired
	public GoodsController(GoodsService goodsService, StoreService storeService,
			CurrentUserService currentUserService) {
		this.goodsService = goodsService;
		this.storeService = storeService;
		this.currentUserService = currentUserService;
	}

	@RequestMapping(value = "/addgoodsaction", method = RequestMethod.POST)
	public String addGoodsAction(@RequestParam("imgFile") MultipartFile imgFile, @RequestParam("discription") String discription, GoodsInfo goodsInfo, Model model) {
		DataEncrypt.objDecrypt(goodsInfo);
		
		UserInfo userInfo = currentUserService.getCurrentUser();

		StoreInfo storeInfo = storeService.getStoreInfoByUserInfo(userInfo);
		model.addAttribute("dicription", discription);

		if(goodsInfo.getName()!=null&&goodsInfo.getPrice()!=null){
			GoodsInfo goodsInfoDB = goodsService.addGoodsInfo(goodsInfo, imgFile, discription, storeInfo);
	
			if(goodsInfoDB !=null){
				DataEncrypt.objEncrypt(goodsInfoDB);
				model.addAttribute("goodsInfo", goodsInfoDB);
				
				if(discription !=null){
					GoodsDetailDis GoodsDetailDisTemp = new GoodsDetailDis();
					GoodsDetailDisTemp.setDiscribe(discription);
					model.addAttribute("goodsDetailDis", GoodsDetailDisTemp);
				}else{
					GoodsDetailDis GoodsDetailDisTemp = new GoodsDetailDis();
					GoodsDetailDisTemp.setDiscribe("");
					model.addAttribute("goodsDetailDis", GoodsDetailDisTemp);
				}
		
				return ViewDir.getDir("goods.goodsOfOwner");
			}else{
				return ViewDir.getDir("store.newGoods");
			}
		}else{
			return ViewDir.getDir("store.newGoods");
		}
	}

	@RequestMapping(value = "/deletegoods")
	public String deleteGoods(@RequestParam("goodsInfoPkId") Integer goodsInfoPkId,@RequestParam("ver")Integer ver, RedirectAttributes attr) {
		goodsInfoPkId = DataEncrypt.Decrypt(goodsInfoPkId);
		
		GoodsInfo goodsInfo = goodsService.deleteGoodsInfo(goodsInfoPkId, ver);
		
		if(goodsInfo.getEnable()){
			return "redirect:/store/onSaleInStore.shopping";
		}else{
			return "redirect:/store/disenableInStore.shopping";
		}
	}

	@RequestMapping(value = "/editGoodsInfoPage")
	public String editGoodsInfoPage(@RequestParam("goodsInfoPkId") Integer goodsInfoPkId, Model model) {
		goodsInfoPkId = DataEncrypt.Decrypt(goodsInfoPkId);

		if (confirmOwner(goodsInfoPkId)) {

			GoodsInfo goodsInfo = goodsService.getGoodsInfoByPkId(goodsInfoPkId);
			GoodsDetailDis goodsDetailDis = goodsService.getGoodsDetailDisByGoodsInfo(goodsInfo);

			DataEncrypt.objEncrypt(goodsInfo);
			model.addAttribute("goodsInfo", goodsInfo);
			if (goodsDetailDis != null) {
				model.addAttribute("goodsDetailDis", goodsDetailDis);
			} else {
				GoodsDetailDis GoodsDetailDisTemp = new GoodsDetailDis();
				GoodsDetailDisTemp.setDiscribe("");
				model.addAttribute("goodsDetailDis", GoodsDetailDisTemp);
			}

			return ViewDir.getDir("goods.goodsInfoEdit");
		} else {
			return ViewDir.getDir("base.homePage");
		}
	}

	@RequestMapping(value = "/editGoodsInfoAction", method = RequestMethod.POST)
	public String editGoodsInfoAction(@RequestParam("imgFile") MultipartFile imgFile, @RequestParam("discription") String discription, @RequestParam("disVer") Integer disVer, GoodsInfo goodsInfo,
			Model model) {

		DataEncrypt.objDecrypt(goodsInfo);
		
		if (confirmOwner(goodsInfo.getPkId())) {

			GoodsInfo goodsInfoDB = goodsService.updateGoodsInfo(goodsInfo, imgFile, discription, disVer);
			GoodsDetailDis goodsDetailDis = goodsService.getGoodsDetailDisByGoodsInfo(goodsInfoDB);

			DataEncrypt.objEncrypt(goodsInfoDB);
			model.addAttribute("goodsInfo", goodsInfoDB);
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
