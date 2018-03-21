package com.catike_mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.catike_mall.service.OrderService;

/**
 * @disc Order Controller
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ26ÈÕ
 * @version v1.0.0
 */
@Controller
public class OrderController {
	
	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService){
		this.orderService = orderService;
	}
}
