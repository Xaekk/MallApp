package com.catike_mall.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.catike_mall.domain.entity.normal.GoodsDetailDis;
import com.catike_mall.domain.entity.normal.GoodsInfo;
import com.catike_mall.domain.entity.normal.StoreInfo;
import com.catike_mall.util.PageInfo;

/**
 * @disc Goods Service
 * 
 * @author Ma Xuefeng
 * @date 2017Äê5ÔÂ31ÈÕ
 * @version v1.0.0
 */

public interface GoodsService {

	/**
	 * Add Goods Information
	 * 
	 * @Param GoodsInfo , String discription , StoreInfo
	 */
	GoodsInfo addGoodsInfo(GoodsInfo goodsInfo, MultipartFile imgFile, String discription, StoreInfo storeInfo);

	/**
	 * Delete Goods Information By PkId
	 */
	GoodsInfo deleteGoodsInfo(Integer goodsInfoPkId, Integer ver);

	/**
	 * Search Goods Information By PkId
	 */
	GoodsInfo getGoodsInfoByPkId(Integer goodsInfoPkId);

	/**
	 * Edit Goods Information By PkId
	 */
	GoodsInfo updateGoodsInfo(GoodsInfo goodsInfo, MultipartFile imgFile, String discription, Integer disVer);

	/**
	 * Get Enable Goods Information By Store Information
	 */
	List<GoodsInfo> getEnableGoodsInfoByStoreInfo(StoreInfo storeInfo, PageInfo pageInfo);

	/**
	 * Get Disenable Goods Information By Store Information
	 */
	List<GoodsInfo> getDisenableGoodsInfoByStoreInfo(StoreInfo storeInfo, PageInfo pageInfo);

	/**
	 * Get Goods Detail Discription By Goods Information
	 * 
	 * @param goodsInfo
	 * @return GoodsDetailDis
	 */
	GoodsDetailDis getGoodsDetailDisByGoodsInfo(GoodsInfo goodsInfo);

	/**
	 * Show All Goods Information
	 * 
	 * @return List<GoodsInfo>
	 */
	List<GoodsInfo> getAllGoodsInfo(PageInfo pageInfo);

	/**
	 * Get GoodsInfo ListBy Keywords
	 * 
	 * @param keywords
	 * @return
	 */
	List<GoodsInfo> getGoodsInfoListByKeywords(String keywords, PageInfo pageInfo);
	
}