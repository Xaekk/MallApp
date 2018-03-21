package com.catike_mall.catike_security;

import java.util.Date;
import java.util.List;

import com.catike_mall.domain.entity.normal.GoodsInfo;
import com.catike_mall.domain.entity.normal.StoreInfo;
import com.catike_mall.domain.entity.normal.UserInfo;

public class DataEncrypt {

	private static final Integer key = (int) (new Date()).getTime();

	public static Integer EncryptData(Integer data) {

		data = data + key;

		return data;
	}

	public static Integer Decrypt(Integer data) {

		data = data - key;

		return data;
	}

	public static void userInfoEncrypt(List<UserInfo> userInfoList) {

		for (UserInfo userInfo : userInfoList) {

			if (userInfo.getPkId() != null) {

				Integer newData = EncryptData(userInfo.getPkId());

				userInfo.setPkId(newData);
			}
		}
	}

	public static void userInfoEncrypt(UserInfo userInfo) {

		if (userInfo.getPkId() != null) {
			userInfo.setPkId(EncryptData(userInfo.getPkId()));
		}
	}

	public static void userInfoDecrypt(UserInfo userInfo) {

		if (userInfo.getPkId() != null) {
			userInfo.setPkId(Decrypt(userInfo.getPkId()));
		}
	}

	public static void storeInfoEncrypt(List<StoreInfo> storeInfoList) {

		for (StoreInfo storeInfo : storeInfoList) {

			if (storeInfo.getPkId() != null) {
				Integer newData = EncryptData(storeInfo.getPkId());

				storeInfo.setPkId(newData);
			}
		}
	}

	public static void storeInfoEncrypt(StoreInfo storeInfo) {
		if (storeInfo.getPkId() != null) {
			storeInfo.setPkId(EncryptData(storeInfo.getPkId()));
		}
	}

	public static void storeInfoDecrypt(StoreInfo storeInfo) {
		if (storeInfo.getPkId() != null) {
			storeInfo.setPkId(Decrypt(storeInfo.getPkId()));
		}
	}

	public static void goodsInfoEncrypt(List<GoodsInfo> goodsInfoList) {

		for (GoodsInfo goodsInfo : goodsInfoList) {

			if (goodsInfo.getPkId() != null) {
				Integer newData = EncryptData(goodsInfo.getPkId());

				goodsInfo.setPkId(newData);
			}
		}
	}

	public static void goodsInfoEncrypt(GoodsInfo goodsInfo) {
		if (goodsInfo.getPkId() != null) {
			goodsInfo.setPkId(EncryptData(goodsInfo.getPkId()));
		}
	}

	public static void goodsInfoDecrypt(GoodsInfo goodsInfo) {
		if (goodsInfo.getPkId() != null) {
			goodsInfo.setPkId(Decrypt(goodsInfo.getPkId()));
		}
	}
	
	public static void objEncrypt(Object obj){
		
		if(obj instanceof UserInfo){
			userInfoEncrypt((UserInfo)obj);
		}else if(obj instanceof StoreInfo){
			storeInfoEncrypt((StoreInfo)obj);
		}else if(obj instanceof GoodsInfo){
			goodsInfoEncrypt((GoodsInfo)obj);
		}else if(obj instanceof List){
			for(Object objEach : (List)obj){
				objEncrypt(objEach);
			}
		}
		
	}
	
	public static void objDecrypt(Object obj){
		
		if(obj instanceof UserInfo){
			userInfoDecrypt((UserInfo)obj);
		}else if(obj instanceof StoreInfo){
			storeInfoDecrypt((StoreInfo)obj);
		}else if(obj instanceof GoodsInfo){
			goodsInfoDecrypt((GoodsInfo)obj);
		}else if(obj instanceof List){
			for(Object objEach : (List)obj){
				objDecrypt(objEach);
			}
		}

	}
}
