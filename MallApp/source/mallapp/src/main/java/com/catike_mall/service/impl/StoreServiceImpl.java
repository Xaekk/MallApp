package com.catike_mall.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.catike_mall.dao.normal.GoodsInfoMapper;
import com.catike_mall.dao.normal.StoreInfoMapper;
import com.catike_mall.domain.entity.normal.GoodsInfo;
import com.catike_mall.domain.entity.normal.GoodsInfoExample;
import com.catike_mall.domain.entity.normal.StoreInfo;
import com.catike_mall.domain.entity.normal.StoreInfoExample;
import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.service.StoreService;
import com.catike_mall.service.VerService;
import com.catike_mall.util.ImgDir;
import com.catike_mall.util.PageInfo;

/**
 * @disc Store Service Implement
 * 
 * @author Ma Xuefeng
 * @date 2017Äê5ÔÂ31ÈÕ
 * @version v1.0.0
 */
@Service("storeService")
@Transactional
public class StoreServiceImpl implements StoreService {

	private StoreInfoMapper storeInfoMapper;
	private GoodsInfoMapper goodsInfoMapper;
	private VerService verService;

	@Autowired
	public StoreServiceImpl(StoreInfoMapper storeInfoMapper, GoodsInfoMapper goodsInfoMapper, VerService verService) {
		this.storeInfoMapper = storeInfoMapper;
		this.goodsInfoMapper = goodsInfoMapper;
		this.verService = verService;
	}

	public int addStore(StoreInfo storeInfo, MultipartFile imgFile, UserInfo userInfo) {

		StoreInfo storeInfoDB = getStoreInfoByUserInfo(userInfo);

		if (storeInfoDB == null) {

			upLoadImage(storeInfo, imgFile);

			storeInfo.setPkId(null);

			storeInfo.setOwnerPkid(userInfo.getPkId());

			verService.entityCreate(storeInfo);
			storeInfoMapper.insertSelective(storeInfo);

			return storeInfo.getPkId();
		} else {
			return storeInfoDB.getPkId();
		}

	}

	public void deleteStore(Integer storePkId) {
		// TODO Auto-generated method stub

	}

	public StoreInfo getStoreInfoByPkId(Integer storePkId) {

		StoreInfoExample storeInfoExample = new StoreInfoExample();
		StoreInfoExample.Criteria storeInfoExampleCriteria = storeInfoExample.createCriteria();

		storeInfoExampleCriteria.andPkIdEqualTo(storePkId);

		List<StoreInfo> storeInfoList = storeInfoMapper.selectByExample(storeInfoExample);

		if (storeInfoList.size() > 0) {
			return storeInfoList.get(0);
		} else {
			return null;
		}
	}

	public StoreInfo getStoreInfoByUserInfo(UserInfo userInfo) {

		StoreInfoExample storeInfoExample = new StoreInfoExample();
		StoreInfoExample.Criteria storeInfoExampleCriteria = storeInfoExample.createCriteria();

		storeInfoExampleCriteria.andOwnerPkidEqualTo(userInfo.getPkId());

		List<StoreInfo> storeInfoList = storeInfoMapper.selectByExample(storeInfoExample);

		if (storeInfoList.size() > 0) {
			return storeInfoList.get(0);
		} else {
			return null;
		}
	}

	public int updateStoreInfo(StoreInfo storeInfo, MultipartFile imgFile, UserInfo userInfo) {

			StoreInfo storeInfoDB = getStoreInfoByUserInfo(userInfo);
	
			StoreInfoExample storeInfoExample = new StoreInfoExample();
			StoreInfoExample.Criteria storeInfoExampleCriteria = storeInfoExample.createCriteria();
	
			storeInfoExampleCriteria.andPkIdEqualTo(storeInfoDB.getPkId());
	
			upLoadImage(storeInfoDB, imgFile);
	
			storeInfoDB.setStoreName(storeInfo.getStoreName());
			storeInfoDB.setAddress(storeInfo.getAddress());
			storeInfoDB.setDiscription(storeInfo.getDiscription());
			storeInfoDB.setVer(storeInfo.getVer());
	
			int storePkId = -1;
			if(verService.entityUpdate(storeInfoDB)){
				storeInfoDB.setPkId(null);
				storePkId = storeInfoMapper.updateByExampleSelective(storeInfoDB, storeInfoExample);
			}
			
			if(storePkId == -1){
				throw new RuntimeException();
			}
				
			return storePkId;
	}

	/*
	 * Upload Image Function
	 */
	private void upLoadImage(StoreInfo storeInfo, MultipartFile imgFile) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		if (imgFile != null && !imgFile.isEmpty()) {
			String path = request.getSession().getServletContext().getRealPath(ImgDir.getStoreDir());

			if (storeInfo != null && storeInfo.getImageDir() != null) {
				String pathOld = request.getSession().getServletContext().getRealPath(storeInfo.getImageDir());
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

				storeInfo.setImageDir(ImgDir.getStoreDir() + fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<StoreInfo> getStoreInfoListByKeywords(String keywords, PageInfo pageInfo) {

		StoreInfoExample storeInfoExample = new StoreInfoExample();
		StoreInfoExample.Criteria storeInfoExampleCriteria = storeInfoExample.createCriteria();

		storeInfoExampleCriteria.andStoreNameLike("%" + keywords + "%");

		List<StoreInfo> storeInfoList = pageInfo.selectByExample(storeInfoMapper, storeInfoExample);

		return storeInfoList;
	}

	public List<GoodsInfo> getGoodsInfoListByStoreInfoPkId(int storeInfoPkId, PageInfo pageInfo) {

		GoodsInfoExample goodsInfoExample = new GoodsInfoExample();
		GoodsInfoExample.Criteria goodsInfoExampleCriteria = goodsInfoExample.createCriteria();

		goodsInfoExampleCriteria.andStorePkidEqualTo(storeInfoPkId);

		List<GoodsInfo> goodsInfoList = pageInfo.selectByExample(goodsInfoMapper, goodsInfoExample);

		return goodsInfoList;
	}
}
