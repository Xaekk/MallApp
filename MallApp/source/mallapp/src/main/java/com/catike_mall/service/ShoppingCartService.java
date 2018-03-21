package com.catike_mall.service;

import java.util.List;

import com.catike_mall.domain.entity.normal.ShoppingCart;

/**
 * @disc ShoppingCartService
 * 
 * @author Ma Xuefeng
 * @date 2017��8��26��
 * @version v1.0.0
 */

public interface ShoppingCartService {
	
	/**
	 * Add Shopping Cart
	 * 
	 * @param shoppingCart
	 * @return
	 */
	ShoppingCart addShoppingCart(ShoppingCart shoppingCart);
	
	/**
	 * Delete Shopping Cart By Pkid
	 * 
	 * @param Pkid
	 */
	void deleteShoppingCartByPkid(int Pkid, int ver);

	/**
	 * Get Shopping Cart By Pkid
	 * 
	 * @param Pkid
	 * @return
	 */
	ShoppingCart getShoppingCartByPkid(int Pkid);
	
	/**
	 * Get Shopping Cart List By Current User
	 * 
	 * @return
	 */
	List<ShoppingCart> getShoppingCartListByCurrentUser();
}
