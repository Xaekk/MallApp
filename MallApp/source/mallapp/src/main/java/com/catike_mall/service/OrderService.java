package com.catike_mall.service;

import java.util.List;

import com.catike_mall.domain.entity.normal.OrderInfo;
import com.catike_mall.domain.entity.normal.ShoppingCart;

/**
 * @disc Order Service
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ26ÈÕ
 * @version v1.0.0
 */

public interface OrderService {
	
	/**
	 * Add Order By Shopping Cart
	 * 
	 * @param shoppingCart
	 */
	OrderInfo addOrderInfoByShoppingCart(ShoppingCart shoppingCart);
	
	/**
	 * delete OrderInfo By Pkid
	 * 
	 * @param Pkid
	 */
	void deleteOrderInfoByPkid(int Pkid);
	
	/**
	 * Change OrderInfo Status By Pkid
	 * 
	 * @param Pkid
	 * @param bool
	 * @return
	 */
	OrderInfo changeOrderInfoStatusByPkid(int Pkid, boolean bool);
	
	/**
	 * Select OrderInfo By Pkid
	 * 
	 * @param Pkid
	 * @return
	 */
	OrderInfo selectOrderInfoByPkid(int Pkid);
	
	/**
	 * Select OrderInfo Of Buyyer By CurrentUser
	 * 
	 * @return
	 */
	List<OrderInfo> selectOrderInfoOfBuyyerByCurrentUser();
	
	/**
	 * Select OrderInfo Of Seller By CurrentUser
	 * 
	 * @return
	 */
	List<OrderInfo> selectOrderInfoOfSellerByCurrentUser();

}
