package com.catike_mall.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.catike_mall.dao.normal.GoodsDetailDisMapper;
import com.catike_mall.dao.normal.GoodsInfoMapper;
import com.catike_mall.dao.normal.InnerMailMapper;
import com.catike_mall.dao.normal.OrderInfoMapper;
import com.catike_mall.dao.normal.ShoppingCartMapper;
import com.catike_mall.dao.normal.StoreInfoMapper;
import com.catike_mall.dao.normal.UserInfoMapper;
import com.catike_mall.domain.entity.normal.GoodsDetailDis;
import com.catike_mall.domain.entity.normal.GoodsInfo;
import com.catike_mall.domain.entity.normal.InnerMail;
import com.catike_mall.domain.entity.normal.OrderInfo;
import com.catike_mall.domain.entity.normal.ShoppingCart;
import com.catike_mall.domain.entity.normal.StoreInfo;
import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.domain.entity.normal.UserInfoExample;
import com.catike_mall.service.VerService;

/**
 * @disc Entity Data Version Security Implement
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ5ÈÕ
 * @version v1.0.0
 */
@Service("VerService")
public class VerServiceImpl implements VerService {

	private UserInfoMapper userInfoMapper;
	private GoodsDetailDisMapper goodsDetailDisMapper;
	private GoodsInfoMapper goodsInfoMapper;
	private StoreInfoMapper storeInfoMapper;
	private ShoppingCartMapper shoppingCartMapper;
	private OrderInfoMapper orderInfoMapper;
	private InnerMailMapper innerMailMapper; 

	@Autowired
	public VerServiceImpl(UserInfoMapper userInfoMapper, GoodsDetailDisMapper goodsDetailDisMapper,
			GoodsInfoMapper goodsInfoMapper, StoreInfoMapper storeInfoMapper, ShoppingCartMapper shoppingCartMapper, OrderInfoMapper orderInfoMapper, InnerMailMapper innerMailMapper) {

		this.userInfoMapper = userInfoMapper;
		this.goodsDetailDisMapper = goodsDetailDisMapper;
		this.goodsInfoMapper = goodsInfoMapper;
		this.storeInfoMapper = storeInfoMapper;
		this.shoppingCartMapper = shoppingCartMapper;
		this.orderInfoMapper = orderInfoMapper;
		this.innerMailMapper = innerMailMapper;
	}

	public void entityCreate(Object obj) {
		fillCreateInfo(obj);
	}

	public boolean entityUpdate(Object obj) {

		boolean result = compareDataVersion(obj);
		if (!result) {
			throw new RuntimeException();
		}

		fillUpdateInfo(obj);

		return result;
	}

	public boolean entityDelete(Object obj) {

		return compareDataVersion(obj);
	}

	/**
	 * Fill Data In a New Entity
	 * 
	 * @param obj
	 */
	private void fillCreateInfo(Object obj) {

		Date date = new Date();
		UserInfo currentUserInfo = getCurrentUser();

		if (obj instanceof GoodsDetailDis) {
			GoodsDetailDis goodsDetailDis = (GoodsDetailDis) obj;

			goodsDetailDis.setPkId(null);

			goodsDetailDis.setMakeEmp(currentUserInfo.getPkId());
			goodsDetailDis.setMakeTime(date);
			goodsDetailDis.setModifyEmp(currentUserInfo.getPkId());
			goodsDetailDis.setModifyTime(date);

			goodsDetailDis.setVer(null);

		} else if (obj instanceof GoodsInfo) {
			GoodsInfo goodsInfo = (GoodsInfo) obj;

			goodsInfo.setPkId(null);

			goodsInfo.setMakeEmp(currentUserInfo.getPkId());
			goodsInfo.setMakeTime(date);
			goodsInfo.setModifyEmp(currentUserInfo.getPkId());
			goodsInfo.setModifyTime(date);

			goodsInfo.setVer(null);

		} else if (obj instanceof StoreInfo) {
			StoreInfo storeInfo = (StoreInfo) obj;

			storeInfo.setPkId(null);

			storeInfo.setMakeEmp(currentUserInfo.getPkId());
			storeInfo.setMakeTime(date);
			storeInfo.setModifyEmp(currentUserInfo.getPkId());
			storeInfo.setModifyTime(date);

			storeInfo.setVer(null);

		} else if (obj instanceof UserInfo) {
			UserInfo userInfo = (UserInfo) obj;

			userInfo.setPkId(null);

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			userInfo.setMakeIp(request.getRemoteAddr());
			userInfo.setMakeTime(date);
			userInfo.setModifyEmp(null);
			userInfo.setModifyTime(date);

			userInfo.setVer(null);
		} else if (obj instanceof ShoppingCart) {
			ShoppingCart shoppingCart = (ShoppingCart) obj;

			shoppingCart.setPkId(null);
			shoppingCart.setMakeEmp(currentUserInfo.getPkId());
			shoppingCart.setMakeTime(date);
			shoppingCart.setModifyEmp(currentUserInfo.getPkId());
			shoppingCart.setModifyTime(date);

			shoppingCart.setVer(null);
		}

	}

