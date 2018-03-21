package com.catike_mall.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.catike_mall.domain.entity.normal.GoodsInfo;
import com.catike_mall.domain.entity.normal.StoreInfo;
import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.util.PageInfo;

/**
 * @disc
 * 
 * @author Ma Xuefeng
 * @date 2017Äê5ÔÂ31ÈÕ
 * @version v1.0.0
 */

public interface StoreService {

	/**
	 * Open A New Store
	 * @param storeInfo
	 * @param imgFile 
	 * @param userInfo 
	 */
	int addStore(StoreInfo storeInfo, MultipartFile imgFile, UserInfo userInfo);

	/**
	 * Delete A Store By Store PK_ID
	 */
	void deleteStore(Integer storePkId);

	/**
	 * GET Store Information By PK_ID
	 */
	StoreInfo getStoreInfoByPkId(Integer storePkId);

	/**
	 * Get Store Information By User Information
	 * 
	 * @param userInfo : User Information
	 */
	StoreInfo getStoreInfoByUserInfo(UserInfo userInfo);

	/**
	 * Update Store Information
	 * 
	 * @param storeInfo
	 * @param imgFile 
	 * @param userInfo
	 * @return Current Store PkId
	 */
	int updateStoreInfo(StoreInfo storeInfo, MultipartFile imgFile, UserInfo userInfo);

	/**
	 * Get StoreInfoList By Keywords
	 * 
	 * @param keywords
	 * @return List<StoreInfo>
	 */
	List<StoreInfo> getStoreInfoListByKeywords(String keywords, PageInfo pageInfo);

	/**
	 * Get GoodsInfo List By StoreInfo PkId
	 * 
	 * @param storeInfoPkId
	 * @return
	 */
	List<GoodsInfo> getGoodsInfoListByStoreInfoPkId(int storeInfoPkId, PageInfo pageInfo);
}