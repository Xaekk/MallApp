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

import com.catike_mall.dao.normal.GoodsDetailDisMapper;
import com.catike_mall.dao.normal.GoodsInfoMapper;
import com.catike_mall.domain.entity.normal.GoodsDetailDis;
import com.catike_mall.domain.entity.normal.GoodsDetailDisExample;
import com.catike_mall.domain.entity.normal.GoodsInfo;
import com.catike_mall.domain.entity.normal.GoodsInfoExample;
import com.catike_mall.domain.entity.normal.StoreInfo;
import com.catike_mall.service.GoodsService;
import com.catike_mall.service.VerService;
import com.catike_mall.util.ImgDir;
import com.catike_mall.util.PageInfo;
import com.catike_mall.util.UpdateExposureList;

/**
 * @disc Goods Service Implement
 * 
 * @author Ma Xuefeng
 * @date 2017Äê5ÔÂ31ÈÕ
 * @version v1.0.0
 */
@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

	private GoodsInfoMapper goodsInfoMapper;
	private GoodsDetailDisMapper goodsDetailDisMapper;
	private VerService verService;
	private UpdateExposureList updateExposureList;

	@Autowired
	public GoodsServiceImpl(GoodsInfoMapper goodsInfoMapper, GoodsDetailDisMapper goodsDetailDisMapper,
			UpdateExposureList updateExposureList, VerService verService) {
		this.goodsInfoMapper = goodsInfoMapper;
		this.goodsDetailDisMapper = goodsDetailDisMapper;
		this.updateExposureList = updateExposureList;
		this.verService = verService;
	}

	public GoodsInfo addGoodsInfo(GoodsInfo goodsInfo, MultipartFile imgFile, String discription, StoreInfo storeInfo) {

		if(imgFile != null && !imgFile.isEmpty()){
			upLoadImage(goodsInfo, imgFile);
	
			goodsInfo.setStorePkid(storeInfo.getPkId());
	
			goodsInfo.setPkId(null);
			goodsInfo.setEnable(true);
	
			verService.entityCreate(goodsInfo);
			goodsInfoMapper.insertSelective(goodsInfo);
	
			GoodsDetailDis goodsDetailDis = new GoodsDetailDis();
	
			goodsDetailDis.setDiscribe(discription);
			goodsDetailDis.setGoodsPkId(goodsInfo.getPkId());
	
			verService.entityCreate(goodsDetailDis);
			goodsDetailDisMapper.insertSelective(goodsDetailDis);
	
			GoodsInfo goodsInfoDB = getGoodsInfoByPkId(goodsInfo.getPkId());
	
			return goodsInfoDB;
		}else{
			return null;
		}
	}

	public GoodsInfo deleteGoodsInfo(Integer goodsInfoPkId, Integer ver) {

		GoodsInfo goodsInfoDB = goodsInfoMapper.selectByPrimaryKey(goodsInfoPkId);

		GoodsInfo goodsInfoCheck = new GoodsInfo();
		goodsInfoCheck.setPkId(goodsInfoPkId);
		goodsInfoCheck.setVer(ver);

		if (verService.entityDelete(goodsInfoCheck)) {

			GoodsDetailDisExample goodsDetailDisExample = new GoodsDetailDisExample();
			GoodsDetailDisExample.Criteria goodsDetailDisExampleCriteria = goodsDetailDisExample.createCriteria();
			goodsDetailDisExampleCriteria.andGoodsPkIdEqualTo(goodsInfoPkId);
			goodsDetailDisMapper.deleteByExample(goodsDetailDisExample);

			deleteGoodsImg(goodsInfoDB);

			goodsInfoMapper.deleteByPrimaryKey(goodsInfoPkId);
		}

		return goodsInfoDB;

	}

	public GoodsInfo getGoodsInfoByPkId(Integer goodsInfoPkId) {

		GoodsInfo goodsInfo = goodsInfoMapper.selectByPrimaryKey(goodsInfoPkId);

		return goodsInfo;
	}

	public GoodsInfo updateGoodsInfo(GoodsInfo goodsInfo, MultipartFile imgFile, String discription, Integer disVer) {

		if (verService.entityUpdate(goodsInfo)) {
			upLoadImage(goodsInfo, imgFile);

			goodsInfo.setStorePkid(null);

			goodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);

			GoodsDetailDisExample goodsDetailDisExampleForSelect = new GoodsDetailDisExample();
			GoodsDetailDisExample.Criteria goodsDetailDisExampleCriteriaForSelect = goodsDetailDisExampleForSelect
					.createCriteria();
			goodsDetailDisExampleCriteriaForSelect.andGoodsPkIdEqualTo(goodsInfo.getPkId());

			List<GoodsDetailDis> goodsDetailDisForSelectList = goodsDetailDisMapper
					.selectByExample(goodsDetailDisExampleForSelect);

			if (goodsDetailDisForSelectList.size() > 0) {

				GoodsDetailDis goodsDetailDis = new GoodsDetailDis();
				goodsDetailDis.setPkId(goodsDetailDisForSelectList.get(0).getPkId());
				goodsDetailDis.setDiscribe(discription);
				goodsDetailDis.setVer(disVer);
				if (verService.entityUpdate(goodsDetailDis)) {

					goodsDetailDis.setPkId(null);

					GoodsDetailDisExample goodsDetailDisExampleForUpdate = new GoodsDetailDisExample();
					GoodsDetailDisExample.Criteria goodsDetailDisExampleCriteriaForUpdate = goodsDetailDisExampleForUpdate
							.createCriteria();
					goodsDetailDisExampleCriteriaForUpdate.andGoodsPkIdEqualTo(goodsInfo.getPkId());

					goodsDetailDisMapper.updateByExampleSelective(goodsDetailDis, goodsDetailDisExampleForUpdate);
				}
			} else {
				GoodsDetailDis goodsDetailDis = new GoodsDetailDis();
				goodsDetailDis.setGoodsPkId(goodsInfo.getPkId());
				goodsDetailDis.setDiscribe(discription);

				verService.entityCreate(goodsDetailDis);
				goodsDetailDisMapper.insertSelective(goodsDetailDis);
			}

			GoodsInfo goodsInfoDB = getGoodsInfoByPkId(goodsInfo.getPkId());

			return goodsInfoDB;
		} else {
			return goodsInfo;
		}
	}

	public List<GoodsInfo> getEnableGoodsInfoByStoreInfo(StoreInfo storeInfo, PageInfo pageInfo) {

		GoodsInfoExample getGoodsInfoExample = new GoodsInfoExample();
		GoodsInfoExample.Criteria getGoodsInfoExampleCriteria = getGoodsInfoExample.createCriteria();
		getGoodsInfoExampleCriteria.andStorePkidEqualTo(storeInfo.getPkId()).andEnableEqualTo(true);

		List<GoodsInfo> goodsInfoList = pageInfo.selectByExample(goodsInfoMapper, getGoodsInfoExample);

		return goodsInfoList;
	}

	public List<GoodsInfo> getDisenableGoodsInfoByStoreInfo(StoreInfo storeInfo, PageInfo pageInfo) {

		GoodsInfoExample getGoodsInfoExample = new GoodsInfoExample();
		GoodsInfoExample.Criteria getGoodsInfoExampleCriteria = getGoodsInfoExample.createCriteria();
		getGoodsInfoExampleCriteria.andStorePkidEqualTo(storeInfo.getPkId()).andEnableEqualTo(false);

		List<GoodsInfo> goodsInfoList = pageInfo.selectByExample(goodsInfoMapper, getGoodsInfoExample);

		return goodsInfoList;
	}

	public GoodsDetailDis getGoodsDetailDisByGoodsInfo(GoodsInfo goodsInfo) {

		GoodsDetailDisExample goodsDetailDisExample = new GoodsDetailDisExample();
		GoodsDetailDisExample.Criteria goodsDetailDisExampleCriteria = goodsDetailDisExample.createCriteria();
		goodsDetailDisExampleCriteria.andGoodsPkIdEqualTo(goodsInfo.getPkId());

		List<GoodsDetailDis> goodsDetailDisList = goodsDetailDisMapper.selectByExample(goodsDetailDisExample);

		if (goodsDetailDisList.size() > 0) {
			return goodsDetailDisList.get(0);
		} else {
			return null;
		}
	}

	public List<GoodsInfo> getAllGoodsInfo(PageInfo pageInfo) {

		GoodsInfoExample goodsInfoExample = new GoodsInfoExample();
		GoodsInfoExample.Criteria goodsInfoExampleCriteria = goodsInfoExample.createCriteria();
		goodsInfoExampleCriteria.andEnableEqualTo(true);

		sorting(goodsInfoExample);

		List<GoodsInfo> goodsInfoList = pageInfo.selectByExample(goodsInfoMapper, goodsInfoExample);

		updateExposureList.addExposureInList(goodsInfoList);

		return goodsInfoList;
	}

	/*
	 * Upload Image Function
	 */
	private void upLoadImage(GoodsInfo goodsInfo, MultipartFile imgFile) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		if (imgFile != null && !imgFile.isEmpty()) {
			String path = request.getSession().getServletContext().getRealPath(ImgDir.getGoodsDir());

			GoodsInfo goodsInfoDB = goodsInfoMapper.selectByPrimaryKey(goodsInfo.getPkId());
			deleteGoodsImg(goodsInfoDB);

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

				goodsInfo.setImageDir(ImgDir.getGoodsDir() + fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void deleteGoodsImg(GoodsInfo goodsInfo) {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		if (goodsInfo != null && goodsInfo.getImageDir() != null) {
			String path = request.getSession().getServletContext().getRealPath(goodsInfo.getImageDir());
			File file = new File(path);
			if (file.exists() && file.isFile()) {
				file.delete();
			}
		}
	}

	public List<GoodsInfo> getGoodsInfoListByKeywords(String keywords, PageInfo pageInfo) {

		GoodsInfoExample goodsInfoExample = new GoodsInfoExample();
		GoodsInfoExample.Criteria goodsInfoExampleCriteria = goodsInfoExample.createCriteria();

		sorting(goodsInfoExample);

		goodsInfoExampleCriteria.andNameLike("%" + keywords + "%").andEnableEqualTo(true);

		List<GoodsInfo> goodsInfoList = pageInfo.selectByExample(goodsInfoMapper, goodsInfoExample);
		
		updateExposureList.addExposureInList(goodsInfoList);

		return goodsInfoList;
	}
	
	/*
	 * Goods Sorting
	 */
	private void sorting(GoodsInfoExample goodsInfoExample) {
		goodsInfoExample.setOrderByClause("WEIGHTS desc, EXPOSURE asc");
	}
}