	/**
	 * Fill Data In a Update Entity
	 * 
	 * @param obj
	 */
	private void fillUpdateInfo(Object obj) {

		Date date = new Date();
		UserInfo currentUserInfo = getCurrentUser();

		if (obj instanceof GoodsDetailDis) {
			GoodsDetailDis goodsDetailDis = (GoodsDetailDis) obj;

			goodsDetailDis.setModifyEmp(currentUserInfo.getPkId());
			goodsDetailDis.setModifyTime(date);

			goodsDetailDis.setVer(goodsDetailDis.getVer() == null ? 0 : goodsDetailDis.getVer() + 1);

		} else if (obj instanceof GoodsInfo) {
			GoodsInfo goodsInfo = (GoodsInfo) obj;

			goodsInfo.setModifyEmp(currentUserInfo.getPkId());
			goodsInfo.setModifyTime(date);

			goodsInfo.setVer(goodsInfo.getVer() == null ? 0 : goodsInfo.getVer() + 1);

		} else if (obj instanceof StoreInfo) {
			StoreInfo storeInfo = (StoreInfo) obj;

			storeInfo.setModifyEmp(currentUserInfo.getPkId());
			storeInfo.setModifyTime(date);

			storeInfo.setVer(storeInfo.getVer() == null ? 0 : storeInfo.getVer() + 1);

		} else if (obj instanceof UserInfo) {
			UserInfo userInfo = (UserInfo) obj;

			userInfo.setModifyEmp(currentUserInfo.getPkId());
			userInfo.setModifyTime(date);

			userInfo.setVer(userInfo.getVer() == null ? 0 : userInfo.getVer() + 1);
		} else if (obj instanceof ShoppingCart) {
			ShoppingCart shoppingCart = (ShoppingCart) obj;

			shoppingCart.setModifyEmp(currentUserInfo.getPkId());
			shoppingCart.setModifyTime(date);

			shoppingCart.setVer(shoppingCart.getVer() == null ? 0 : shoppingCart.getVer() + 1);
		}

	}

	/**
	 * Compare Entity Version
	 * 
	 * @param obj
	 * @return true: version the same false: version error
	 */
	private boolean compareDataVersion(Object obj) {

		boolean result = false;

		if (obj == null) {
			return result;
		}

		if (obj instanceof GoodsDetailDis) {
			GoodsDetailDis goodsDetailDis = (GoodsDetailDis) obj;
			if (goodsDetailDis.getPkId() != null && goodsDetailDis.getVer() != null) {
				GoodsDetailDis goodsDetailDisDB = goodsDetailDisMapper.selectByPrimaryKey(goodsDetailDis.getPkId());
				if (goodsDetailDis.getVer() == goodsDetailDisDB.getVer()) {
					result = true;
				}
			}
		} else if (obj instanceof GoodsInfo) {
			GoodsInfo goodsInfo = (GoodsInfo) obj;
			if (goodsInfo.getPkId() != null && goodsInfo.getVer() != null) {
				GoodsInfo goodsInfoDB = goodsInfoMapper.selectByPrimaryKey(goodsInfo.getPkId());
				if (goodsInfo.getVer() == goodsInfoDB.getVer()) {
					result = true;
				}
			}
		} else if (obj instanceof StoreInfo) {
			StoreInfo storeInfo = (StoreInfo) obj;
			if (storeInfo.getPkId() != null && storeInfo.getVer() != null) {
				StoreInfo storeInfoDB = storeInfoMapper.selectByPrimaryKey(storeInfo.getPkId());
				if (storeInfo.getVer() == storeInfoDB.getVer()) {
					result = true;
				}
			}
		} else if (obj instanceof UserInfo) {
			UserInfo userInfo = (UserInfo) obj;
			if (userInfo.getPkId() != null && userInfo.getVer() != null) {
				UserInfo userInfoDB = userInfoMapper.selectByPrimaryKey(userInfo.getPkId());
				if (userInfo.getVer() == userInfoDB.getVer()) {
					result = true;
				}
			}
		} else if (obj instanceof ShoppingCart) {
			ShoppingCart shoppingCart = (ShoppingCart) obj;
			if (shoppingCart.getPkId() != null && shoppingCart.getVer() != null) {
				ShoppingCart shoppingCartDB = shoppingCartMapper.selectByPrimaryKey(shoppingCart.getPkId());
				if (shoppingCart.getVer() == shoppingCartDB.getVer()) {
					result = true;
				}
			}
		} else if (obj instanceof OrderInfo) {
			OrderInfo orderInfo = (OrderInfo) obj;
			if (orderInfo.getPkId() != null && orderInfo.getVer() != null) {
				OrderInfo orderInfoDB = orderInfoMapper.selectByPrimaryKey(orderInfo.getPkId());
				if (orderInfo.getVer() == orderInfoDB.getVer()) {
					result = true;
				}
			}
		} else if (obj instanceof InnerMail) {
			InnerMail innerMail = (InnerMail) obj;
			if (innerMail.getPkId() != null && innerMail.getVer() != null) {
				InnerMail innerMailDB = innerMailMapper.selectByPrimaryKey(innerMail.getPkId());
				if (innerMail.getVer() == innerMailDB.getVer()) {
					result = true;
				}
			}
		}
		return result;
	}

	private UserInfo getCurrentUser() {

		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal instanceof UserDetails) {
				UserDetails userDetails = (UserDetails) principal;

				UserInfo userInfo;

				UserInfoExample userInfoExample = new UserInfoExample();

				UserInfoExample.Criteria userInfoExampleCriteria = userInfoExample.createCriteria();
				userInfoExampleCriteria.andUsernameEqualTo(userDetails.getUsername());

				List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);

				if (userInfoList.size() < 1) {
					userInfo = null;
				} else {
					userInfo = userInfoList.get(0);
				}
				return userInfo;
			}
		}
		return null;
	}

}
