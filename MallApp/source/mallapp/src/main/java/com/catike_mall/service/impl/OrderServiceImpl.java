package com.catike_mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catike_mall.dao.normal.OrderInfoMapper;
import com.catike_mall.domain.entity.normal.OrderInfo;
import com.catike_mall.domain.entity.normal.ShoppingCart;
import com.catike_mall.service.OrderService;

/**
 * @disc Order Service Impl
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ26ÈÕ
 * @version v1.0.0
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private OrderInfoMapper orderInfoMapper;
	
	@Autowired
	public OrderServiceImpl(OrderInfoMapper orderInfoMapper){
		this.orderInfoMapper = orderInfoMapper; 
	}

	/* (non-Javadoc)
	 * @see com.catike_mall.service.OrderService#addOrderInfoByShoppingCart(com.catike_mall.domain.entity.normal.ShoppingCart)
	 */
	public OrderInfo addOrderInfoByShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.catike_mall.service.OrderService#deleteOrderInfoByPkid(int)
	 */
	public void deleteOrderInfoByPkid(int Pkid) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.catike_mall.service.OrderService#changeOrderInfoStatusByPkid(int, boolean)
	 */
	public OrderInfo changeOrderInfoStatusByPkid(int Pkid, boolean bool) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.catike_mall.service.OrderService#selectOrderInfoByPkid(int)
	 */
	public OrderInfo selectOrderInfoByPkid(int Pkid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.catike_mall.service.OrderService#selectOrderInfoOfBuyyerByCurrentUser()
	 */
	public List<OrderInfo> selectOrderInfoOfBuyyerByCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.catike_mall.service.OrderService#selectOrderInfoOfSellerByCurrentUser()
	 */
	public List<OrderInfo> selectOrderInfoOfSellerByCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
