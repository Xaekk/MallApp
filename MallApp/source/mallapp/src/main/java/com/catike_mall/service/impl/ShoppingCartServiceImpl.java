package com.catike_mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catike_mall.dao.normal.ShoppingCartMapper;
import com.catike_mall.domain.entity.normal.ShoppingCart;
import com.catike_mall.domain.entity.normal.ShoppingCartExample;
import com.catike_mall.domain.entity.normal.UserInfo;
import com.catike_mall.service.CurrentUserService;
import com.catike_mall.service.ShoppingCartService;
import com.catike_mall.service.VerService;

/**
 * @disc ShoppingCart Service Impl
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ26ÈÕ
 * @version v1.0.0
 */
@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private ShoppingCartMapper shoppingCartMapper;
	private CurrentUserService currentUserService;
	private VerService verService;
	
	@Autowired
	public ShoppingCartServiceImpl(ShoppingCartMapper shoppingCartMapper, VerService verService, CurrentUserService currentUserService){
		this.shoppingCartMapper = shoppingCartMapper;
		this.verService = verService;
		this.currentUserService = currentUserService;
	}

	public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
		
		verService.entityCreate(shoppingCart);
		
		int pkId = shoppingCartMapper.insertSelective(shoppingCart);
		
		shoppingCart = shoppingCartMapper.selectByPrimaryKey(pkId);
		
		return shoppingCart;
	}

	public void deleteShoppingCartByPkid(int Pkid, int ver) {
		
		ShoppingCart shoppingCart = new ShoppingCart();
		
		shoppingCart.setPkId(Pkid);
		shoppingCart.setVer(ver);
		
		if(verService.entityDelete(shoppingCart)){
			shoppingCartMapper.deleteByPrimaryKey(Pkid);
		}
		
	}

	public ShoppingCart getShoppingCartByPkid(int Pkid) {
		
		ShoppingCart shopping = shoppingCartMapper.selectByPrimaryKey(Pkid);
		
		return shopping;
	}

	public List<ShoppingCart> getShoppingCartListByCurrentUser() {
		UserInfo userInfo = currentUserService.getCurrentUser();
		
		ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
		ShoppingCartExample.Criteria shoppingCartExampleCriteria = shoppingCartExample.createCriteria();
		
		shoppingCartExampleCriteria.andBuyyerPkidEqualTo(userInfo.getPkId());
		
		List<ShoppingCart> shoppingCartList = shoppingCartMapper.selectByExample(shoppingCartExample);
		
		return shoppingCartList;
	}
}
