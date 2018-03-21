package com.catike_mall.util;

import java.util.List;

import org.springframework.ui.Model;

import com.catike_mall.dao.normal.GoodsInfoMapper;
import com.catike_mall.dao.normal.StoreInfoMapper;
import com.catike_mall.dao.normal.UserInfoMapper;
import com.catike_mall.domain.entity.normal.GoodsInfo;
import com.catike_mall.domain.entity.normal.GoodsInfoExample;
import com.catike_mall.domain.entity.normal.StoreInfo;
import com.catike_mall.domain.entity.normal.StoreInfoExample;
import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.domain.entity.normal.UserInfoExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class PageInfo {
	
	public static int pageNumSta = 1;
	public static int pageSizeSta = 12;

	private long total;
	private int pageNum;
	private int pageSize;

	private Model model;


	/**
	 * Init PageInfo
	 * 
	 * @param pageNum
	 * @param pageSize
	 */
	private void init(Integer pageNum, Integer pageSize){
		if (pageNum == null || pageNum < 1) {
			this.setPageNum(pageNumSta);
		}else{
			this.setPageNum(pageNum);
		}
		
		if (pageSize == null || pageSize < 1) {
			this.setPageSize(pageSizeSta);
		}else{
			this.setPageSize(pageSize);
		}
	}
	
	/**
	 * Construct PageInfo (default)
	 */
	public PageInfo() {
		total = 0;
		pageNum = pageNumSta;
		pageSize = pageSizeSta;
	}

	/**
	 * Construct PageInfo
	 * 
	 * @param pageNum
	 *            : the No. of Page
	 * @param pageSize
	 *            : the Size of One Page
	 */
	public PageInfo(int pageNum, int pageSize) {
		total = 0;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	/**
	 * Construct PageInfo (default, with [Model] of Controller)
	 */
	public PageInfo(Model model) {
		total = 0;
		pageNum = pageNumSta;
		pageSize = pageSizeSta;
		this.model = model;
	}

	/**
	 * Construct PageInfo , with [Model] of Controller
	 * 
	 * @param pageNum
	 *            : the No. of Page
	 * @param pageSize
	 *            : the Size of One Page
	 */
	public PageInfo(int pageNum, int pageSize, Model model) {
		total = 0;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.model = model;
	}

	/**
	 * Used for Controller, to get a New PageInfo Caution : the Method is static
	 * 
	 * @param pageNum
	 *            : the No. of a Page
	 * @param pageSize
	 *            : the Size of a Page
	 * @return PageInfo : a new PageInfo
	 */
	public static PageInfo newPageInfo() {

		PageInfo pageInfo = new PageInfo();

		return pageInfo;
	}

	/**
	 * Used for Controller, to get a New PageInfo Caution : the Method is static
	 * 
	 * @param model
	 *            : the Model of Controller
	 * @return PageInfo : a new PageInfo
	 */
	public static PageInfo newPageInfo(Model model) {

		PageInfo pageInfo = new PageInfo(model);

		return pageInfo;
	}

	/**
	 * Make a PageInfo, whether use PageInfo
	 * 
	 * @param bool
	 *            : true --> List as Default Result (pageNum = 1, pageSize = 20)
	 *            false --> List All Result
	 * @return
	 */
	public static PageInfo newPageInfo(boolean bool) {

		PageInfo pageInfo;

		if (bool) {
			pageInfo = new PageInfo();
		} else {
			pageInfo = new PageInfo(1, 0);
		}

		return pageInfo;
	}

	/**
	 * Make a PageInfo, whether use PageInfo
	 * 
	 * @param bool
	 *            : true --> List as Default Result (pageNum = 1, pageSize = 20)
	 *            false --> List All Result
	 * @param model
	 *            : the Model of Controller
	 * @return
	 */
	public static PageInfo newPageInfo(boolean bool, Model model) {

		PageInfo pageInfo;

		if (bool) {
			pageInfo = new PageInfo(model);
		} else {
			pageInfo = new PageInfo(1, 0, model);
		}

		return pageInfo;
	}

	/**
	 * Used for Controller, to get a New PageInfo Caution : the Method is static
	 * 
	 * @param pageNum
	 *            : the No. of a Page
	 * @param pageSize
	 *            : the Size of a Page
	 * @return PageInfo : a new PageInfo
	 */
	public static PageInfo newPageInfo(Integer pageNum, Integer pageSize) {

		PageInfo pageInfo = new PageInfo();

		pageInfo.init(pageNum, pageSize);

		return pageInfo;
	}

	/**
	 * Used for Controller, to get a New PageInfo Caution : the Method is static
	 * 
	 * @param pageNum
	 *            : the No. of a Page
	 * @param pageSize
	 *            : the Size of a Page
	 * @param model
	 *            : the Model of Controller
	 * @return PageInfo : a new PageInfo
	 */
	public static PageInfo newPageInfo(Integer pageNum, Integer pageSize, Model model) {

		PageInfo pageInfo = new PageInfo(model);

		pageInfo.init(pageNum, pageSize);

		return pageInfo;
	}

	/**
	 * Add Attribute in [Model] of [Controller]
	 * 
	 * @param model
	 *            : [Model] of [Controller]
	 */
	public void addInModel(Model model) {

		if (model != null) {
			model.addAttribute("pageTotal", this.total);
			model.addAttribute("pageNum", this.pageNum);
			model.addAttribute("pageSize", this.pageSize);

			long totalPages = (this.total / this.pageSize) + 1;
			if((this.total % this.pageSize)==0) totalPages--;
			model.addAttribute("totalPages", totalPages);
		}
	}

	/*
	 * Used in Internal Class , Add Attribute into Model (default)
	 */
	private void addInModel() {
		addInModel(this.model);
	}

	/**
	 * MyBatis Plugin : PageHelper.startPage
	 */
	public void startPage() {
		PageHelper.startPage(this.pageNum, this.pageSize);
	}

	/**
	 * in [ServiceImpl] , selectByExample , belong [GoodsInfo]
	 * 
	 * @param goodsInfoMapper
	 *            : Mybatis [Mapper]
	 * @param goodsInfoExample
	 *            : Mybatis [Example]
	 * @return List<GoodsInfo> : select Resualt
	 */
	public List<GoodsInfo> selectByExample(GoodsInfoMapper goodsInfoMapper, GoodsInfoExample goodsInfoExample) {

		this.startPage();
		List<GoodsInfo> list = goodsInfoMapper.selectByExample(goodsInfoExample);
		this.setTotal(list);

		addInModel();

		return list;
	}

	/**
	 * in [ServiceImpl] , selectByExample , belong [StoreInfo]
	 * 
	 * @param storeInfoMapper
	 *            : Mybatis [Mapper]
	 * @param storeInfoExample
	 *            : Mybatis [Example]
	 * @return List<StoreInfo> : select Resualt
	 */
	public List<StoreInfo> selectByExample(StoreInfoMapper storeInfoMapper, StoreInfoExample storeInfoExample) {

		this.startPage();
		List<StoreInfo> list = storeInfoMapper.selectByExample(storeInfoExample);
		this.setTotal(list);

		addInModel();

		return list;
	}

	/**
	 * in [ServiceImpl] , selectByExample , belong [UserInfo]
	 * 
	 * @param UserInfoMapper
	 *            : Mybatis [Mapper]
	 * @param UserInfoExample
	 *            : Mybatis [Example]
	 * @return List<UserInfo> : select Resualt
	 */
	public List<UserInfo> selectByExample(UserInfoMapper userInfoMapper, UserInfoExample userInfoExample) {

		this.startPage();
		List<UserInfo> list = userInfoMapper.selectByExample(userInfoExample);
		this.setTotal(list);

		addInModel();

		return list;
	}

	/**
	 * set [Total] param
	 * 
	 * @param list
	 */
	public void setTotal(List<?> list) {
		this.total = ((Page) list).getTotal();
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public long getTotal() {
		return total;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
