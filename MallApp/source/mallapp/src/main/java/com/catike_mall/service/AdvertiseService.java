package com.catike_mall.service;

import org.springframework.ui.Model;

/**
 * @disc Advertisement Function
 * 
 * @author Ma Xuefeng
 * @date 2017Äê8ÔÂ20ÈÕ
 * @version v1.0.0
 */

public interface AdvertiseService {
	
	/**
	 * Add All AdvertiseService
	 * 
	 * @param model
	 */
	void addAllAdvertiseService(Model model);
	
	/**
	 * Add AdvertiseService , POSITION : WithGoodsList
	 * 
	 * @param model
	 */
	void withGoodsList(Model model);
	
	/**
	 * Add AdvertiseService , POSITION : TopOfHomepage 
	 * 
	 * @param model
	 */
	void topOfHomepage(Model model);

}